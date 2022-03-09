package realpack;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class Players implements Runnable {

    String hostName = "localHost";
    int PORT = 2901;
    private Socket clientSocket;
    private Game game = new Game();
    private Prompt prompt;
    private StringInputScanner question;
    private LinkedList <String> nickname = new LinkedList<>();



    public Players(Socket socket) {

        this.clientSocket = socket;
        {
            try {
                prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        game.init();
    }

    public void init() throws IOException {

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while ((clientSocket.isConnected())) {
            out.write(reader.readLine());
            out.flush();
        }
    }


    public void send(Art art) {
        String randomImage = art.getAsciiArt();
        StringInputScanner question = new StringInputScanner();
        question.setMessage(randomImage);


        String answer = prompt.getUserInput(question);
        System.out.println("they said " + answer);

        compareInput(answer, art);
        // if its not what we want, repeat the question
    }

    public void compareInput(String playerAnswer, Art art){

        String correctAnswer = art.getName();

        if (!playerAnswer.equalsIgnoreCase(correctAnswer)){
            send(art);
            return;
        }

        send(game.getRandomImage());
    }


    @Override
    public void run() {
        String[] menu = { "Press 1 to Start Game!!"
                };
        MenuInputScanner scanner = new MenuInputScanner(menu);
        scanner.setMessage(Messages.ANSI_GREEN + Messages.WELL + Messages.ANSI_RESET);



        try {
            Prompt prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));
            StringInputScanner question1 = new StringInputScanner();
            question1.setMessage(Messages.ANSI_GREEN + Messages.WEL + Messages.ANSI_RESET);
            nickname.add(prompt.getUserInput(question1));
            //String winner = nickname.getFirst();
            prompt.getUserInput(scanner);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //WHEN MAXIMUM HAS CONNECTED, SEND A RANDOM IMAGE!
        // loop for the amount of rounds
        int rounds = 0;
        while (rounds < 3){
            send(game.getRandomImage());
            rounds ++;
            }
        System.out.println("Thank your for comming! Well done!");
        }


        // server.iFinished(myname)
    }




