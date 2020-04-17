package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (String name: connectionMap.keySet()) {
            try {
                connectionMap.get(name).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(String.format("Can't send the message to %s", name));
            }
        }
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            System.out.println("Server has started");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message messageOut = new Message(MessageType.NAME_REQUEST);
            Message messageIn;
            String name = null;

            do {
                connection.send(messageOut);
                messageIn = connection.receive();
                name = messageIn.getData();
            } while (messageIn.getType() != MessageType.USER_NAME || name.isEmpty() || connectionMap.containsKey(name));

            connectionMap.put(name, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));

            return name;
        }
    }
}
