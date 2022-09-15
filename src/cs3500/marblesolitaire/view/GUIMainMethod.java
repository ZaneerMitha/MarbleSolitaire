package cs3500.marblesolitaire.view;

import javax.swing.*;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

public class GUIMainMethod {

  public static void main(String[] args) {
    MarbleSolitaireModelState model = new EnglishSolitaireModel();
    MarbleSolitaireGuiView view = new SwingGuiView(model);
  }
}
