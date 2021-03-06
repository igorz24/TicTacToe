package main;

import java.util.Scanner;

 class IO {

    private String input;
    private int row;
    private int column;

    // Enum that helps to describe which message to print
    public enum messageType{
        welcomePlayer,
        askForInput,
        informWhoseTurnItIs,
        informAboutWrongInput,
        informAboutWrongMove,
        informWhoWon,
        informAboutTie
     }

    // Method that prints the game board
    void printGameBoard(char[][] board){
        // If null - return
        if (board == null) return;

        //Display column letters
        System.out.print("  A B C\n");

        // For each row
        for(int i = 0; i < board.length; i++){
            // Display row numbers
            System.out.print(i+1);
            // for each field in this row
            for(int j = 0; j < board[i].length; j++)
                System.out.print(" " + board[i][j]);
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    // Print String to the console
     void printString(String str){

         System.out.println(str);

     }

    // Gets the input from user- returs true if everything correcr, false otherwise
    boolean getInputFromUser(){
        // Create scanner
        Scanner scanner = new Scanner(System.in);
        // Get the input
        input = scanner.next();
        // Check if provided input is length-wise correct
        if(input.length() > 2 || input.length() == 0) return false;
        //Check if row number is correct
        if(!processRow()) return false;
        return processColumn();
    }

    // Prints message of the provided number on screen
    void printMessage(int messageNumber, char playersChar){
        messageType mt = messageType.values()[messageNumber];
        switch(mt){
            case welcomePlayer:
                System.out.println("\nWitamy w grze kółko i krzyżyk\n"); break;
            case askForInput:
                System.out.println("Wprowadź dane (<litera><liczba>)\n"); break;
            case informWhoseTurnItIs:
                System.out.println("Teraz ruch gracza: " + playersChar + "\n"); break;
            case informAboutWrongInput:
                System.out.println("Wprowadzono błędne dane. Poprawny format to <liczba><litera> lub odwrotnie\n"); break;
            case informAboutWrongMove:
                System.out.println("Niepoprawny ruch, pole jest już zajęte.\n"); break;
            case informWhoWon:
                System.out.println("Zwycięzcą jest gracz " + playersChar + "\n"); break;
            case informAboutTie:
                System.out.println("Doszło do remisu\n"); break;
            default:
                System.out.println("Niepoprawny komunikat\n"); break;
        }
    }

    // Processes data from input into column
    private boolean processColumn(){
        if(input.contains("a") || input.contains("A")) column = 0;
        else if(input.contains("b") || input.contains("B")) column = 1;
        else if(input.contains("c") || input.contains("C")) column = 2;
        else return false;

        return true;
    }

    // Processes data from input into row
    private boolean processRow(){
        if(input.contains("1")) row = 0;
        else if(input.contains("2")) row = 1;
        else if(input.contains("3") ) row = 2;
        else return false;

        return true;
    }

    // Getters
    int getColumn() {

        return column;
    }

    int getRow() {

        return row;
    }
}
