package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;
    private String serverAddress;
    private int serverPort;
    private String userName;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Что-то пошло не так...");
                return;
            }
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено.\n" +
                    "Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        while (clientConnected) {
            String strConsole = ConsoleHelper.readString();
            if (strConsole.equals("exit")) {
                break;
            }
            if (shouldSendTextFromConsole()) {
                sendTextMessage(strConsole);
            }
        }
    }

    public class SocketThread extends Thread {

    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите адрес порта сервера:");
        serverPort = ConsoleHelper.readInt();
        return serverPort;
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Представьтесь:");
        userName = ConsoleHelper.readString();
        return userName;
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Не удалось отправить сообщение");
            clientConnected = false;
        }
    }
}
