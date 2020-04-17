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
        public void run() {
            Socket socket;
            try {
                socket = new Socket(getServerAddress(),getServerPort());
                Connection connection = new Connection(socket);
                Client.this.connection = connection;

                clientHandshake();
                clientMainLoop();

            } catch (IOException e) {
                e.printStackTrace();
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                notifyConnectionStatusChanged(false);
            }
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("%s присоединился к чату!", userName));
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("%s покинул чат.", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

                if (message.getType() != MessageType.NAME_REQUEST
                        && message.getType() != MessageType.NAME_ACCEPTED) {
                    throw new IOException("Unexpected MessageType");
                }

                switch (message.getType()) {
                    case NAME_REQUEST:
                        connection.send(new Message(MessageType.USER_NAME, getUserName()));
                        break;
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        return;
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message;

                try {
                    message = connection.receive();
                } catch (IOException e) {
                    break;
                }

                if (message.getType() != MessageType.TEXT
                        && message.getType() != MessageType.USER_ADDED
                        && message.getType() != MessageType.USER_REMOVED) {
                    throw new IOException("Unexpected MessageType");
                }

                switch (message.getType()) {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                }
            }
        }
    }

    protected String getServerAddress() throws IOException {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }

    protected int getServerPort() throws IOException {
        ConsoleHelper.writeMessage("Введите адрес порта сервера:");
        serverPort = ConsoleHelper.readInt();
        return serverPort;
    }

    protected String getUserName() throws IOException {
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
