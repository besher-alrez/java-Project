 



public class Helper { // a helper class for the Board class

  public int position; // position of cell

  public Helper() {

  }

  

  public boolean bVerifySelectedStone(int iSelectedStoneOwner) {
      if (iSelectedStoneOwner == ChessPlayer.iCurrentPlayer) {
          return true;
      } else {
          return false;
      }
  }

  


}
