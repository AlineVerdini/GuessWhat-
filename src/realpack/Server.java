package realpack;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

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
    private Game game;

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

        while (maxPlayers > 0) {
            try {
                // ACCEPT MAXIMUM AMOUNT OF PLAYERS
                Socket socket = serverSocket.accept();
                Players worker = new Players(socket);

                System.out.println("Player Accept");
                clientList.add(worker);
                fixedPool.submit(worker);

                maxPlayers--;


            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] menu = {
            };
            MenuInputScanner scanner = new MenuInputScanner(menu);
            scanner.setMessage((Messages.ANSI_YELLOW + Messages.WEL + Messages.ANSI_RESET));
        }



       // fixedPool.shutdown();
    }
}

