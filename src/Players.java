import org.academiadecodigo.bootcamp.Messages;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.io.*;
import java.net.Socket;

public class Players implements Runnable {

    String hostName = "localHost";
    int PORT = 2901;
    private Socket clientSocket;


    public Players(Socket socket) {

        this.clientSocket = socket;
    }



    public void init() throws IOException {

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while ((clientSocket.isConnected())) {
            out.write(reader.readLine());
            out.flush();
        }
    }

    @Override
    public void run() {
        String[] menu = {
                "Play",
                "Not to play"};
        System.out.println("Banana");
        MenuInputScanner scanner = new MenuInputScanner(menu);
        scanner.setMessage(Messages.ANSI_PURPLE + Messages.WEL);

        try {
            Prompt prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));
            prompt.getUserInput(scanner);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
