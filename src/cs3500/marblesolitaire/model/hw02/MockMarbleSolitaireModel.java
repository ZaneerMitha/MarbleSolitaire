package cs3500.marblesolitaire.model.hw02;

import java.util.Objects;

/**
 * Mock class used to test the communication between the model and the controller, using a .
 * StringBuilder to "mock" all of the model's methods.
 */
public class MockMarbleSolitaireModel implements MarbleSolitaireModel {

  private final StringBuilder log;

  /**
   * Constructor that takes in the StringBuilder and appends strings to it based on what methods.
   * are called.
   * @param log The StringBuilder that is initialized as a field.
   */
  public MockMarbleSolitaireModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  /**
   * "Mocks" the model class's move method by appending the appropriate inputs to the appendable.
   * @param fromRow the row number of the position to be moved from.
   *                (starts at 0).
   * @param fromCol the column number of the position to be moved from.
   *                (starts at 0).
   * @param toRow   the row number of the position to be moved to.
   *                (starts at 0).
   * @param toCol   the column number of the position to be moved to.
   *                (starts at 0).
   * @throws IllegalArgumentException is thrown if move is invalid in one way or another.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    log.append(String.format("fromRow = %d, fromCol = %d, toRow = %d, toCol = %d",
            fromRow, fromCol, toRow, toCol));
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    return 0;
  }

  /**
   * "Mocks" the getSlotAt method by appending the inputs to the appendable.
   * @param row the row of the position sought, starting at 0.
   * @param col the column of the position sought, starting at 0.
   * @returns null, but appends the inputs to the appendable.
   * @throws IllegalArgumentException is thrown if position is invalid.
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    log.append(String.format("row =  %d, col = %d", row, col));
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
