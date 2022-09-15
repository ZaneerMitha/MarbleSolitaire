package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Displays the view of the MarbleSolitaire class in the console with the representation of .
 * marbles as "O", empty spaces as "_" and invalid spaces as " ".
 */
public abstract class AbstractSolitaireView implements MarbleSolitaireView {

  protected MarbleSolitaireModelState board;
  protected Appendable log;

  /**
   * Constructor that creates a AbstractSolitaireView object by taking in a board and.
   * Appendable.
   * @param board MarbleSolitaireModelState with game conditions.
   * @param log Appendable that will house inputs.
   * @throws IllegalArgumentException thrown if any of the inputs are null.
   */
  public AbstractSolitaireView(MarbleSolitaireModelState board, Appendable log)
          throws IllegalArgumentException {
    if (board == null) {
      throw new IllegalArgumentException("Null Board");
    }
    if (log == null) {
      throw new IllegalArgumentException("Null Appendable");
    }

    this.board = board;
    this.log = log;
  }

  /**
   * Prints the board as a string, using the appropriate SlotState values.
   * and printing the corresponding strings.
   * @return the string format of the board
   */
  public abstract String toString();

  /**
   * Appends the board as a string to the log, to display it to the console.
   * @throws IOException is thrown if the method cannot read an input.
   */
  @Override
  public void renderBoard() throws IOException {
    log.append(this.toString());
  }

  /**
   * Appends a message as a string to the log, to display it to the console.
   * @throws IOException is thrown if the method cannot read an input.
   */
  @Override
  public void renderMessage(String message) throws IOException {
    log.append(message);
  }

}
