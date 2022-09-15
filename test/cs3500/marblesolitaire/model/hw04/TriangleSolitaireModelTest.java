package cs3500.marblesolitaire.model.hw04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * This class tests all the methods in the TriangleSolitaireModel class.
 */
public class TriangleSolitaireModelTest {
  MarbleSolitaireModel game5;
  MarbleSolitaireModel game3;
  MarbleSolitaireModel gameCornerEmpty;
  MarbleSolitaireModel gameBottomEmpty;
  MarbleSolitaireModel bigGame;
  MarbleSolitaireModel gameBottomEmpty2;
  MarbleSolitaireModel gameBottomRightEmpty;
  MarbleSolitaireModel gameBottomLeftEmpty;
  MarbleSolitaireModel gameBottomRightEmpty2;

  @Before
  public void initData() {
    game5 = new TriangleSolitaireModel();
    game3 = new TriangleSolitaireModel(3);
    gameCornerEmpty = new TriangleSolitaireModel(4,0);
    gameBottomEmpty = new TriangleSolitaireModel(5, 4, 2);
    bigGame = new TriangleSolitaireModel(101);
    gameBottomEmpty2 = new TriangleSolitaireModel(2,2);
    gameBottomRightEmpty = new TriangleSolitaireModel(4,4);
    gameBottomLeftEmpty = new TriangleSolitaireModel(4,0);
    gameBottomRightEmpty2 = new TriangleSolitaireModel(4,4);
  }

  @Test
  public void makeValidGame() {
    MarbleSolitaireModel game4 = new TriangleSolitaireModel();
    MarbleSolitaireModel game7 = new TriangleSolitaireModel(7);
    MarbleSolitaireModel gameLeftCornerEmpty = new TriangleSolitaireModel(4,0);
    MarbleSolitaireModel gameMidEmpty =
            new TriangleSolitaireModel(3, 2, 0);
    assertEquals(14, game4.getScore());
    assertEquals(27, game7.getScore());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            gameLeftCornerEmpty.getSlotAt(4,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            gameMidEmpty.getSlotAt(2,0));
    assertEquals(5,
            gameMidEmpty.getScore());

  }

  @Test
  public void makeInvalidGame() {
    try {
      MarbleSolitaireModel coolGame = new TriangleSolitaireModel(-1);
      fail("Constructor did not throw IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Size must be greater than 0", e.getMessage());
    }
    try {
      MarbleSolitaireModel coolGame = new TriangleSolitaireModel(5, 0);
      fail("Constructor did not throw IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (5,0)", e.getMessage());
    }
    try {
      MarbleSolitaireModel coolGame = new TriangleSolitaireModel(-1, 3, 3);
      fail("Constructor did not throw IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Size must be greater than 0", e.getMessage());
    }
    try {
      MarbleSolitaireModel coolGame = new TriangleSolitaireModel(5, 5, 0);
      fail("Constructor did not throw IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (5,0)", e.getMessage());
    }

  }

