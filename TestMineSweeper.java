/*
  File: TestMineSweeper.java

  Description: This program will implement a minesweeper class to support a complete working version of a Minesweeper game. 

  Student Name: TienYu Huang

  Student UT EID: th23897

  Course Name: CS 312

  Unique Number: 90125

  Date Created: 08/16/14

  Date Last Modified: 08/17/14

*/


public class TestMineSweeper
{
  public static void main (String[] args) 
  {
    // create new minesweeper instance 2 rows by 5 columns
    minesweeper game = new minesweeper(2, 5); 

    // display mines
    System.out.println ( game.toStringMines() );

    // display tiles
    System.out.println ( game.toStringTiles() );

    // display board
    System.out.println ( game.toStringBoard() );

    // mark tile at (0, 0) as Open
    game.markTile (0, 0, 0);

    // mark tile at (0, 1) as Question Mark
    game.markTile (0, 1, 2);

    // mark tile at (0, 0) as Mine
    game.markTile (0, 2, 3);

    // display tiles 
    System.out.println ( game.toStringTiles() );

    // display board
    System.out.println ( game.toStringBoard() );
 } 
}


class minesweeper
{
  // Attributes
  public int[][] mines; //mines and clue values
  public int[][] tiles; //tiles covering mines and clues
  public int[][] board; //
  
  private int numOfBomb ;
  private String status; //game status - play, win, lose

  //Constructors
  public minesweeper() // default constructor 9 by 9 board
  {
    initGame(9, 9);
  }        
          
  public minesweeper(int newRows, int newCols) // non-default constructor
  {
    initGame(newRows, newCols);
  }
  
  // Public Methods
  public String getStatus() //current game status - play, win, lose
  {
    return status; 
  }
  public int getRows() //number of game board rows
  {
    return mines.length;
  }        
  public int getCols() //number of game board columns
  {
    return mines[0].length;
  }
  public int getMines(int r, int c) //mine array value at position r,c
  {
    return mines[r][c];
  }        
  public int getTiles(int r, int c) //mine array value at position r,c
  {
    return tiles[r][c];
  }        
  
  
  public char getBoard(int r, int c) //board value for position r,c
  {
    char board = ' ';
    switch (tiles[r][c])
    {
    case 0: 
      if (mines[r][c] == 0) 
      {
        board = ' ';
      } 
      else 
      {
        board = (char)(mines[r][c] + 48);
      }
      break;
    case 1: 
      board = 'X';
      break;
    case 2: 
      board = '?';
      break;
    case 3: 
      board = 'F';
      break;
    }
    if (status.compareTo("play") != 0) 
    {
      if (status.equals("win"))
      {
        if (mines[r][c] == 9) {
          board = 'F';
        }
      }
      else if ((mines[r][c] == 9) && (tiles[r][c] == 0)) 
      {
        board = '!';
      } 
      else if (mines[r][c] == 9) 
      {
        board = '*';
      } 
      else if ((mines[r][c] != 9) && (tiles[r][c] == 3)) 
      {
        board = '-';
      }
    }
    return board;
  }        

  public void markTile(int r, int c, int t) //change tile status
  {        
    if ((validIndex(r,c))&&(status.compareTo("play") == 0)) 
    {
      switch (t)
      {
      case 0: 
        if ((tiles[r][c] != 0) && (tiles[r][c] != 3))
        {
          tiles[r][c] = 0;
          if (gameWon())
          {
            status = "win";
          }
          else if (mines[r][c] == 9)
          {
            status = "lose";
          }
          else if (mines[r][c] == 0)
          {
            markTile(r - 1, c - 1, 0);
            markTile(r - 1, c, 0);
            markTile(r - 1, c + 1, 0);
            markTile(r, c - 1, 0);
            markTile(r, c + 1, 0);
            markTile(r + 1, c - 1, 0);
            markTile(r + 1, c, 0);
            markTile(r + 1, c + 1, 0);
          }
        }
        break;
      case 1: 
        tiles[r][c] = 1;
        
        break;
      case 2: 
        tiles[r][c] = 2;
        
        break;
      case 3: 
        tiles[r][c] = 3;
        break;
      }
    }
  }

  public String toStringMines() //mines array as String
  {
    String str = "\n";
    for (int i = 0; i < mines.length; i++)
    {
      for (int j = 0; j < mines[i].length; j++) {
        str = str + mines[i][j];
      }
      str = str + "\n";
    }
    return str;
  }       
          
  public String toStringTiles() //tiles array as String
  {
    String str = "";
    for (int i = 0; i < mines.length; i++)
    {
      for (int j = 0; j < mines[i].length; j++) {
        str = str + tiles[i][j];
      }
      str = str + "\n";
    }
    return str;
  }          
          
  public String toStringBoard() //game board as String
  {
    String str = "";
    for (int i = 0; i < tiles.length; i++)
    {
      for (int j = 0; j < tiles[i].length; j++) {
        str = str + getBoard(i, j);
      }
      str = str + "\n";
    }
    return str;
  }          
          

  private void initGame(int newRows, int newCols) //set-up game
  {
      mines = new int[newRows][newCols];
      tiles = new int[newRows][newCols];
     
      resetTiles();
      
      placeMines();
     
      calculateClues();
      
      status = "play";
    
  }        
          
          
  private void resetTiles() //set all tiles closed
  {
    for (int i = 0; i < tiles.length; i++) {
      for (int j = 0; j < tiles[i].length; j++) {
        tiles[i][j] = 1;
      }
    }
  }     
          
  private void placeMines() //place random mines
  {
    numOfBomb = mines.length ;
    for(int k = 0; k< numOfBomb; k++)
    {    
      int n = (int)(Math.random()*mines.length);
      int m = (int)(Math.random()*mines[0].length);        
      mines[n][m] = 9;    
    }      
  }    
          
  private void calculateClues() //calculate clue values
  {
    int[] arrayOfInt1 = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] arrayOfInt2 = { -1, 0, 1, -1, 1, -1, 0, 1 };
    for (int i = 0; i < mines.length; i++) {
      for (int j = 0; j < mines[i].length; j++) {
        if (mines[i][j] == 9) {
          for (int k = 0; k < 8; k++) {
            if ((validIndex(i + arrayOfInt1[k], j + arrayOfInt2[k])) && 
              (mines[(i + arrayOfInt1[k])][(j + arrayOfInt2[k])] != 9)) {
              mines[(i + arrayOfInt1[k])][(j + arrayOfInt2[k])] += 1;
            }
          }
        }
      }
    }
  }
  
  private boolean validIndex(int r, int c) //verify index
  {
    boolean bool = false;
    if ((r >= 0) && (r < mines.length) && 
      (c >= 0) && (c < mines[0].length)) {
      bool = true;
    }
    return bool;
  }
  private boolean gameWon() //determine if game is won
  {
    boolean bool = true;
    for (int i = 0; i < tiles.length; i++) {
      for (int j = 0; j < tiles[i].length; j++) {
        if ((tiles[i][j] != 0) && (mines[i][j] != 9)) {
          bool = false;
        }
      }
    }
    return bool;
  }  
          
}


