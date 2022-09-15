package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Displays the view of the MarbleSolitaire class in the console with the representation of .
 * marbles as "O", empty spaces as "_" and invalid spaces as " ".
 */
public class MarbleSolitaireTextView extends AbstractSolitaireView {

  /**
   * Constructor that creates a MarbleSolitaireTextView object by taking in a board and.
   * Appendable.
   * @param board MarbleSolitaireModelState with game conditions.
   * @param log Appendable that will house inputs.
   * @throws IllegalArgumentException thrown if any of the inputs are null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState board, Appendable log)
          throws IllegalArgumentException {
    super(board, log);
  }

  /**
   * This takes in a MarbleSolitaireModelState.
   * which will help display a board.
   * @param board the MarbleSolitaireModelState that we will use to display the board.
   * @throws IllegalArgumentException if the board given is null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState board) throws IllegalArgumentException {
    this(board, System.out);
  }

  /**
   * Prints the board as a string, using the appropriate SlotState values.
   * and printing the corresponding strings.
   * @return the string format of the board
   */
  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();

    int armLength = (board.getBoardSize() + 2) / 3;

    for (int r = 0; r < board.getBoardSize(); r++) {
      for (int c = 0; c < board.getBoardSize(); c++) {
        if ((c == board.getBoardSize() - 1) || (r == board.getBoardSize())
                || ((board.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Marble)
                || board.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Empty))
                && board.getSlotAt(r, c + 1).equals(MarbleSolitaireModelState.SlotState.Invalid))) {
          if (board.getSlotAt(r,c).equals(MarbleSolitaireModelState.SlotState.Marble)) {
            output.append("O");
          }
          else if (board.getSlotAt(r,c).equals(MarbleSolitaireModelState.SlotState.Empty)) {
            output.append("_");
          }
          break;
        }
        if (board.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Invalid)) {
          output.append("  ");
        }
        if (board.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Marble)) {
          output.append("O ");
        }
        if (board.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Empty)) {
          output.append("_ ");
        }
      }
      if (r < board.getBoardSize() - 1) {
        output.append("\n");
      }
    }

    return output.substring(0, output.length());
  }

}
