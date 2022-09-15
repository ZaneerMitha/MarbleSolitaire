package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class houses all the methods of TriangleSolitaireModel, which is a type of solitaire game.
 * Triangular solitaire has a triangle board with one initial empty space, where you can move.
 * side to side and diagonally.
 */
public class TriangleSolitaireModel extends AbstractMarbleSolitaireModel {

  /**
   * This is the default constructor,.
   * which sets the size to 5, and the empty slot at (0,0).
   */
  public TriangleSolitaireModel() {
    this.size = 5;
    emptySlotRow = 0;
    emptySlotColumn = 0;
    board = makeBoard(emptySlotRow,emptySlotColumn);
  }

  /**
   * The constructor that allows the client to set the size.
   * .
   *
   * @param size the desired size.
   * @throws IllegalArgumentException is thrown if the desired size is negative.
   */
  public TriangleSolitaireModel(int size) throws IllegalArgumentException {
    this.size = size;
    if (size <= 0) {
      throw new IllegalArgumentException("Size must be greater than 0");
    }

    emptySlotRow = 0;
    emptySlotColumn = 0;
    board = makeBoard(emptySlotRow,emptySlotColumn);
  }

  /**
   * The constructor allows the client to input where it wants the empty spot,.
   * and sets the size to 5.
   * .
   *
   * @param row the desired row for the empty spot.
   * @param col the desired column for the empty spot.
   * @throws IllegalArgumentException is thrown when the desired empty spot is invalid.
   *                                  or out of bounds.
   */
  public TriangleSolitaireModel(int row, int col) throws IllegalArgumentException {
    this.size = 5;
    if (isInvalidPos(col,row) || isOutOfBox(row, col)) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + row + "," + col + ")");
    }

    emptySlotRow = row;
    emptySlotColumn = col;
    board = makeBoard(emptySlotRow,emptySlotColumn);
  }

  /**
   * This constructor allows the client to set the size, empty slot row, .
   * and empty slot column.
   * .
   *
   * @param size the desired size.
   * @param row         the desired row of the empty slot.
   * @param col         the desired column of the empty slot.
   * @throws IllegalArgumentException is thrown if size is negative, OR if the.
   *                                  desired empty spot is invalid or out of bounds.
   */
  public TriangleSolitaireModel(int size, int row, int col) throws IllegalArgumentException {
    this.size = size;
    if (size <= 0) {
      throw new IllegalArgumentException("Size must be greater than 0");
    }
    if (isInvalidPos(col,row) || isOutOfBox(row, col)) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + row + "," + col + ")");
    }

    emptySlotRow = row;
    emptySlotColumn = col;
    board = makeBoard(emptySlotRow,emptySlotColumn);
  }


  /**
   * Makes a move on the board based on the inputted values. In this game, moves can be diagonal.
   * as well.
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
      if (!getSlotAt(fromRow, fromCol).equals(SlotState.Invalid)
              && !getSlotAt(toRow, toCol).equals(SlotState.Invalid)) {
        if (getSlotAt(fromRow, fromCol).equals(SlotState.Marble)
                && getSlotAt(toRow, toCol).equals(SlotState.Empty)) {
          if (((Math.abs(fromRow - toRow) == 2) && (fromCol == toCol))
                  || ((Math.abs(fromCol - toCol) == 2) && (fromRow == toRow))
                  || ((Math.abs(fromCol - toCol) == 2) && (Math.abs(fromRow - toRow) == 2))) {
            if (getSlotAt((fromRow + toRow) / 2,
                    (fromCol + toCol) / 2).equals(SlotState.Marble)) {
              this.board[fromRow][fromCol] = SlotState.Empty;
              this.board[toRow][toCol] = SlotState.Marble;
              this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = SlotState.Empty;
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
   * returns the size of the board.
   * @return an int, which is the board size.
   */
  @Override
  public int getBoardSize() {
    return size;
  }

  /**
   * Checks if the given position is invalid, (outside of the triangle).
   * @param col the given column of the desired position.
   * @param row the given row of the desired position.
   * @return true if the position is invalid, false otherwise.
   */
  protected boolean isInvalidPos(int col, int row) {
    return (row < col);
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
                || (c > 1 && (hasMoves(r, c, r, c - 2)))
                || (c < size - 2 && r < size - 2 && (hasMoves(r, c, r + 2, c + 2)))
                || (c > 1 && r > 1 && (hasMoves(r, c, r - 2, c - 2))))) {
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
    if (!getSlotAt(fromRow, fromCol).equals(SlotState.Invalid)
            && !getSlotAt(toRow, toCol).equals(SlotState.Invalid)) {
      if (getSlotAt(fromRow, fromCol).equals(SlotState.Marble)
              && getSlotAt(toRow, toCol).equals(SlotState.Empty)) {
        if (((Math.abs(fromRow - toRow) == 2) && (fromCol == toCol))
                || ((Math.abs(fromCol - toCol) == 2) && (fromRow == toRow))
                || (Math.abs(fromCol - toCol) == 2 && Math.abs(fromRow - toRow) == 2)) {
          return (getSlotAt((fromRow + toRow) / 2,
                  (fromCol + toCol) / 2).equals(SlotState.Marble));
        } else {
          return false;
        }
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}