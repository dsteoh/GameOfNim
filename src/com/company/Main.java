package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialize Game object
        Game game = new Game();

        //Scanner object to read player's input
        Scanner scanner = new Scanner(System.in);

        //Ask for player 1's name and create player object
        System.out.print("Welcome to Nim");
        System.out.print("Please enter Player 1's name: ");
        String playerName = scanner.next();
        Player player1 = new Player(playerName);

        //Ask for player 2's name and create player object
        System.out.print("Please enter Player 2's name: ");
        String playerName2 = scanner.next();
        Player player2 = new Player(playerName2);

        //Start game
        game.startGame(player1, player2);
        //Ask if user wants to play again
        game.playAgain(player1, player2);
    }
}
