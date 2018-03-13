package com.company;
import java.util.Scanner;

public class Game {

    static int numberOfStones;
    int upperBond;

    //Scanner object to read player's input
    Scanner scanner = new Scanner(System.in);

    //Main method that starts the game and initializes the variables
    public void StartGame(Player playerOne, Player playerTwo) {

        //This variable returns an int of 1 or 2 to (We use this to determine who starts first)
        int turnKeeper = Dice();

        //The upperBond has to be bigger than 0 we will prompt the user to enter a number > 0
        while(upperBond <= 0)
        {
            //Try catch statements handles exception if the user inputs a string instead of an int
            try{
                System.out.print("Please enter upper bound of stone removal: ");
                String input = scanner.next();
                upperBond = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("Invalid number please try again");
            }
        }

        //To start the game numberOfStones must be bigger than 1
        while(numberOfStones <= 1)
        {
            //Try catch statements handles exception if the user inputs a string instead of an int
            try{
                System.out.print("Please enter initial number of stones: ");
                String input = scanner.next();
                numberOfStones = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("Invalid number please try again");
            }
        }

        //If there is still stones we will keep looping each player's turn
        while(numberOfStones > 0)
        {
            //Each turn is determined by the variable turnKeeper 1=Player1 2=Player2
            if(turnKeeper == 1)
            {
                //Print the stones left in the game
                PrintStonesLeft();
                PlayerTurn(playerOne);
                turnKeeper = 2;
            }
            else
            {
                PrintStonesLeft();
                PlayerTurn(playerTwo);
                turnKeeper = 1;
            }
        }
    }

    //Takes a player object and handles the game's player turn
    public void PlayerTurn(Player player) {

        System.out.println(" "+player.Name + "'s turn - remove how many? ");
        String input = scanner.next();

        try{
            int remove = Integer.parseInt(input);
            //If the input is larger than our number of stone or our upper bond we will prompt the user to try again.
            while(remove > numberOfStones || remove > upperBond)
            {
                System.out.println("Invalid number please try again ");
                remove = scanner.nextInt();
                continue;
            }
            //Else we will proceed with the game (removing the stone)
            player.removeStone(remove);
            //Check if there is a winner after removing stones.
            CheckForWinner(player);
        }catch (NumberFormatException e)
        {
            System.out.println("Invalid number please try again ");
            PlayerTurn(player);
        }
    }

    public void PrintStonesLeft() {
        System.out.print(numberOfStones + " stones left: ");
        for(int i = 0; i < numberOfStones; i++)
        {
            System.out.print("*");
        }
    }

    public boolean CheckForWinner(Player player) {
        if(numberOfStones == 0)
        {
            System.out.println("Game Over!");
            System.out.println(player.Name + " 'Wins!");
            upperBond = 0;
            return true;
        }
        return false;
    }

    public static int RemoveStone(int num){
        return numberOfStones -= num;
    }

    public void PlayAgain(Player playerOne, Player playerTwo) {
        System.out.println("Do you want to play again? (Y/N)");
        String input = scanner.next().toLowerCase();

        while(!input.equals("y") && !input.equals("n"))
        {
            System.out.println("Do you want to play again? (Y/N)");
            input = scanner.next().toLowerCase();
        }
        if(input.equals("y"))
            StartGame(playerOne, playerTwo);
        else if(input.equals("n"))
            return;

    }

    public int Dice() {
        return (int)(Math.random()*2);
    }
}
