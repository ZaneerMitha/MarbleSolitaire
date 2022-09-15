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
 * This is a test class that tests all the functions in the EuropeanSolitaireModel class.
 */
public class EuropeanSolitaireModelTest {

  MarbleSolitaireModel game3;
  MarbleSolitaireModel game5;
  MarbleSolitaireModel gameCornerEmpty;
  MarbleSolitaireModel gameBottomEmpty;
  MarbleSolitaireModel bigGame;

  MarbleSolitaireModel gameCornerEmpty2;

  @Before
  public void initData() {
    game3 = new EuropeanSolitaireModel();
    game5 = new EuropeanSolitaireModel(5);
    gameCornerEmpty = new EuropeanSolitaireModel(0,4);
    gameBottomEmpty = new EuropeanSolitaireModel(3, 3, 6);
    bigGame = new EuropeanSolitaireModel(101);
    gameCornerEmpty2 = new EuropeanSolitaireModel(3,1,1);

  }

  @Test
  public void makeValidGame() {
    MarbleSolitaireModel game4 = new EuropeanSolitaireModel();
    MarbleSolitaireModel game7 = new EuropeanSolitaireModel(7);
    MarbleSolitaireModel gameLeftCornerEmpty = new EuropeanSolitaireModel(0,2);
    MarbleSolitaireModel gameTopEmpty =
            new EuropeanSolitaireModel(3, 3, 0);
    assertEquals(36, game4.getScore());
    assertEquals(276, game7.getScore());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            gameLeftCornerEmpty.getSlotAt(0,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            gameTopEmpty.getSlotAt(3,0));

  }

  @Test
  public void makeInvalidGame() {
    try {
      MarbleSolitaireModel coolGame = new EuropeanSolitaireModel(4);
      fail("Constructor did not throw IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness: 4", e.getMessage());
    }
    try {
      MarbleSolitaireModel coolGame = new EuropeanSolitaireModel(0, 0);
      fail("Constructor did not throw IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,0)", e.getMessage());
    }
    try {
      MarbleSolitaireModel coolGame = new EuropeanSolitaireModel(4, 3, 3);
      fail("Constructor did not throw IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness: 4", e.getMessage());
    }
    try {
      MarbleSolitaireModel coolGame = new EuropeanSolitaireModel(3, 0, 0);
      fail("Constructor did not throw IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,0)", e.getMessage());
    }

  }

