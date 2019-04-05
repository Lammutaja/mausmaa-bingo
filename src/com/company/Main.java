/*
Author: Mihkel Ausmaa
Last updated: 05.04.2019

Main class where new object with attributes will be called to generate bingo board.
User input needed to generate win situation.
User input needed to close the program.
*/


package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        BingoBoard bingoBoard = new BingoBoard("|   ", "|",'X',
                "---------------------", "BINGO",5, 5);

        char exitProgram = 'n';
        String inputExit;
        String inputSolution;

        Scanner scan = new Scanner(System.in);

        //loop to keep program running until user says otherwise
        while (exitProgram != 'y') {
            System.out.println("Please write one of these 3 win situations:"
                    + "\n Corners"
                    + "\n Diagonals"
                    + "\n Full");

            inputSolution = scan.next().toUpperCase();

            //check user input and generate win situation accordingly
            if (inputSolution.equals("CORNERS") || inputSolution.equals("DIAGONALS") || inputSolution.equals("FULL")) {
                bingoBoard.generateBoardData(inputSolution);
                System.out.println(inputSolution);

            } else {
                System.out.println("Incorrect input, please try again");
            }

            //check if user wants to end program's work
            System.out.print("Would you like to quit y/n? ");
            inputExit = scan.next().toLowerCase();
            exitProgram = inputExit.charAt(0);

        }
    }
}
