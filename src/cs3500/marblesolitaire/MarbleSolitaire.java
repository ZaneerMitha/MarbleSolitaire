package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.EuropeanSolitaireView;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * This class holds the main() methods for MarbleSolitaire that allows for the user to play any.
 * variation of the game that they want. It also houses helper methods for the main() methods.
 */
public final class MarbleSolitaire {

  /**
   * This main method takes in an input of the game state and produces a game for the user to play.
   *
   * @param args the input of what game the user wants to play.
   */
  public static void main(String[] args) {
    System.out.println("What game would you like to play?");
    switch (args[0]) {
      case "english":
        makeGameWithArr(args, "english");
        break;
      case "european":
        makeGameWithArr(args, "european");
        break;

      case "triangular":
        makeGameWithArr(args, "triangular");
        break;
      default:
        System.out.println("We need more information about the game!");
    }
  }

  // creates an english solitaire model game with the given specifications, and also creates
  // a view and controller and runs the game
  private static void makeGame(int size, int mtRow, int mtCol, String gameType) {

    MarbleSolitaireModel game;
    MarbleSolitaireView view;
    Readable reader = new InputStreamReader(System.in);
    MarbleSolitaireController controller;

    switch (gameType) {
      case "english":
        game = new EnglishSolitaireModel(size, mtRow, mtCol);
        view = new MarbleSolitaireTextView(game);
        controller = new MarbleSolitaireControllerImpl(game,
                view, reader);
        controller.playGame();
        break;
      case "european":
        game = new EuropeanSolitaireModel(size, mtRow, mtCol);
        view = new EuropeanSolitaireView(game);
        controller = new MarbleSolitaireControllerImpl(game,
                view, reader);
        controller.playGame();
        break;
      case "triangular":
        game = new TriangleSolitaireModel(size, mtRow, mtCol);
        view = new TriangleSolitaireTextView(game);
        controller = new MarbleSolitaireControllerImpl(game,
                view, reader);
        controller.playGame();
        break;
      default:
        System.out.println("Invalid game type!");
    }

  }

  // checks if the input has both size and hole specified, and creates an english game accordingly
  private static void makeGameWithArr(String[] args, String gameType) {

    switch (gameType) {
      case "english":
        if (args.length > 1 && args[1].equals("-size")) {
          if (args.length == 3) {
            makeGame(Integer
                    .parseInt(args[2]), (Integer
                    .parseInt(args[2]) - 1) + (Integer
                    .parseInt(args[2]) / 2), (Integer
                    .parseInt(args[2]) - 1) + (Integer
                    .parseInt(args[2]) / 2), "english");
          } else {
            makeGame(Integer
                    .parseInt(args[2]), Integer
                    .parseInt(args[4]), Integer
                    .parseInt(args[5]), "english");
          }
        } else if (args.length > 1 && args[1].equals("-hole")) {
          if (args.length == 4) {
            makeGame(3, Integer
                    .parseInt(args[2]), Integer
                    .parseInt(args[3]), "english");
          } else {
            makeGame(Integer
                    .parseInt(args[5]), Integer
                    .parseInt(args[2]), Integer
                    .parseInt(args[3]), "english");
          }
        } else if (args.length == 1) {
          makeGame(3, 3, 3, "english");
        }
        break;

      case "european":
        if (args.length > 1 && args[1].equals("-size")) {
          if (args.length == 3) {
            makeGame(Integer
                    .parseInt(args[2]), (Integer
                    .parseInt(args[2]) - 1) + (Integer
                    .parseInt(args[2]) / 2), (Integer
                    .parseInt(args[2]) - 1) + (Integer
                    .parseInt(args[2]) / 2), "european");
          } else {
            makeGame(Integer
                    .parseInt(args[2]), Integer
                    .parseInt(args[4]), Integer
                    .parseInt(args[5]), "european");
          }
        } else if (args.length > 1 && args[1].equals("-hole")) {
          if (args.length == 4) {
            makeGame(3, Integer
                    .parseInt(args[2]), Integer
                    .parseInt(args[3]), "european");
          } else {
            makeGame(Integer
                    .parseInt(args[5]), Integer
                    .parseInt(args[2]), Integer
                    .parseInt(args[3]), "european");
          }
        } else if (args.length == 1) {
          makeGame(3, 3, 3, "european");
        }
        break;

      case "triangular":
        if (args.length > 1 && args[1].equals("-size")) {
          if (args.length == 3) {
            makeGame(Integer
                    .parseInt(args[2]), 0, 0, "triangular");
          } else {
            makeGame(Integer
                    .parseInt(args[2]), Integer
                    .parseInt(args[4]), Integer
                    .parseInt(args[5]), "triangular");
          }
        } else if (args.length > 1 && args[1].equals("-hole")) {
          if (args.length == 4) {
            makeGame(5, Integer
                    .parseInt(args[2]), Integer
                    .parseInt(args[3]), "triangular");
          } else {
            makeGame(Integer
                    .parseInt(args[5]), Integer
                    .parseInt(args[2]), Integer
                    .parseInt(args[3]), "triangular");
          }
        } else if (args.length == 1) {
          makeGame(5, 0, 0, "triangular");
        }
        break;
      default:
        System.out.println("Invalid game type!");
    }
  }

}