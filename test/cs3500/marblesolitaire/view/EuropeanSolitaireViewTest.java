package cs3500.marblesolitaire.view;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * This is a test class that tests all the functions in the EnglishSolitaireView class.
 */
public class EuropeanSolitaireViewTest {


  MarbleSolitaireModel game3;
  MarbleSolitaireView game3View;
  MarbleSolitaireModel game5;
  MarbleSolitaireView game5View;



  @Before
  public void initData() {
    game3 = new EuropeanSolitaireModel();
    game5 = new EuropeanSolitaireModel(5);

    game3View = new EuropeanSolitaireView(game3);
    game5View = new EuropeanSolitaireView(game5);

  }

  @Test
  public void makeValidView() {
    game3 = new EnglishSolitaireModel();
    game5 = new EnglishSolitaireModel(5);

    game3View = new MarbleSolitaireTextView(game3);
    game5View = new MarbleSolitaireTextView(game5);

    assertEquals(game3View, game3View);

  }

  @Test
  public void testToString() {

    assertEquals(
            "    O O O" + "\n" +
                    "  O O O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "O O O _ O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "  O O O O O" + "\n" +
                    "    O O O", game3View.toString());

    assertEquals(
            "        O O O O O" + "\n" +
                    "      O O O O O O O" + "\n" +
                    "    O O O O O O O O O" + "\n" +
                    "  O O O O O O O O O O O" + "\n" +
                    "O O O O O O O O O O O O O" + "\n" +
                    "O O O O O O O O O O O O O" + "\n" +
                    "O O O O O O _ O O O O O O" + "\n" +
                    "O O O O O O O O O O O O O" + "\n" +
                    "O O O O O O O O O O O O O" + "\n" +
                    "  O O O O O O O O O O O" + "\n" +
                    "    O O O O O O O O O" + "\n" +
                    "      O O O O O O O" + "\n" +
                    "        O O O O O", game5View.toString());

  }

  @Test
  public void testAfterMove() {

    assertEquals(
            "    O O O" + "\n" +
                    "  O O O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "O O O _ O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "  O O O O O" + "\n" +
                    "    O O O", game3View.toString());

    game3.move(1,3,3,3);

    assertEquals(
            "    O O O" + "\n" +
                    "  O O _ O O" + "\n" +
                    "O O O _ O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "  O O O O O" + "\n" +
                    "    O O O", game3View.toString());
  }

  @Test
  public void testRenderBoard() throws IOException {
    MarbleSolitaireModel game = new EuropeanSolitaireModel();
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new EuropeanSolitaireView(game, log);

    view.renderBoard();

    assertEquals(
            "    O O O" + "\n" +
                    "  O O O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "O O O _ O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "  O O O O O" + "\n" +
                    "    O O O", log.toString());
  }

  @Test
  public void testRenderBoardAfterMove() throws IOException {
    MarbleSolitaireModel game = new EuropeanSolitaireModel();
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new EuropeanSolitaireView(game, log);

    game.move(1, 3,3,3);
    view.renderBoard();

    assertEquals(
            "    O O O" + "\n" +
                    "  O O _ O O" + "\n" +
                    "O O O _ O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "  O O O O O" + "\n" +
                    "    O O O", log.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    MarbleSolitaireModel game = new EuropeanSolitaireModel();
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new EuropeanSolitaireView(game, log);

    view.renderMessage("hey!");

    assertEquals("hey!", log.toString());
  }

  @Test
  public void testValidConstructor() {
    MarbleSolitaireModel game = new EuropeanSolitaireModel();
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new EuropeanSolitaireView(game, log);

    assertEquals(
            "    O O O" + "\n" +
                    "  O O O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "O O O _ O O O" + "\n" +
                    "O O O O O O O" + "\n" +
                    "  O O O O O" + "\n" +
                    "    O O O", view.toString());
    assertEquals("",log.toString());
  }

  @Test
  public void testInValidConstructorNullModel() {
    MarbleSolitaireModel game = null;
    Appendable log = new StringBuilder();

    try {
      MarbleSolitaireView view = new EuropeanSolitaireView(game, log);
    } catch (IllegalArgumentException e) {
      assertEquals("Null Board", e.getMessage());
    }

  }

  @Test
  public void testInValidConstructorNullAppendable() {
    MarbleSolitaireModel game = new EuropeanSolitaireModel();
    Appendable log = null;

    try {
      MarbleSolitaireView view = new EuropeanSolitaireView(game, log);
    } catch (IllegalArgumentException e) {
      assertEquals("Null Appendable", e.getMessage());
    }

  }
}