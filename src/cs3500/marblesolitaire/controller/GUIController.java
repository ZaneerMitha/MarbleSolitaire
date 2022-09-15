package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

public class GUIController implements Features {

  MarbleSolitaireModelState model;
  MarbleSolitaireView view;

  public GUIController(MarbleSolitaireModelState model, MarbleSolitaireView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void mouseMove(int row, int col) {

  }
}
