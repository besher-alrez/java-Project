 

//package chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class Board implements MouseListener {
  static Pieces Add= new Addition();
  static Pieces tri = new Triangle();
  
 static Pieces Chev= new Chevron();
 static Pieces Sun = new Sun();
  static Helper oHelper; // an instance of Helper class
  static ChessPlayer oChessPlayer; // an instance of ChessPlayer class

  // create array for column and row of the board
  //int[] arrBoard = new int[72]; // 9x8 matrix = 72 cells
  JFrame frame;
  //JPanel squares[][] = new JPanel[6][7];
  JPanel squares[] = new JPanel[72]; // 9x8 matrix board (supposed 6x7)

  @Override
  public void mouseClicked(MouseEvent e) {
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      JPanel jPanelClicked = (JPanel) e.getSource();

      //int row = (int) jPanelClicked.getClientProperty("row");
      //System.out.println("row = " + row);    
      //int col = (int) jPanelClicked.getClientProperty("col");
      //System.out.println("col = " + col);
      int owner = (int) jPanelClicked.getClientProperty("owner");
      System.out.println("owner = " + owner);
      int type = (int) jPanelClicked.getClientProperty("type");
      System.out.println("type = " + type);
      int coordinate = (int) jPanelClicked.getClientProperty("coordinate");
      System.out.println("coordinate = " + coordinate);

      if (!oChessPlayer.bHasSelectedStone()) {
          if (oHelper.bVerifySelectedStone(owner)) {
              System.out.println("ok stone selection");
              jPanelClicked.setBackground(Color.red);
              oChessPlayer.setHasSelectedStone(coordinate);
              oChessPlayer.setCurrentSelectedStoneType(type);
          } else {
              System.out.println("wrong stone selection");
          }
      } else // current player has selected stone. thus, check whether current cell selection is not occupied by its same stone
      {
          if (oHelper.bVerifySelectedStone(owner)) {
              System.out.println("choose different cell"); // current player must choose different cell because chosen cell has his stone
          } else {
              // valid cell because different owner.
              // check valid movement distance, based on the type of stone
              int base = oChessPlayer.getCurrentSelectedCoordinate();
               
              
              
              if(oChessPlayer.getCurrentSelectedStoneType()==1){
                  
                  if (Add.bCheckForValidMovemement(oChessPlayer.getCurrentSelectedStoneType(), base, coordinate)) {
                  // valid
                  // so move the stone to new cell
                  System.out.println("valid movement to new coordinate");
                  //oChessPlayer.setCurrentSelectedCoordinate(0);

                  boolean finish = false;

                  unsetStoneIcon(base);
                  if (owner == 0) { // target coord is empty so move base to target
                      //setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());
                      System.out.println("[target is empty] coord=" + coordinate + " new_owner=" + owner);
                  } else { // target coord is not empty and it has the opposite stone
                      //setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());
                      unsetStoneIcon(coordinate);
                      System.out.println("[target not empty] coord=" + coordinate + " new_owner=" + oChessPlayer.getCurrentPlayer());
                      if (type == 4) {
                          finish = true;
                      }
                  }
                  setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());

                  // moved out from unsetStoneIcon()
                  oChessPlayer.setCurrentSelectedCoordinate(0);
                  oChessPlayer.setCurrentSelectedStoneType(0);
                  oChessPlayer.unsetHasSelectedStone();
                  oChessPlayer.changePlayer();

                  if (finish) {
                      oChessPlayer.showGameFinished();
                      resetBoard();
                  }
                  //squares[base].s
                  //squares[coord].
              } 
                  
                  
                  
                }
                
                
                 else if(oChessPlayer.getCurrentSelectedStoneType()==2){
                  
                  if (tri.bCheckForValidMovemement(oChessPlayer.getCurrentSelectedStoneType(), base, coordinate)) {
                  // valid
                  // so move the stone to new cell
                  System.out.println("valid movement to new coordinate");
                  //oChessPlayer.setCurrentSelectedCoordinate(0);

                  boolean finish = false;

                  unsetStoneIcon(base);
                  if (owner == 0) { // target coord is empty so move base to target
                      //setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());
                      System.out.println("[target is empty] coord=" + coordinate + " new_owner=" + owner);
                  } else { // target coord is not empty and it has the opposite stone
                      //setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());
                      unsetStoneIcon(coordinate);
                      System.out.println("[target not empty] coord=" + coordinate + " new_owner=" + oChessPlayer.getCurrentPlayer());
                      if (type == 4) {
                          finish = true;
                      }
                  }
                  setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());

                  // moved out from unsetStoneIcon()
                  oChessPlayer.setCurrentSelectedCoordinate(0);
                  oChessPlayer.setCurrentSelectedStoneType(0);
                  oChessPlayer.unsetHasSelectedStone();
                  oChessPlayer.changePlayer();

                  if (finish) {
                      oChessPlayer.showGameFinished();
                      resetBoard();
                  }
                  //squares[base].s
                  //squares[coord].
              } 
                  
                  
                  
                }
                
                
                
                
                 if(oChessPlayer.getCurrentSelectedStoneType()==3){
                  
                  if (Chev.bCheckForValidMovemement(oChessPlayer.getCurrentSelectedStoneType(), base, coordinate)) {
                  // valid
                  // so move the stone to new cell
                  System.out.println("valid movement to new coordinate");
                  //oChessPlayer.setCurrentSelectedCoordinate(0);

                  boolean finish = false;

                  unsetStoneIcon(base);
                  if (owner == 0) { // target coord is empty so move base to target
                      //setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());
                      System.out.println("[target is empty] coord=" + coordinate + " new_owner=" + owner);
                  } else { // target coord is not empty and it has the opposite stone
                      //setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());
                      unsetStoneIcon(coordinate);
                      System.out.println("[target not empty] coord=" + coordinate + " new_owner=" + oChessPlayer.getCurrentPlayer());
                      if (type == 4) {
                          finish = true;
                      }
                  }
                  setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());

                  // moved out from unsetStoneIcon()
                  oChessPlayer.setCurrentSelectedCoordinate(0);
                  oChessPlayer.setCurrentSelectedStoneType(0);
                  oChessPlayer.unsetHasSelectedStone();
                  oChessPlayer.changePlayer();

                  if (finish) {
                      oChessPlayer.showGameFinished();
                      resetBoard();
                  }
                  //squares[base].s
                  //squares[coord].
              } 
                  
                  
                  
                }
                
                
                 if(oChessPlayer.getCurrentSelectedStoneType()==4){
                  
                  if (Sun.bCheckForValidMovemement(oChessPlayer.getCurrentSelectedStoneType(), base, coordinate)) {
                  // valid
                  // so move the stone to new cell
                  System.out.println("valid movement to new coordinate");
                  //oChessPlayer.setCurrentSelectedCoordinate(0);

                  boolean finish = false;

                  unsetStoneIcon(base);
                  if (owner == 0) { // target coord is empty so move base to target
                      //setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());
                      System.out.println("[target is empty] coord=" + coordinate + " new_owner=" + owner);
                  } else { // target coord is not empty and it has the opposite stone
                      //setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());
                      unsetStoneIcon(coordinate);
                      System.out.println("[target not empty] coord=" + coordinate + " new_owner=" + oChessPlayer.getCurrentPlayer());
                      if (type == 4) {
                          finish = true;
                      }
                  }
                  setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());

                  // moved out from unsetStoneIcon()
                  oChessPlayer.setCurrentSelectedCoordinate(0);
                  oChessPlayer.setCurrentSelectedStoneType(0);
                  oChessPlayer.unsetHasSelectedStone();
                  oChessPlayer.changePlayer();

                  if (finish) {
                      oChessPlayer.showGameFinished();
                      resetBoard();
                  }
                  //squares[base].s
                  //squares[coord].
              } 
                  
                  
                  
                }
                
              
              
              
              
              /*if (Add.bCheckForValidMovemement(oChessPlayer.getCurrentSelectedStoneType(), base, coordinate)) {
                  // valid
                  // so move the stone to new cell
                  System.out.println("valid movement to new coordinate");
                  //oChessPlayer.setCurrentSelectedCoordinate(0);

                  boolean finish = false;

                  unsetStoneIcon(base);
                  if (owner == 0) { // target coord is empty so move base to target
                      //setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());
                      System.out.println("[target is empty] coord=" + coordinate + " new_owner=" + owner);
                  } else { // target coord is not empty and it has the opposite stone
                      //setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());
                      unsetStoneIcon(coordinate);
                      System.out.println("[target not empty] coord=" + coordinate + " new_owner=" + oChessPlayer.getCurrentPlayer());
                      if (type == 4) {
                          finish = true;
                      }
                  }
                  setStoneIcon(coordinate, oChessPlayer.getCurrentPlayer());

                  // moved out from unsetStoneIcon()
                  oChessPlayer.setCurrentSelectedCoordinate(0);
                  oChessPlayer.setCurrentSelectedStoneType(0);
                  oChessPlayer.unsetHasSelectedStone();
                  oChessPlayer.changePlayer();

                  if (finish) {
                      oChessPlayer.showGameFinished();
                      resetBoard();
                  }
                  //squares[base].s
                  //squares[coord].
              } */
              
              
              else {
                  // invalid movement
                  System.out.println("invalid new coordinate");
              }
          }
      }

      System.out.println("\n");
  }

  @Override
  public void mousePressed(MouseEvent e) {
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void mouseReleased(MouseEvent e) {
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void mouseEntered(MouseEvent e) {
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void mouseExited(MouseEvent e) {
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public enum Player {
      RED, BLUE; //pre-defined constants. 2 types of player. Red (bottom) and Blue (top)
  }

  public enum Stone {
      TRIANGLE, PLUS, CHEVRON, SUN; // 4 kinds of stones
  }

  private Player currentPlayer;

  public Player getCurrentPlayer() { //
      return this.currentPlayer;
  }

  public void setCurrentPlayer(Player player) { //
      this.currentPlayer = player;
  }

  public int iLastSelectedCoordinate;

  public void setStoneIcon(int coord, int owner) {

      System.out.println("setStoneIcon.... coord to set = " + coord);

      System.out.println("current selected stone type = " + oChessPlayer.getCurrentSelectedStoneType());

//      squares[coord].revalidate();
//      squares[coord].repaint();
      if (oChessPlayer.getCurrentSelectedStoneType() == 1) {
          if (oChessPlayer.getCurrentPlayer() == 1) {
              squares[coord].add((new JLabel(new ImageIcon("addition.png"))));
              System.out.println("selectedstonetype=1, currentplayer=1");
          } else if (oChessPlayer.getCurrentPlayer() == 2) {
              squares[coord].add((new JLabel(new ImageIcon("addition2.png"))));
              System.out.println("selectedstonetype=1, currentplayer=2");
          }
      } else if (oChessPlayer.getCurrentSelectedStoneType() == 2) {
          if (oChessPlayer.getCurrentPlayer() == 1) {
              squares[coord].add((new JLabel(new ImageIcon("Triangle.png"))));
          } else if (oChessPlayer.getCurrentPlayer() == 2) {
              squares[coord].add((new JLabel(new ImageIcon("Triangle2.png"))));
          }
      } else if (oChessPlayer.getCurrentSelectedStoneType() == 4) {
          if (oChessPlayer.getCurrentPlayer() == 1) {
              squares[coord].add((new JLabel(new ImageIcon("Sun.png"))));
          } else if (oChessPlayer.getCurrentPlayer() == 2) {
              squares[coord].add((new JLabel(new ImageIcon("Sun2.png"))));
          }
      } else if (oChessPlayer.getCurrentSelectedStoneType() == 3) {
          if (oChessPlayer.getCurrentPlayer() == 1) {
              squares[coord].add((new JLabel(new ImageIcon("Chevron.png"))));
          } else if (oChessPlayer.getCurrentPlayer() == 2) {
              squares[coord].add((new JLabel(new ImageIcon("Chevron2.png"))));
          }
      }

      squares[coord].putClientProperty("type", oChessPlayer.getCurrentSelectedStoneType());
      squares[coord].putClientProperty("owner", oChessPlayer.getCurrentPlayer());

      squares[coord].revalidate();
      squares[coord].repaint();

      System.out.println("done draw a new stone to the new coord");

      return;
  }

  public void unsetStoneIcon(int coord) {

      squares[coord].removeAll();
      squares[coord].revalidate();
      squares[coord].repaint();

      if ((coord) % 2 == 0) { // cell with even number, set backgorund color to black
          squares[coord].setBackground(Color.black);
      } else { // else for odd number, set background color to white
          squares[coord].setBackground(Color.white);
      }

//      Container parent = squares[coord].getParent();
//      parent.remove(squares[coord]);
//      parent.validate();
//      parent.repaint();
      //squares[coord].add((new JLabel(new ImageIcon("addition.png"))));
      squares[coord].putClientProperty("type", 0);
      squares[coord].putClientProperty("owner", 0);

//      oChessPlayer.setCurrentSelectedCoordinate(0);
//      oChessPlayer.setCurrentSelectedStoneType(0);
//      oChessPlayer.unsetHasSelectedStone();
//      oChessPlayer.changePlayer();
      return;
  }

  public Board() {

      iLastSelectedCoordinate = 0; // game not started yet

      frame = new JFrame("Zaronian Chess"); // name of the chess game
      frame.setSize(500, 500); // frame size
      frame.setLayout(new GridLayout(8, 9)); // col-row matrix board

      /* stone types:
       * Plus = 1, Triangle = 2, Chevron = 3, Sun = 4
       * owner types:
       * Red/bottom = 1, Blue/top = 2
       *
       * empty: type=0, owner=0 
       */
      // since there are 4 types of stone, 10=Plus1, 11=Triangle1, 12=Chevron1, 13=Sun1, 14=Chevron2, 15=Triangle2, 16=Plus2
      //                                  (for player Red/bottom)
      //                                  20=Plus, 21=Triangle, 22=Chevron, 23=Sun, 24=Chevron2, 25=Triangle2, 26=Plus2
      //                                  (for player Blue/top)
      // below is initialization/placement of the stones for player Red/bottom
      for (int j = 0; j < 9; j++) { // j=column, 0 --> 8
          for (int i = 0; i < 8; i++) { // i=row, 0 --> 7

              int coord = j * 8 + i;

              //int col = i;
              //int row = j;
              //System.out.println("row=" + row + ", col=" + col + ", coord=" + coord);
              squares[coord] = new JPanel(); // for each cell, it has a JPanel

              // save its x-y coordinate
              //squares[coord].putClientProperty("row", row);
              //squares[coord].putClientProperty("col", col);
              squares[coord].putClientProperty("coordinate", coord);

              // for every cell, add a mouse listener
              squares[coord].addMouseListener(this);

              // set every cell's background color
              if ((coord) % 2 == 0) { // cell with even number, set backgorund color to black
                  squares[coord].setBackground(Color.black);
              } else { // else for odd number, set background color to white
                  squares[coord].setBackground(Color.white);
              }

              JLabel lbl = new JLabel();
              lbl.setText(Integer.toString(coord));
              squares[coord].add(lbl);

              if ((coord) >= 55 && (coord) <= 61) {
                  // Red/bottom stones
                  if ((coord) == 55) { // starting position for 'Add'
                      squares[coord].add((new JLabel(new ImageIcon("addition.png"))));
                      squares[coord].putClientProperty("type", 1);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 56) { // starting position for 'Triangle'
                      squares[coord].add((new JLabel(new ImageIcon("Triangle.png"))));
                      squares[coord].putClientProperty("type", 2);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 57) { // starting position for 'Chevron'
                      squares[coord].add((new JLabel(new ImageIcon("Chevron.png"))));
                      squares[coord].putClientProperty("type", 3);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 58) { // starting position for 'Sun'
                      squares[coord].add((new JLabel(new ImageIcon("Sun.png"))));
                      squares[coord].putClientProperty("type", 4);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 59) { // starting position for 'Chevron'
                      squares[coord].add((new JLabel(new ImageIcon("Chevron.png"))));
                      squares[coord].putClientProperty("type", 3);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 60) { // starting position for 'Triangle'
                      squares[coord].add((new JLabel(new ImageIcon("Triangle.png"))));
                      squares[coord].putClientProperty("type", 2);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 61) { // starting position for 'Add'
                      squares[coord].add((new JLabel(new ImageIcon("addition.png"))));
                      squares[coord].putClientProperty("type", 1);
                      squares[coord].putClientProperty("owner", 1);
                  }
              } else if ((coord) >= 10 && (coord) <= 16) {
                  // Blue/top stones
                  if ((coord) == 10) {
                      squares[coord].add((new JLabel(new ImageIcon("addition2.png"))));
                      squares[coord].putClientProperty("type", 1);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 11) {
                      squares[coord].add((new JLabel(new ImageIcon("Triangle2.png"))));
                      squares[coord].putClientProperty("type", 2);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 12) {
                      squares[coord].add((new JLabel(new ImageIcon("Chevron2.png"))));
                      squares[coord].putClientProperty("type", 3);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 13) {
                      squares[coord].add((new JLabel(new ImageIcon("Sun2.png"))));
                      squares[coord].putClientProperty("type", 4);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 14) {
                      squares[coord].add((new JLabel(new ImageIcon("Chevron2.png"))));
                      squares[coord].putClientProperty("type", 3);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 15) {
                      squares[coord].add((new JLabel(new ImageIcon("Triangle2.png"))));
                      squares[coord].putClientProperty("type", 2);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 16) {
                      squares[coord].add((new JLabel(new ImageIcon("addition2.png"))));
                      squares[coord].putClientProperty("type", 1);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  frame.add(squares[coord]);
              } else {
                  squares[coord].putClientProperty("type", 0);
                  squares[coord].putClientProperty("owner", 0);
              }

              //                
              frame.add(squares[coord]);
              //frame.add(squares[i * 9 + j]);

              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.setVisible(true);
          }
      }
  }

  public void resetBoard() {
      System.out.println("resetting the board....");
      for (int j = 0; j < 9; j++) { // j=column, 0 --> 8
          for (int i = 0; i < 8; i++) { // i=row, 0 --> 7

              int coord = j * 8 + i;

              squares[coord].removeAll();
              squares[coord].revalidate();
              squares[coord].repaint();

              //int col = i;
              //int row = j;
              //System.out.println("row=" + row + ", col=" + col + ", coord=" + coord);
              //squares[coord] = new JPanel(); // for each cell, it has a JPanel

              // save its x-y coordinate
              //squares[coord].putClientProperty("row", row);
              //squares[coord].putClientProperty("col", col);
              squares[coord].putClientProperty("coordinate", coord);

              // for every cell, add a mouse listener
              //squares[coord].addMouseListener(this);
              // set every cell's background color
              if ((coord) % 2 == 0) { // cell with even number, set backgorund color to black
                  squares[coord].setBackground(Color.black);
              } else { // else for odd number, set background color to white
                  squares[coord].setBackground(Color.white);
              }

              JLabel lbl = new JLabel();
              lbl.setText(Integer.toString(coord));
              squares[coord].add(lbl);

              if ((coord) >= 55 && (coord) <= 61) {
                  // Red/bottom stones
                  if ((coord) == 55) { // starting position for 'Add'
                      squares[coord].add((new JLabel(new ImageIcon("addition.png"))));
                      squares[coord].putClientProperty("type", 1);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 56) { // starting position for 'Triangle'
                      squares[coord].add((new JLabel(new ImageIcon("Triangle.png"))));
                      squares[coord].putClientProperty("type", 2);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 57) { // starting position for 'Chevron'
                      squares[coord].add((new JLabel(new ImageIcon("Chevron.png"))));
                      squares[coord].putClientProperty("type", 3);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 58) { // starting position for 'Sun'
                      squares[coord].add((new JLabel(new ImageIcon("Sun.png"))));
                      squares[coord].putClientProperty("type", 4);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 59) { // starting position for 'Chevron'
                      squares[coord].add((new JLabel(new ImageIcon("Chevron.png"))));
                      squares[coord].putClientProperty("type", 3);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 60) { // starting position for 'Triangle'
                      squares[coord].add((new JLabel(new ImageIcon("Triangle.png"))));
                      squares[coord].putClientProperty("type", 2);
                      squares[coord].putClientProperty("owner", 1);
                  }
                  if ((coord) == 61) { // starting position for 'Add'
                      squares[coord].add((new JLabel(new ImageIcon("addition.png"))));
                      squares[coord].putClientProperty("type", 1);
                      squares[coord].putClientProperty("owner", 1);
                  }
              } else if ((coord) >= 10 && (coord) <= 16) {
                  // Blue/top stones
                  if ((coord) == 10) {
                      squares[coord].add((new JLabel(new ImageIcon("addition2.png"))));
                      squares[coord].putClientProperty("type", 1);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 11) {
                      squares[coord].add((new JLabel(new ImageIcon("Triangle2.png"))));
                      squares[coord].putClientProperty("type", 2);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 12) {
                      squares[coord].add((new JLabel(new ImageIcon("Chevron2.png"))));
                      squares[coord].putClientProperty("type", 3);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 13) {
                      squares[coord].add((new JLabel(new ImageIcon("Sun2.png"))));
                      squares[coord].putClientProperty("type", 4);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 14) {
                      squares[coord].add((new JLabel(new ImageIcon("Chevron2.png"))));
                      squares[coord].putClientProperty("type", 3);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 15) {
                      squares[coord].add((new JLabel(new ImageIcon("Triangle2.png"))));
                      squares[coord].putClientProperty("type", 2);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  if ((coord) == 16) {
                      squares[coord].add((new JLabel(new ImageIcon("addition2.png"))));
                      squares[coord].putClientProperty("type", 1);
                      squares[coord].putClientProperty("owner", 2);
                  }
                  //frame.add(squares[coord]);
              } else {
                  squares[coord].putClientProperty("type", 0);
                  squares[coord].putClientProperty("owner", 0);
              }

              //                
              //frame.add(squares[coord]);
              ////frame.add(squares[i * 9 + j]);

              //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              //frame.setVisible(true);
          }
      }
  }

  public static void main(String[] args) {
      oHelper = new Helper();

      Board oBoard = new Board(); //new Board();
      //Helper oHelper = new Helper(); //new Helper();

      oChessPlayer = new ChessPlayer();
  }

}
