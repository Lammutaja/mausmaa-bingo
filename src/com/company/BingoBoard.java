/*
Author: Mihkel Ausmaa
Last updated: 05.04.2019

Class Bingoboard. Create empty bingo board and logic to generate different win situations.
Have to clear board every time new situation is called.
*/

package com.company;

public class BingoBoard {

    private char[] emptyCell;
    private char[] wall;
    private char filledCell;

    private String rowSeparator;
    private String bingo;

    private int dimensionX;
    private int dimensionY;

    private int[][] boardData = new int[5][5];

    //constructor for bingo board
    public BingoBoard(String emptyCell, String wall, char filledCell, String rowSeparator,String bingo, int dimensionX, int dimensionY) {
        this.emptyCell = emptyCell.toCharArray();
        this.wall = wall.toCharArray();
        this.filledCell = filledCell;
        this.rowSeparator = rowSeparator;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.bingo = bingo;
    }

    public char[] getEmptyCell() {
        return emptyCell;
    }

    public void setEmptyCell(String emptyCell) {
        this.emptyCell = emptyCell.toCharArray();
    }

    public char getFilledCell() {
        return filledCell;
    }

    public void setFilledCell(char filledCell) {
        this.filledCell = filledCell;
    }

    public String getRowSeperator() {
        return rowSeparator;
    }

    public char[] getWall() {
        return wall;
    }

    public void setWall(char[] wall) {
        this.wall = wall;
    }

    public void setRowSeperator(String rowSeparator) {
        this.rowSeparator = rowSeparator;
    }

    public String getBingo() {
        return bingo;
    }

    public void setBingo(String bingo) {
        this.bingo = bingo;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

    //method to generate board header
    private void generateHeader() {
        char[] localCell = emptyCell.clone();
        for (int i = 0; i < dimensionX; i++) {
            localCell[2] = bingo.charAt(i);
            System.out.print(localCell);
        }
        System.out.println(wall);
    }

    //method for clearing data from board
    private void generateEmptyBody() {
        for (int i = 0; i < 5 ; i++) {
            for(int j = 0; j < 5; j++) {
                boardData[i][j] = 0;
            }
        }
    }

    //method for board body. To fill with "empty" or "X" logic
    private void generateBody() {
        char[] cellX = emptyCell.clone();
        cellX[2] = filledCell;
        for (int i = 0; i < 5 ; i++) {
            System.out.println(rowSeparator);
            for(int j = 0; j < 5; j++) {
                if(boardData[i][j] == 0)
                    System.out.print(emptyCell);
                else if (boardData[i][j] == 1) {
                   System.out.print(cellX);
                }
            }
           System.out.println(wall);
        }
        System.out.println(rowSeparator);
    }

    // method for win situation logic
    public void generateBoardData(String gameType) {

        if  (gameType.equals("CORNERS")) {
            generateEmptyBody();
            boardData[0][0] = 1;
            boardData[0][dimensionX -1] = 1;
            boardData[dimensionY -1][0] = 1;
            boardData[dimensionY -1][dimensionX -1] = 1;
        }
        else if (gameType.equals("DIAGONALS")) {
            generateEmptyBody();

            for(int i = 0; i < dimensionX; i++) {
                boardData[i][i] = 1;
            }
            int i = 0;
            int j = 4;
            while (i < dimensionX && j >= 0) {
                boardData[i][j] = 1;
                i++;
                j--;
            }
        }
        else if (gameType.equals("FULL")) {
            generateEmptyBody();
            for(int i = 0; i < dimensionY; i++) {
                for (int j = 0; j < dimensionX; j++){
                    boardData[i][j] = 1;
                }
            }
        }
        generateHeader();
        generateBody();
    }
}