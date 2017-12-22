 


import javax.swing.JOptionPane;

//package chess;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *
 */
public class ChessPlayer {

    static int iCurrentPlayer; // 1 for Red/bottom, 2 for Blue/top
    static private boolean bHasSelectedStone;
    static private int iCurrentSelectedCoordinate;
    static private int iCurrentSelectedStoneType; // valid: 1 -->4 . invalid: 0 (not selected)

    void setCurrentPlayer(int value) {
        iCurrentPlayer = value;
    }

    public int getCurrentPlayer() {
        return iCurrentPlayer;
    }

    ChessPlayer() {
        // null
        iCurrentPlayer = 1; // Red/bottom starts the game. Blue/top moves after it
        System.out.println("current player =  " + getCurrentPlayer());

        bHasSelectedStone = false;
        iCurrentSelectedStoneType = 0;
        iCurrentSelectedCoordinate = 0;
    }

    public void changePlayer() {
        if (iCurrentPlayer == 1) {
            iCurrentPlayer = 2;
        } else {
            iCurrentPlayer = 1;
        }
    }

    public int getNextPlayer() {
        if (iCurrentPlayer == 1) {
            return 2;
        } else if (iCurrentPlayer == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    public void showGameFinished() {
        if (iCurrentPlayer == 1) {
            JOptionPane.showMessageDialog(null, "Blue player win");
        } else {
            JOptionPane.showMessageDialog(null, "Red player win");
        }
    }

    public void setHasSelectedStone(int coordinate) {
        bHasSelectedStone = true;
        iCurrentSelectedCoordinate = coordinate;
    }

    public void unsetHasSelectedStone() {
        bHasSelectedStone = false;
    }

    public boolean bHasSelectedStone() {
        return bHasSelectedStone;
    }

    public void setCurrentSelectedCoordinate(int coord) {
        iCurrentSelectedCoordinate = coord;
    }

    public int getCurrentSelectedCoordinate() {
        return iCurrentSelectedCoordinate;
    }

    public int getCurrentSelectedStoneType() {
        return iCurrentSelectedStoneType;
    }

    public void setCurrentSelectedStoneType(int type) {
        iCurrentSelectedStoneType = type;
    }
}
