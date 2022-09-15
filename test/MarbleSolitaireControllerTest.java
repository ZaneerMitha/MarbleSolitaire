import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MockMarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import static org.junit.Assert.assertEquals;

/**
 * Houses all the tests and edge cases for the controller class. This includes mock testing for.
 * communication between the controller and the model, as well as tests to check if the.
 * constructors for the controller are valid.
 */
public class MarbleSolitaireControllerTest {

  @Test
  public void testGameQuit() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("q\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("Game quit!", introArr[8]);
    assertEquals("State of game when quit:", introArr[9]);
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14] + "\n" +
                    introArr[15] + "\n" +
                    introArr[16]);
    assertEquals("Score: 32\n", introArr[17]);
  }

  @Test
  public void testGameQuit2() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("Q\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("Game quit!", introArr[8]);
    assertEquals("State of game when quit:", introArr[9]);
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14] + "\n" +
                    introArr[15] + "\n" +
                    introArr[16]);
    assertEquals("Score: 32\n", introArr[17]);
  }

  @Test
  public void testGameQuitAfterOneNumber() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("3 q\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("Game quit!", introArr[8]);
    assertEquals("State of game when quit:", introArr[9]);
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14] + "\n" +
                    introArr[15] + "\n" +
                    introArr[16]);
    assertEquals("Score: 32\n", introArr[17]);
  }

  @Test
  public void testGameQuitAfterTwoNumbers() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 4 q\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("Game quit!", introArr[8]);
    assertEquals("State of game when quit:", introArr[9]);
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14] + "\n" +
                    introArr[15] + "\n" +
                    introArr[16]);
    assertEquals("Score: 32\n", introArr[17]);
  }

  @Test
  public void testGameQuitAfterThreeNumbers() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 4 4 q\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("Game quit!", introArr[8]);
    assertEquals("State of game when quit:", introArr[9]);
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14] + "\n" +
                    introArr[15] + "\n" +
                    introArr[16]);
    assertEquals("Score: 32\n", introArr[17]);
  }

  @Test
  public void testGameQuitInBetweenNumbers() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 4 q 4 4\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("Game quit!", introArr[8]);
    assertEquals("State of game when quit:", introArr[9]);
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14] + "\n" +
                    introArr[15] + "\n" +
                    introArr[16]);
    assertEquals("Score: 32\n", introArr[17]);
  }

  @Test
  public void testGameQuitInBetweenNumbers2() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 q 4 4 4\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("Game quit!", introArr[8]);
    assertEquals("State of game when quit:", introArr[9]);
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14] + "\n" +
                    introArr[15] + "\n" +
                    introArr[16]);
    assertEquals("Score: 32\n", introArr[17]);
  }

  @Test
  public void testGameQuitInBetweenNumbers3() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 4 4 q 4\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("Game quit!", introArr[8]);
    assertEquals("State of game when quit:", introArr[9]);
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14] + "\n" +
                    introArr[15] + "\n" +
                    introArr[16]);
    assertEquals("Score: 32\n", introArr[17]);
  }

  @Test
  public void testGameQuitBeforeNumbers() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("q 2 4 4 4\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("Game quit!", introArr[8]);
    assertEquals("State of game when quit:", introArr[9]);
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14] + "\n" +
                    introArr[15] + "\n" +
                    introArr[16]);
    assertEquals("Score: 32\n", introArr[17]);
  }

  @Test
  public void testInitialBoardBeforeQuit() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 4 4 4 q\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
  }

  @Test
  public void testInitialBoardBeforeMove() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 4 4 4 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
  }

  @Test
  public void testInitialBoardAfterMoveCorrectInput() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 4 4 4 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[8] + "\n" +
                    introArr[9] + "\n" +
                    introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14]);
    assertEquals("Score: 31", introArr[15]);
  }

  @Test
  public void testInitialBoardWithInvalid() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("r q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Invalid Input r", introArr[8]);
    assertEquals("Score: 32", introArr[7]);
  }

  @Test
  public void testCorrectAsksAfterInvalid() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 4 a 4 4 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Invalid Input a", introArr[8]);
    assertEquals("Score: 32", introArr[7]);
  }

  @Test
  public void testInitialBoardBoardStatesAfterMoveQuit() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 4 4 4 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 30);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
    assertEquals("    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[8] + "\n" +
                    introArr[9] + "\n" +
                    introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14]);
    assertEquals("Score: 31", introArr[15]);
    assertEquals("Game quit!", introArr[16]);
    assertEquals("State of game when quit:", introArr[17]);
    assertEquals("    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[18] + "\n" +
                    introArr[19] + "\n" +
                    introArr[20] + "\n" +
                    introArr[21] + "\n" +
                    introArr[22] + "\n" +
                    introArr[23] + "\n" +
                    introArr[24]);
    assertEquals("Score: 31", introArr[25]);
  }

  @Test
  public void testMessageWithCellsTooClose() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("3 4 4 4 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
    assertEquals("Invalid move. Play again. Cells are not two apart", introArr[8]);
  }

  @Test
  public void testBoardWithSize5() {

    MarbleSolitaireModel game = new EnglishSolitaireModel(5);
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 50);

    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",

            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6] + "\n" +
                    introArr[7] + "\n" +
                    introArr[8] + "\n" +
                    introArr[9] + "\n" +
                    introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12]);
    assertEquals("Score: 104", introArr[13]);
  }

  @Test
  public void testMessageWithCellsTooFarApart() {

    MarbleSolitaireModel game = new EnglishSolitaireModel(5);
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("7 1 7 7 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 50);

    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",

            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6] + "\n" +
                    introArr[7] + "\n" +
                    introArr[8] + "\n" +
                    introArr[9] + "\n" +
                    introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12]);
    assertEquals("Score: 104", introArr[13]);
    assertEquals("Invalid move. Play again. Cells are not two apart", introArr[14]);
  }

  @Test
  public void testMessageWithDiagonalMove() {

    MarbleSolitaireModel game = new EnglishSolitaireModel(5);
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("9 5 7 7 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 50);

    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",

            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6] + "\n" +
                    introArr[7] + "\n" +
                    introArr[8] + "\n" +
                    introArr[9] + "\n" +
                    introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12]);
    assertEquals("Score: 104", introArr[13]);
    assertEquals("Invalid move. Play again. Cells are not two apart", introArr[14]);
  }

  @Test
  public void testMessageAfterMoveWithNoMarbleInTheMiddle() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("4 3 4 5 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
    assertEquals("Invalid move. Play again. Marble states are not correct", introArr[8]);
  }

  @Test
  public void testMessageAfterMoveWithMarbleInTheMiddle() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("3 4 3 6 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
    assertEquals("Invalid move. Play again. Marble states are not correct", introArr[8]);
  }

  @Test
  public void testMessageAfterTwoMovesWithNoMarbleInTheMiddle() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 4 4 4 4 4 2 4 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
    assertEquals("    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[8] + "\n" +
                    introArr[9] + "\n" +
                    introArr[10] + "\n" +
                    introArr[11] + "\n" +
                    introArr[12] + "\n" +
                    introArr[13] + "\n" +
                    introArr[14]);
    assertEquals("Score: 31", introArr[15]);
    assertEquals("Invalid move. Play again. There is no marble in the middle",
            introArr[16]);
  }

  @Test
  public void testMessageAfterInvalidMove() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("1 1 4 4 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
    assertEquals("Invalid move. Play again. Invalid positions: From (0,0) To (3,3)", introArr[8]);
  }

  @Test
  public void testMessageAfterOutOfBoxMove() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("0 1 4 1 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
    assertEquals("Invalid move. Play again. Out of box position: From (-1,0) To (3,0)",
            introArr[8]);
  }

  @Test
  public void testMessageAfterOutOfBoxMove2() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("4 4 4 101 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
    assertEquals("Invalid move. Play again. Out of box position: From (3,3) To (3,100)",
            introArr[8]);
  }

  @Test
  public void testGameOverMessage() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("2 4 4 4 5 4 3 4 7 4 5 4 4 2 4 4 4 5 4 3 4 7 4 5 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 70);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
    assertEquals("Game over!", introArr[56]);
  }

  // Mock Tests

  @Test
  public void testMoveInputs() {

    Readable reader = new StringReader("");
    StringBuilder log = new StringBuilder();

    MarbleSolitaireModel game = new MockMarbleSolitaireModel(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(game);

    game.move(1, 3, 3, 3);
    assertEquals("fromRow = 1, fromCol = 3, toRow = 3, toCol = 3", log.toString());
  }

  @Test
  public void testControllerComs() {

    Readable reader = new StringReader("2 4 4 4 q");
    StringBuilder log = new StringBuilder();

    MarbleSolitaireModel game = new MockMarbleSolitaireModel(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(game);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();
    assertEquals("fromRow = 1, fromCol = 3, toRow = 3, toCol = 3", log.toString());
  }

  @Test
  public void testControllerComsInvalidMove() {

    Readable reader = new StringReader("4 4 4 4 q");
    StringBuilder log = new StringBuilder();

    MarbleSolitaireModel game = new MockMarbleSolitaireModel(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(game);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();
    assertEquals("fromRow = 3, fromCol = 3, toRow = 3, toCol = 3", log.toString());
  }

  @Test
  public void testControllerComsNegativeMove() {

    Readable reader = new StringReader("-2 4 4 4 q");
    StringBuilder log = new StringBuilder();

    MarbleSolitaireModel game = new MockMarbleSolitaireModel(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(game);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();
    assertEquals("fromRow = -3, fromCol = 3, toRow = 3, toCol = 3", log.toString());
  }

  // Testing the controller with the different constructors

  @Test
  public void testEmptySlotConstructorOutputMessage() {

    MarbleSolitaireModel gameCornerEmpty = new EnglishSolitaireModel(0, 4);
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(gameCornerEmpty, out);
    Readable reader = new StringReader("q");

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(gameCornerEmpty, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O _\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
  }

  @Test
  public void testThreeInputConstructorOutputMessage() {

    MarbleSolitaireModel gameBottomEmpty =
            new EnglishSolitaireModel(3, 3, 6);
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(gameBottomEmpty, out);
    Readable reader = new StringReader("q");

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(gameBottomEmpty, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O _\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
  }

  // Tests for valid and invalid constructors

  @Test
  public void testValidConstructor() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
    Readable reader = new StringReader("q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);

    controller.playGame();

    String intro = out.toString();
    String[] introArr = intro.split("\n", 18);

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            introArr[0] + "\n" +
                    introArr[1] + "\n" +
                    introArr[2] + "\n" +
                    introArr[3] + "\n" +
                    introArr[4] + "\n" +
                    introArr[5] + "\n" +
                    introArr[6]);
    assertEquals("Score: 32", introArr[7]);
  }

  @Test
  public void testInvalidConstructorNullBoard() {

    MarbleSolitaireModel game = null;
    StringBuilder out = new StringBuilder();
    Readable reader = new StringReader("q");

    try {
      MarbleSolitaireView view = new MarbleSolitaireTextView(game, out);
      MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);
    } catch (IllegalArgumentException e) {
      assertEquals("Null Board", e.getMessage());
    }

  }

  @Test
  public void testInvalidConstructorNullView() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = null;
    Readable reader = new StringReader("q");

    try {
      MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);
    } catch (IllegalArgumentException e) {
      assertEquals("View is null", e.getMessage());
    }

  }

  @Test
  public void testInvalidConstructorNullReader() {

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    StringBuilder out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game);
    Readable reader = null;

    try {
      MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, reader);
    } catch (IllegalArgumentException e) {
      assertEquals("Reader is null", e.getMessage());
    }

  }

}