package fr.charlier.puissance4game.model;

import fr.charlier.puissance4game.controller.Constante;
import java.awt.*;


public class Hand {


    private Color tokenColor = null;
    private int nbTokens = Constante.NB_TOKEN / 2;
    private Tokens token;

    public Hand(Color color) {
        this.tokenColor = color;
        token = new Tokens(color);

    }

    public Color getTokenColor() {
        return tokenColor;
    }

    public void setTokenColor(Color tokenColor) {
        this.tokenColor = tokenColor;
    }

    public int getNbTokens() {
        return nbTokens;
    }

    public void setNbTokens(int nbTokens) {
        this.nbTokens = nbTokens;
    }

}