package realpack;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import realpack.Art;
import realpack.Ascii;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;

public class Game {

    private HashMap<Integer, Art> hashMap;
    private Socket player;
    private String prefix = "resources/";
    private HashSet <Integer> setList;
    private Prompt prompt = new Prompt(System.in, System.out);
    private StringInputScanner question;


    public Game() {
        this.hashMap = new HashMap();
        this.question = new StringInputScanner();

    }

    /**preparing game and putting enum into hashmap*/

    public void init() {
        setList = new HashSet<>();

        hashMap.put(1, Art.BEAR);
        hashMap.put(2, Art.CAT);
        hashMap.put(3, Art.RHINO);
        hashMap.put(4, Art.DOG);

    }

    /**Getting random number and associating it to an image*/
    /**If random number already been chosen, get another random number*/

    public String getRandomImage(){

        int randomNum= (int) Math.ceil(Math.random()*4);

        while (setList.contains(randomNum)) {
            randomNum= (int) Math.ceil(Math.random()*4);
        }

        setList.add(randomNum);
        Art art = hashMap.get(randomNum);
        System.out.println(art.getAsciiArt());
        String imageName = art.getName();
        return imageName;


    }
    /** comparing client input with string associated to image*/
    public boolean compareInput(String correctAnswer){
        question.setMessage("Guess what");
        String answer = prompt.getUserInput(question);
        String answerInLowerCase = answer.toLowerCase();
        if(answerInLowerCase.equals(correctAnswer)){
            return true;
        }
        return false;
    }

    public void start() {

    }


    public void showImage() throws IOException {


        System.out.println(Ascii.BEAR);

        System.out.println(Ascii.CAT);

        System.out.println(Ascii.RHINOCERO);

        System.out.println(Ascii.SCORPION);

        System.out.println(Ascii.DOG);

        System.out.println(Ascii.DUCK);

        /*String result = "";
        BufferedReader bReader = new BufferedReader(new FileReader(prefix + "bear.txt"));
        result = bReader.readLine();
        String image = "";

        while (result != null) {
            image = image + result + "\n";
            result = bReader.readLine();
        }
        System.out.println(image);*/
    }


}
