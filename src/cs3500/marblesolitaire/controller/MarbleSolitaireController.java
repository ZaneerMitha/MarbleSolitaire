package cs3500.marblesolitaire.controller;

/**
 * This interface houses all the methods for the controller of the solitaire game.
 */
public abstract class MarbleSolitaireController {

  /**
   * This method runs the game that it is called on, and takes in inputs to call the methods in.
   * the game.
   * @throws IllegalStateException is thrown when the readable cannot read any inputs.
   */
  public abstract void playGame() throws IllegalStateException;
}