  @org.junit.Test
  public void move() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(0,0));

    game5.move(2,0,0,0);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(0,0));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(0,0));

    game3.move(2,0,0,0);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(0,0));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameCornerEmpty.getSlotAt(4,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameCornerEmpty.getSlotAt(4,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameCornerEmpty.getSlotAt(4,0));

    gameCornerEmpty.move(4,2,4,0);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameCornerEmpty.getSlotAt(4,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameCornerEmpty.getSlotAt(4,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameCornerEmpty.getSlotAt(4,0));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(3,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty.getSlotAt(4,2));

    gameBottomEmpty.move(2,0,4,2);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty.getSlotAt(3,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(4,2));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty2.getSlotAt(4,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty2.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty2.getSlotAt(2,2));

    gameBottomEmpty2.move(4,4,2,2);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty2.getSlotAt(4,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty2.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty2.getSlotAt(2,2));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomRightEmpty.getSlotAt(2,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomRightEmpty.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomRightEmpty.getSlotAt(4,4));

    gameBottomRightEmpty.move(2,2,4,4);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomRightEmpty.getSlotAt(2,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomRightEmpty.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomRightEmpty.getSlotAt(4,4));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomLeftEmpty.getSlotAt(2,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomLeftEmpty.getSlotAt(3,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomLeftEmpty.getSlotAt(4,0));

    gameBottomLeftEmpty.move(2,2,4,0);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomLeftEmpty.getSlotAt(2,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomLeftEmpty.getSlotAt(3,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomLeftEmpty.getSlotAt(4,0));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomRightEmpty2.getSlotAt(4,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomRightEmpty2.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomRightEmpty2.getSlotAt(4,4));

    gameBottomRightEmpty2.move(4,2,4,4);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomRightEmpty2.getSlotAt(4,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomRightEmpty2.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomRightEmpty2.getSlotAt(4,4));
  }

  @Test
  public void invalidMoveTest() {
    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(2,0));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(1,0));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(0,0));

      game5.move(1,0,0,0);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Cells are not two apart",e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(2,0));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(1,0));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(0,0));

      game5.move(3,0,0,0);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Cells are not two apart",e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty.getSlotAt(4,2));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(4,1));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(4,3));

      gameBottomEmpty.move(4,1,4,3);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Marble states are not correct", e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(4,1));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty.getSlotAt(4,2));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(4,0));

      gameBottomEmpty.move(4,2,4,0);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Marble states are not correct", e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(4,1));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(4,2));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(4,3));

      game5.move(4,1,4,3);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Marble states are not correct", e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game3.getSlotAt(0,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(2,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(3,3));

      game3.move(0,3,3,3);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Position is out of bounds",e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game5.getSlotAt(0,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(0,0));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(2,1));

      game5.move(-1,0,0,0);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Out of box position: From (-1,0) To (0,0)",e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game5.getSlotAt(3,5));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(0,0));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(2,1));

      game5.move(2,1,0,100);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Position is out of bounds",e.getMessage());
    }
  }

  @org.junit.Test
  public void isGameOver() {

    assertFalse(game5.isGameOver());
    game5.move(2,2,0,0);
    assertFalse(game5.isGameOver());
    game5.move(2,0,2,2);
    assertFalse(game5.isGameOver());
    game5.move(4,2,2,0);
    assertFalse(game5.isGameOver());
    game5.move(4,3,2,1);
    assertFalse(game5.isGameOver());
    game5.move(3,3,1,1);
    assertFalse(game5.isGameOver());
    game5.move(1,0,3,2);
    assertFalse(game5.isGameOver());
    game5.move(0,0,2,2);
    assertFalse(game5.isGameOver());
    game5.move(3,0,1,0);
    assertFalse(game5.isGameOver());
    game5.move(4,0,4,2);
    assertTrue(game5.isGameOver());
  }

  @org.junit.Test
  public void getBoardSize() {
    assertEquals(5, game5.getBoardSize());
    assertEquals(3, game3.getBoardSize());
    assertEquals(5, gameCornerEmpty.getBoardSize());
    assertEquals(5, gameBottomEmpty.getBoardSize());
    assertEquals(101, bigGame.getBoardSize());
  }

  @org.junit.Test
  public void getSlotAt() {
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game5.getSlotAt(0,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game5.getSlotAt(3,4));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game3.getSlotAt(0,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game3.getSlotAt(1,2));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameCornerEmpty.getSlotAt(4,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameCornerEmpty.getSlotAt(4,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, gameCornerEmpty.getSlotAt(3,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, gameCornerEmpty.getSlotAt(1,2));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty.getSlotAt(4,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, gameBottomEmpty.getSlotAt(1,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, gameBottomEmpty.getSlotAt(2,3));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, bigGame.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, bigGame.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, bigGame.getSlotAt(1,100));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, bigGame.getSlotAt(1,3));
  }

  @org.junit.Test
  public void getScore() {
    assertEquals(14, game5.getScore());
    game5.move(2,2,0,0);
    assertEquals(13, game5.getScore());
    assertEquals(5150, bigGame.getScore());
  }

}