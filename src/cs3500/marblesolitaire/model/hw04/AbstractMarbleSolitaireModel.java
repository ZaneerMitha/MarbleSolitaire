package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Abstract class that houses common methods ands constructors for ALL the solitaire subclasses.
 * Has the common attributes of English, European, and Triangular solitaire.
 */
public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {

  protected int armThickness;
  protected int emptySlotRow;
  protected int emptySlotColumn;
  protected int size;

  protected SlotState[][] board;

  /**
   * This is the default constructor for the super class, used to instantiate the fields.
   */
  public AbstractMarbleSolitaireModel() {
    this.size = getBoardSize();
    emptySlotRow = 0;
    emptySlotColumn = 0;
  }

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
  public AbstractMarbleSolitaireModel(int armThickness, int sRow, int sCol) throws
          IllegalArgumentException {
    this.armThickness = armThickness;
    this.size = this.getBoardSize();
    this.emptySlotRow = sRow;
    this.emptySlotColumn = sCol;
    this.board = makeBoard(sRow, sCol);

    if (isInvalidPos(sRow, sCol) || isOutOfBox(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + sRow + "," + sCol + ")");
    }
    if (armThickness <= 0 || (armThickness % 2 != 1)) {
      throw new IllegalArgumentException("Invalid arm thickness: " + armThickness);
    }

  }

  /**
   * Creates a 2D array of SlotStates using the size,
   * and sets every SlotStates to its.
   * appropriate state.
   *
   * @param emptySlotRow    the row of the empty slot.
   * @param emptySlotColumn the column of the empty slot.
   * @return a 2D SlotState array that will be a gameboard.
   */
  protected SlotState[][] makeBoard(int emptySlotRow, int emptySlotColumn) {
    SlotState[][] board = new SlotState[size][size];

    for (int w = 0; w < size; w++) {
      for (int h = 0; h < size; h++) {
        if (!isInvalidPos(h, w)) {
          board[w][h] = MarbleSolitaireModelState.SlotState.Marble;
        } else {
          board[w][h] = MarbleSolitaireModelState.SlotState.Invalid;
        }
      }
    }

    board[emptySlotRow][emptySlotColumn] = MarbleSolitaireModelState.SlotState.Empty;

    return board;
  }

  /**
   * Move method that allows the user to move from one spot to another, but rules are specific to.
   * game.
   * @param fromRow the row number of the position to be moved from.
   *                (starts at 0).
   * @param fromCol the column number of the position to be moved from.
   *                (starts at 0).
   * @param toRow   the row number of the position to be moved to.
   *                (starts at 0).
   * @param toCol   the column number of the position to be moved to.
   *                (starts at 0).
   * @throws IllegalArgumentException is thrown if a move is invalid (different per game)
   */
  public abstract void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException;

  /**
   * Calculates the board size based on the armThickness.
   * .
   * @return the calculated board size.
   */
  @Override
  public int getBoardSize() {
    return (armThickness * 3) - 2;
  }


  /**
   * Find the SlotState of the given position.
   * .
   *
   * @param row the row of the position sought, starting at 0.
   * @param col the column of the position sought, starting at 0.
   * @return the SlotState of the position given.
   * @throws IllegalArgumentException if the desired position is out of bounds.
   */
  @Override
  public MarbleSolitaireModelState.SlotState getSlotAt(int row, int col)
          throws IllegalArgumentException {

    if (isOutOfBox(row, col)) {
      throw new IllegalArgumentException("Position is out of bounds");
    } else {
      return board[row][col];
    }
  }

  /**
   * Returns the score, which is the number of marbles on the board.
   * .
   *
   * @return an int that is the score.
   */
  @Override
  public int getScore() {
    int score = 0;

    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (board[r][c].equals(MarbleSolitaireModelState.SlotState.Marble)) {
          score = score + 1;
        }
      }
    }
    return score;
  }

  /**
   * checks to see if the given position is out of the bounds.
   *
   * @param row the row of the given position.
   * @param col the column the given position.
   * @return a boolean, true if the given position is out of bounds and false otherwise.
   */
  protected boolean isOutOfBox(int row, int col) {
    return (row < 0 || col < 0 || row >= this.size || col >= this.size);
  }

  /**
   * Checks if the current game has any moves left (different depending on game).
   * @return true of the game is over, and false otherwise.
   */
  public abstract boolean isGameOver();

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
  protected abstract boolean hasMoves(int fromRow, int fromCol, int toRow, int toCol);

  /**
   * Checks if a given position is invalid, based on the rules of the game.
   * @param col the given column of the desired position.
   * @param row the given row of the desired position.
   * @return true if the given position is invalid, and false otherwise.
   */
  protected abstract boolean isInvalidPos(int col, int row);
}
