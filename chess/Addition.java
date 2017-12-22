
/**
 * Write a description of class Addition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Addition extends Pieces
{
    // instance variables - replace the example below with your own
 public boolean bCheckForValidMovemement(int stonetype, int base, int target) {
      if (!bIsCorrectCellInBoard(target)) {
          System.out.println("incorrect cell in board");
          return false;
      }

      System.out.println("stonetype=" + stonetype);

      if (stonetype == 1) { // Plus can move in straight line, horizontal/vertical, up to 2 steps
          System.out.println("target=" + target + ", base=" + base);
          
          // vertical movement
          int diff = target - base;
          diff = Math.abs(diff);
          if(diff == 9 || diff == 18) {
              // vertical movement OK
              return true;
          }
          
          // horizontal movement
          if(diff == 1 || diff == 2) {
              return true;
          }
      }
      else if (stonetype == 2) { // Triangle can move in straight line, diagonally, up to 2 steps
          System.out.println("target=" + target + ", base=" + base);
          
          // diagonal movement
          int diff = target - base;
          diff = Math.abs(diff);
          if(diff == (9+1) || diff == (18+2) || diff == (9-1) || diff == (18-2)) {
              // vertical movement OK
              return true;
          }
          
          // horizontal movement
//          if(diff == 1 || diff == 2) {
//            return true;
//          }
      }
      else if (stonetype == 4) {// Sun can move in any direction, 1 step only
          System.out.println("type=" + stonetype + ", target=" + target + ", base=" + base);
          
          // diagonal movement
          int diff = target - base;
          diff = Math.abs(diff);
          if(diff == (9+1) || diff == (9-1)) {
              // vertical movement OK
              return true;
          }
          if(diff == 1)
              // horizontal movement OK
              return true;
          if(diff == 9)
              // vertical movement OK
              return true;
      }
      else if (stonetype == 3) {// Sun can move in any direction, 1 step only
          System.out.println("type=" + stonetype + ", target=" + target + ", base=" + base);
          
          // diagonal movement
          int diff = target - base;
          diff = Math.abs(diff);
          if(diff == 19 ) {
              // vertical movement OK
              return true;
          }
          if(diff == 17){
          	return true;
          }
      }

      return false;
  }
  
  
  
  
  
  
  
  
  public boolean bIsCorrectCellInBoard(int coordinate) {
      if (coordinate >= 0 && coordinate <= 8) {
          return false;
      }
      if (coordinate >= 63 && coordinate <= 71) {
          return false;
      }
      if (coordinate == 9
              || coordinate == 17
              || coordinate == 18
              || coordinate == 26
              || coordinate == 27
              || coordinate == 35
              || coordinate == 36
              || coordinate == 44
              || coordinate == 45
              || coordinate == 53
              || coordinate == 54
              || coordinate == 62) {
          return false;
      }
      return true;
  }


}

