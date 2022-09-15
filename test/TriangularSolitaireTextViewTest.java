import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import static org.junit.Assert.assertEquals;

/**
 * This class houses the tests for all the methods and constructors in the.
 * TriangularSolitaireTextView class.
 */
public class TriangularSolitaireTextViewTest {

  MarbleSolitaireModel game5;
  MarbleSolitaireView game5View;
  MarbleSolitaireModel game3;
  MarbleSolitaireView game3View;

  @Before
  public void initData() {
    game5 = new TriangleSolitaireModel();
    game3 = new TriangleSolitaireModel(3);

    game5View = new TriangleSolitaireTextView(game5);
    game3View = new TriangleSolitaireTextView(game3);

  }

  @Test
  public void makeValidView() {
    game5 = new TriangleSolitaireModel();
    game3 = new TriangleSolitaireModel(3);

    game5View = new TriangleSolitaireTextView(game5);
    game3View = new TriangleSolitaireTextView(game3);

    assertEquals(game5View, game5View);

  }

  @Test
  public void testToString() {

    assertEquals("    _" + "\n" +
                    "   O O" + "\n" +
                    "  O O O" + "\n" +
                    " O O O O" + "\n" +
                    "O O O O O", game5View.toString());

    assertEquals(
            "  _" + "\n" +
                    " O O" + "\n" +
                    "O O O", game3View.toString());

  }

  @Test
  public void testAfterMove() {

    assertEquals("    _" + "\n" +
            "   O O" + "\n" +
            "  O O O" + "\n" +
            " O O O O" + "\n" +
            "O O O O O", game5View.toString());

    game5.move(2,0,0,0);

    assertEquals("    O" + "\n" +
            "   _ O" + "\n" +
            "  _ O O" + "\n" +
            " O O O O" + "\n" +
            "O O O O O", game5View.toString());
  }

  @Test
  public void testRenderBoard() throws IOException {
    MarbleSolitaireModel game = new TriangleSolitaireModel();
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(game, log);

    view.renderBoard();

    assertEquals("    _" + "\n" +
            "   O O" + "\n" +
            "  O O O" + "\n" +
            " O O O O" + "\n" +
            "O O O O O", log.toString());
  }

  @Test
  public void testRenderBoardAfterMove() throws IOException {
    MarbleSolitaireModel game = new TriangleSolitaireModel();
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(game, log);

    game.move(2, 0,0,0);
    view.renderBoard();

    assertEquals("    O" + "\n" +
            "   _ O" + "\n" +
            "  _ O O" + "\n" +
            " O O O O" + "\n" +
            "O O O O O", log.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    MarbleSolitaireModel game = new TriangleSolitaireModel();
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(game, log);

    view.renderMessage("hey!");

    assertEquals("hey!", log.toString());
  }

  @Test
  public void testValidConstructor() {
    MarbleSolitaireModel game = new TriangleSolitaireModel();
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(game, log);

    assertEquals("    _" + "\n" +
            "   O O" + "\n" +
            "  O O O" + "\n" +
            " O O O O" + "\n" +
            "O O O O O", view.toString());
    assertEquals("",log.toString());
  }

  @Test
  public void testInValidConstructorNullModel() {
    MarbleSolitaireModel game = null;
    Appendable log = new StringBuilder();

    try {
      MarbleSolitaireView view = new TriangleSolitaireTextView(game, log);
    } catch (IllegalArgumentException e) {
      assertEquals("Null Board", e.getMessage());
    }

  }

  @Test
  public void testInValidConstructorNullAppendable() {
    MarbleSolitaireModel game = new TriangleSolitaireModel();
    Appendable log = null;

    try {
      MarbleSolitaireView view = new TriangleSolitaireTextView(game, log);
    } catch (IllegalArgumentException e) {
      assertEquals("Null Appendable", e.getMessage());
    }

  }

}