  @org.junit.Test
  public void move() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(1,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(2,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(3,3));

    game3.move(1,3,3,3);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(1,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(2,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(3,3));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(4,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(5,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(6,6));

    game5.move(4,6,6,6);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(4,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(5,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(6,6));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameCornerEmpty.getSlotAt(2,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameCornerEmpty.getSlotAt(1,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameCornerEmpty.getSlotAt(0,4));

    gameCornerEmpty.move(2,4,0,4);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameCornerEmpty.getSlotAt(2,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameCornerEmpty.getSlotAt(2,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameCornerEmpty.getSlotAt(0,4));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(3,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(3,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty.getSlotAt(3,6));

    gameBottomEmpty.move(3,4,3,6);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty.getSlotAt(3,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty.getSlotAt(3,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(3,6));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameCornerEmpty2.getSlotAt(3,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameCornerEmpty2.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameCornerEmpty2.getSlotAt(1,1));

    gameCornerEmpty2.move(3,1,1,1);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameCornerEmpty2.getSlotAt(3,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameCornerEmpty2.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameCornerEmpty2.getSlotAt(1,1));
  }

  @Test
  public void invalidMoveTest() {
    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(1,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(2,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(3,3));

      game3.move(2,3,3,3);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Cells are not two apart",e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(6,0));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(6,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(6,6));

      game5.move(6,0,6,6);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Cells are not two apart",e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(8,4));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(7,5));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(6,6));

      game5.move(8,4,6,6);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Cells are not two apart",e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(3,2));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(3,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(3,4));

      game3.move(3,2,3,4);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Marble states are not correct", e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(2,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(2,4));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(2,5));

      game3.move(2,3,2,5);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Marble states are not correct", e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(1,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(2,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(3,3));

      game3.move(1,3,3,3);

      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(1,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(2,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(3,3));

      game3.move(3,3,1,3);
    }
    catch (IllegalArgumentException e) {
      assertEquals("There is no marble in the middle",e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game3.getSlotAt(0,0));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(2,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(3,3));

      game3.move(0,0,3,3);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid positions: From (0,0) To (3,3)",e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game3.getSlotAt(0,0));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(2,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(3,3));

      game3.move(-1,0,3,0);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Out of box position: From (-1,0) To (3,0)",e.getMessage());
    }

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game3.getSlotAt(0,0));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(2,3));
      assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(3,3));

      game3.move(3,3,3,100);
    }
    catch (IllegalArgumentException e) {
      assertEquals("Out of box position: From (3,3) To (3,100)",e.getMessage());
    }
  }

  @org.junit.Test
  public void isGameOver() {

    assertFalse(game3.isGameOver());
    game3.move(1,3,3,3);
    assertFalse(game3.isGameOver());
    game3.move(2,1,2,3);
    assertFalse(game3.isGameOver());
    game3.move(0,2,2,2);
    assertFalse(game3.isGameOver());
    game3.move(0,4,0,2);
    assertFalse(game3.isGameOver());
    game3.move(3,2,1,2);
    assertFalse(game3.isGameOver());
    game3.move(0,2,2,2);
    assertFalse(game3.isGameOver());
    game3.move(2,3,2,1);
    assertFalse(game3.isGameOver());
    game3.move(5,2,3,2);
    assertFalse(game3.isGameOver());
    game3.move(4,0,4,2);
    assertFalse(game3.isGameOver());
    game3.move(2,0,4,0);
    assertFalse(game3.isGameOver());
    game3.move(2,1,4,1);
    assertFalse(game3.isGameOver());
    game3.move(3,2,5,2);
    assertFalse(game3.isGameOver());
    game3.move(4,0,4,2);
    assertFalse(game3.isGameOver());
    game3.move(4,3,4,1);
    assertFalse(game3.isGameOver());
    game3.move(4,5,4,3);
    assertFalse(game3.isGameOver());
    game3.move(6,4,4,4);
    assertFalse(game3.isGameOver());
    game3.move(5,2,5,4);
    assertFalse(game3.isGameOver());
    game3.move(6,2,6,4);
    assertFalse(game3.isGameOver());
    game3.move(4,4,4,2);
    assertFalse(game3.isGameOver());
    game3.move(6,4,4,4);
    assertFalse(game3.isGameOver());
    game3.move(4,1,4,3);
    assertFalse(game3.isGameOver());
    game3.move(4,3,4,5);
    assertFalse(game3.isGameOver());
    game3.move(2,4,4,4);
    assertFalse(game3.isGameOver());
    game3.move(2,6,2,4);
    assertFalse(game3.isGameOver());
    game3.move(3,6,3,4);
    assertFalse(game3.isGameOver());
    game3.move(3,4,5,4);
    assertFalse(game3.isGameOver());
    game3.move(4,6,4,4);
    assertFalse(game3.isGameOver());
    game3.move(5,4,3,4);
    assertFalse(game3.isGameOver());
    game3.move(3,3,3,5);
    assertFalse(game3.isGameOver());
    game3.move(1,4,3,4);
    assertFalse(game3.isGameOver());
    game3.move(3,5,3,3);
    assertTrue(game3.isGameOver());
  }

  @org.junit.Test
  public void getBoardSize() {
    assertEquals(7, game3.getBoardSize());
    assertEquals(13, game5.getBoardSize());
    assertEquals(7, gameCornerEmpty.getBoardSize());
    assertEquals(7, gameBottomEmpty.getBoardSize());
    assertEquals(301, bigGame.getBoardSize());
  }

  @org.junit.Test
  public void getSlotAt() {
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(1,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game3.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game3.getSlotAt(6,6));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game5.getSlotAt(6,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game5.getSlotAt(4,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game5.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game5.getSlotAt(12,12));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameCornerEmpty.getSlotAt(0,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameCornerEmpty.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, gameCornerEmpty.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, gameCornerEmpty.getSlotAt(6,6));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, gameBottomEmpty.getSlotAt(3,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, gameBottomEmpty.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, gameBottomEmpty.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, gameBottomEmpty.getSlotAt(6,6));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, bigGame.getSlotAt(150,150));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, bigGame.getSlotAt(149,149));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, bigGame.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, bigGame.getSlotAt(300,300));
  }

  @org.junit.Test
  public void getScore() {
    assertEquals(36,game3.getScore());
    game3.move(1,3,3,3);
    assertEquals(35,game3.getScore());
    assertEquals(128,game5.getScore());
  }

}