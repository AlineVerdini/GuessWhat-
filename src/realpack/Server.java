package realpack;

import org.academiadecodigo.bootcamp.Prompt;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final int PORT = 2901;
    private ServerSocket serverSocket;
    private int maxPlayers = 10;
    private LinkedList<Players> clientList = new LinkedList<>();

    private Prompt prompt = new Prompt(System.in, System.out);


    public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverAccept() {

        ExecutorService fixedPool = Executors.newFixedThreadPool(10);
        int counterSocket = 0;
        while (!serverSocket.isClosed()) {
            try {
                if (maxPlayers >= 1) {
                    Socket socket = serverSocket.accept();

                    Players worker = new Players(socket);
                    System.out.println("Player Accept");
                    clientList.add(worker);
                    System.out.println("Player ADDED!");
                    fixedPool.submit(worker);
                    counterSocket++;
                    maxPlayers--;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fixedPool.shutdown();
    }
}

