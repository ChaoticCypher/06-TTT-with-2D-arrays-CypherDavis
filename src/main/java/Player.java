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

public class Player{
  //properties
    private String name;
    private int wins;
    private int loses;
    private int ties;
    private int symbol;

  //constructors
    public Player(String n, int w,int l,int t){
        this.name = n;
        this.wins = w;
        this.loses = l;
        this.ties = t;
    }

  public Player(String n, int s){
    this.name = n;
    this.symbol = s;
  }
    
  //methods
  public String getName(){
    return this.name;
  }
  public int getNumber(){
    return this.symbol;
  }
}