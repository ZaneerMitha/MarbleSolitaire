package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractMarbleSolitaireModel;

/**
 * This class houses all the methods of EnglishSolitaireModel, which is a type of solitaire game.
 * English solitaire has a cross-shaped board with one initial empty space, where you can move.
 * up down and side to side.
 */
public class EnglishSolitaireModel extends AbstractMarbleSolitaireModel
        implements MarbleSolitaireModel {

  /**
   * This constructor allows the client to set the armThickness, empty slot row, .
   * and empty slot column.
   * .
   *
   * @param armThickness the desired armThickness.
   * @param sRow         the desired row of the empty slot.
   * @param sCol         the desired column of the empty slot.
   * @throws IllegalArgumentException is thrown if armThickness is negative or even, OR if the.
   *                                  desired empty spot is invalid or out of bounds.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) throws
          IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }

  /**
   * This is the default constructor,.
   * which sets the armThickness to 3, and the empty slot at (3,3).
   */
  public EnglishSolitaireModel() {
    super(3,3,3);
  }

  /**
   * The constructor allows the client to input where it wants the empty spot,.
   * and sets the armThickness to 3.
   * .
   *
   * @param sRow the desired row for the empty spot.
   * @param sCol the desired column for the empty spot.
   * @throws IllegalArgumentException is thrown when the desired empty spot is invalid.
   *                                  or out of bounds.
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(3, sRow, sCol);
  }

  /**
   * The constructor that allows the client to set the armThickness.
   * .
   *
   * @param armThickness the desired armThickness.
   * @throws IllegalArgumentException is thrown if the desired armThickness is negative or even.
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    super(armThickness, (armThickness - 1) + (armThickness / 2),
            (armThickness - 1) + (armThickness / 2));
  }

  /**
   * Makes a move on the board based on the inputted values.
   * .
   *
   *     @param fromRow the row number of the position to be moved from.
   *                    (starts at 0).
   *     @param fromCol the column number of the position to be moved from.
   *                    (starts at 0).
   *     @param toRow   the row number of the position to be moved to.
   *                    (starts at 0).
   *     @param toCol   the column number of the position to be moved to.
   *                    (starts at 0).
   *     @throws IllegalArgumentException if the conditions do not support the desired move.
   *     The first possible exception is thrown if either position given is out of the box.
   *     The second possible exception is thrown if either position given is invalid.
   *     The third possible exception is thrown if either position given has the incorrect
   *     marble state.
   *     The fourth possible exception is thrown if the cells are not exactly 2 apart.
   *     The final possible exception is thrown if there is no marble in the .
   *     middle of the positions.
   */

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {

    if (!isOutOfBox(fromRow, fromCol)
            && !isOutOfBox(toRow, toCol)) {
      if (!getSlotAt(fromRow, fromCol).equals(MarbleSolitaireModelState.SlotState.Invalid)
              && !getSlotAt(toRow, toCol).equals(MarbleSolitaireModelState.SlotState.Invalid)) {
        if (getSlotAt(fromRow, fromCol).equals(MarbleSolitaireModelState.SlotState.Marble)
                && getSlotAt(toRow, toCol).equals(MarbleSolitaireModelState.SlotState.Empty)) {
          if (((Math.abs(fromRow - toRow) == 2) && (fromCol == toCol))
                  || ((Math.abs(fromCol - toCol) == 2) && (fromRow == toRow))) {
            if (getSlotAt((fromRow + toRow) / 2,
                    (fromCol + toCol) / 2).equals(MarbleSolitaireModelState.SlotState.Marble)) {
              this.board[fromRow][fromCol] = MarbleSolitaireModelState.SlotState.Empty;
              this.board[toRow][toCol] = MarbleSolitaireModelState.SlotState.Marble;
              this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] =
                      MarbleSolitaireModelState.SlotState.Empty;
            } else {
              throw new IllegalArgumentException("There is no marble in the middle");
            }
          } else {
            throw new IllegalArgumentException("Cells are not two apart");
          }
        } else {
          throw new IllegalArgumentException("Marble states are not correct");
        }
      } else {
        throw new IllegalArgumentException("Invalid positions: "
                + "From (" + fromRow + "," + fromCol + ") To (" + toRow + "," + toCol + ")");
      }
    } else {
      throw new IllegalArgumentException("Out of box position: "
              + "From (" + fromRow + "," + fromCol + ") To (" + toRow + "," + toCol + ")");
    }
  }

  /**
   * Checks the board to see if no more moves can be made.
   *.
   * @return returns true if there are no more possible moves, and false otherwise.
   */
  @Override
  public boolean isGameOver() {
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (getSlotAt(r,c) == MarbleSolitaireModelState.SlotState.Marble
                && ((r < size - 2 && (hasMoves(r, c, r + 2, c)))
                || (r > 1 && (hasMoves(r, c, r - 2, c)))
                || (c < size - 2 && (hasMoves(r, c, r, c + 2)))
                || (c > 1 && (hasMoves(r, c, r, c - 2))))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * checks to see if the first position can move to the second position.
   * based on the rules of the game.
   * .
   *
   * @param fromRow the row of the starting position.
   * @param fromCol the column of the starting position.
   * @param toRow   the row of the ending position.
   * @param toCol   the column of the ending position.
   * @return a boolean, returns true if the move can be made and false otherwise.
   */

  protected boolean hasMoves(int fromRow, int fromCol, int toRow, int toCol) {
    return ((!(isOutOfBox(fromRow, fromCol) && isOutOfBox(toRow, toCol)))
            && !(getSlotAt(fromRow, fromCol).equals(MarbleSolitaireModelState.SlotState.Invalid))
            && !(getSlotAt(toRow, toCol).equals(MarbleSolitaireModelState.SlotState.Invalid))
            && getSlotAt(fromRow, fromCol).equals(MarbleSolitaireModelState.SlotState.Marble)
            && getSlotAt(toRow, toCol).equals(MarbleSolitaireModelState.SlotState.Empty)
            && getSlotAt((fromRow + toRow) / 2, (fromCol + toCol) / 2) ==
            MarbleSolitaireModelState.SlotState.Marble
            && ((Math.abs(fromCol - toCol) == 2) && (Math.abs(fromRow - toRow) == 0)
            || (Math.abs(fromRow - toRow) == 2) && (Math.abs(fromCol - toCol) == 0)
            || (Math.abs(fromRow - toRow) == 2 && (Math.abs(fromCol - toCol)) == 2)));
  }

  /**
   * checks to see if the given position is Invalid, aka in the bounds but not on the board.
   *
   * @param row          the row of the given position.
   * @param col          the column of the given position.
   * @return a boolean, true if the position is invalid and false otherwise.
   */
  protected boolean isInvalidPos(int row, int col) {
    return ((row < armThickness - 1 && col < armThickness - 1)
            || (row > size - armThickness && col > size - armThickness)
            || (row > size - armThickness && col < armThickness - 1)
            || (row < armThickness - 1 && col > size - armThickness));
  }

}


