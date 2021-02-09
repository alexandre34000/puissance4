package fr.charlier.puissance4game.model;

import java.awt.*;


public class Player {

    private String playerName = "";
    private Color color = null;
    private Hand hand = null;


    public Player(String name, Color color) {
        this.playerName = name;
        this.color = color;
        hand = new Hand(color);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
