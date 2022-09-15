package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * This class has the implementation for all the methods in the MarbleSolitaireController.
 * interface. It has the playGame method which runs the game, and also every helper method used in
 * playGame. This class is used by the client to run the game.
 */
public class MarbleSolitaireControllerImpl extends MarbleSolitaireController {

  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;
  private final Readable reader;

  /**
   * Constructor for the controller that takes in model, view, and reader and checks.
   * if they are null.
   * @param model MarbleSolitaireModel that establishes the game conditions.
   * @param view MarbleSolitaireView that uses the model to create a view of the game.
   * @param reader Readable object used later to read inputs.
   * @throws IllegalArgumentException thrown if any of the inputs are null.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                        MarbleSolitaireView view, Readable reader)
          throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model is null");
    }
    if (view == null) {
      throw new IllegalArgumentException("View is null");
    }
    if (reader == null) {
      throw new IllegalArgumentException("Reader is null");
    }

    this.model = model;
    this.view = view;
    this.reader = reader;
  }

  @Override
  public void playGame() throws IllegalStateException {

    Scanner scan = new Scanner(reader);
    int fromRow;
    int fromCol;
    int toRow;
    int toCol;

    renderBoard();
    showScore();

    while (!model.isGameOver()) {

      fromRow = getInput(scan);
      if (fromRow == -1) {
        quit();
        break;
      }

      fromCol = getInput(scan);
      if (fromCol == -1) {
        quit();
        break;
      }

      toRow = getInput(scan);
      if (toRow == -1) {
        quit();
        break;
      }

      toCol = getInput(scan);
      if (toCol == -1) {
        quit();
        break;
      }

      try {
        model.move(fromRow - 1, fromCol - 1, toRow - 1, toCol - 1);
      } catch (IllegalArgumentException e) {
        showMessage("Invalid move. Play again. " + e.getMessage());
      }

      renderBoard();
      showScore();
    }

    if (model.isGameOver()) {

      showMessage("Game over!");
      renderBoard();
      showScore();
    }

  }

  // This helper simply abstracts the try catch block that renders the board, since we use it
  // quite often throughout the controller.
  private void renderBoard() {
    try {
      view.renderBoard();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  // This helper simply abstracts the try catch block that renders the score, since we use it
  // quite often throughout the controller.
  private void showScore() {
    try {
      view.renderMessage("\nScore: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  // This helper simply abstracts the try catch block that renders a desired message,
  // since we use it quite often throughout the controller.
  private void showMessage(String message) {
    try {
      view.renderMessage(message + "\n");
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  // This helper simply abstracts the methods that are called when the game is quit,
  // since we use them quite often throughout the controller.
  private void quit() {
    showMessage("Game quit!");
    showMessage("State of game when quit:");
    renderBoard();
    showScore();
  }

  // This helper checks the input and checks if it is valid (q or an integer)
  private int getInput(Scanner scan) {

    while (!scan.hasNextInt()) {
      String input;
      try {
        input = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException();
      }

      if (input.equalsIgnoreCase("q")) {
        return -1;
      }
      else {
        showMessage("Invalid Input " + input);
      }
    }
    return scan.nextInt();
  }

}
