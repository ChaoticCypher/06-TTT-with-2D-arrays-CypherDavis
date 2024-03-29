/*
Cypher Davis
06 - TTT with 2D arrays
P6
2-13-24

This project must play Tic-Tac-Toe.


For the first in-class demonstration, you must have the following:
1) a static constand 2-D Array the represnets the board and holds the STATE data for the game.
2) You must correctly resolve:
  horizontal, 
  diagonal, 
  vertical winner conditions
  And a draw
3) You must have 1 player.

For the future and more points above an A-...
0) You must correctly resolve all win and draw states
1) You should have a seond player
2) You should be able to play on a 4 x 4 board
3) You should correctly resolve turns
4) The player and the game should be in seperate classes from your static Main


For more in the future and more awesomer...
1) You can have a text file documenting player win-loss records and another stat of your choice
2) You can have a 3rd or 4th player
3) You can have a 3rd dimension to the game
4) You can make a new class for a game session as well as a single game
5) You can make a new class for a turn, or a piece, or a screen painter
*/

//Cypher Davis
//Tic-Tac-Toe
//P6
//2-13-24

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.IOException;
import java.lang.Integer;
import java.lang.StringBuilder;

public class Main {
  public static final int[][] STATE = {
    {0,0,0},
    {0,0,0},
    {0,0,0}
    
  };

  /*public static final int[][] STATE = {
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0}

  };*/
  
  public static final int[][] STATE4 = {
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0}
  };
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    Player one = new Player("Player One", 1);
    Player two = new Player("Player Two", 2);

   
    int turns = 0;
    
    Game game = new Game(one, two, STATE);
    
    game.printBoard();
    int[][] board = game.takeTurn(one);
    turns++;
    board = game.takeTurn(two);
    turns++;

    boolean win = false;
    boolean pOneWin = false;
    boolean pTwoWin = false;

    while(win == false && turns < (board.length * board[0].length)){
      board = game.takeTurn(one);
      turns++;
      win = game.checkWin(one);
      if(win){
        pOneWin = true;
        break;
      } 
      if(turns >= (board.length * board[0].length)){
        break;
      }
      board = game.takeTurn(two);
      turns++;
      win = game.checkWin(two);
      if(win){
        pTwoWin = true;
      } 
    }

    game.gameEnd(pOneWin,pTwoWin,turns);
    
    
    
    
    
    
  }
}


/* System.out.println("Welcome to tic tac toe");
System.out.println("Would you like to play on a 4x4 board or a 3x3 board (answer 4 or 3)");
int choice = scan.nextInt();

if(choice == 3){
  Game game = new Game(one, two, STATE);
} else if(choice == 4){
  Game game = new Game(one, two, STATE4);
} else{
  System.exit(1);
} */