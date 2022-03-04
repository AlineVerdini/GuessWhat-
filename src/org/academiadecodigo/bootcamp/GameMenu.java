package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.util.Scanner;

public class GameMenu {

    public class Menu {

        private GameMenu game;

        public Menu() {

            game = new GameMenu();
        }

        public void gameInit(){
        String[] menu = {
                "Play","Not to play"};
            System.out.println("Banana");
        MenuInputScanner scanner = new MenuInputScanner(menu);
        scanner.setMessage("Should i play or not?");
            System.out.println("Maçã");
        };
       //int answerIndex = prompt.getUserInput();
    }

  /*  public GameInit(){
        game.init();
    }

    public GameStart(){
        game.start();
    }*/
}

