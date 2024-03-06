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

public class Game{
  //properties
  private Player one;
  private Player two;
  private int[][] board;
  private Scanner scan = new Scanner(System.in);

  //constructors
  public Game(Player pOne, Player pTwo, int[][] STATE){
    this.one = pOne;
    this.two = pTwo;
    this.board = STATE;
  }

  //methods
  public void printBoard(){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        System.out.print("|" + board[i][j] + "|");
      }
      System.out.println();
    }
  }
  

  public int[][] takeTurn(Player p){
    System.out.println(p.getName() + ", please take your turn");
    System.out.println("What is your x coordinate?");
    int x = scan.nextInt();
    System.out.println("What is your y coordinate?");
    int y = scan.nextInt();

    board[y][x] = p.getNumber();

    printBoard();
    
    return board;
  }

  public boolean checkWin(Player p){
    boolean win = false;
    //horizontal
    for(int y = 0; y < board.length; y++){
      win = true;
      for(int x = 0; x < board[y].length; x++){
        if(p.getNumber() != board[y][x]){
          win = false;
          break;
        }
          
      }
      if(win) return win;
    }
    
    //vertical
    for(int x = 0; x < board.length; x++){
      win = true;
      for(int y = 0; y < board[x].length; y++){
        if(p.getNumber() != board[y][x]){
          win = false;
          break;
        }
      }
      if(win) return win;
    }

    //negative diagonal
    for(int y = 0; y < board.length; y++){
      win = true;
      if(p.getNumber() != board[y][y]){
        win = false;
        break;
      }
    }
    if(win) return win;
    
    //positive diagonal
    for(int x = board.length - 1; x >= 0 ; x--){
      win = true;
      for(int y = 0; y < board.length; y++){
        if(p.getNumber() != board[y][x]){
          win = false;
          break;
        }
      }
    }

    
    return win;
  }

  public void announceWin(Player p){
    System.out.println(p.getName() + " has won the game!");
  }

  public void gameEnd(boolean pOneWin, boolean pTwoWin, int totalTurns){
    if(totalTurns >= (board.length * board[0].length)) System.out.println("Oh no! There's been a draw no one has won.");

    if(pOneWin) announceWin(one);
    if(pTwoWin) announceWin(two);
  }
  
}



// positive diagonal notes?
/*
int width = STATE[0].length;
int last = width - 1;
int first = 0;

for(int i = 0; i < STATE.length; i++){

  System.out.println(STATE[first + i][last - i]);
} */

// negative diagonal notes?
/*



*/