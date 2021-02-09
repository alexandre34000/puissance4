package fr.charlier.puissance4game.games;

import java.awt.*;
import java.util.EventObject;

public class GameChangedEvent extends EventObject {

    private Color newColor;
    private Color newColorJLabel;
    private String player2Name;
    private String player1Name;
    private Color colorPlayer1;
    private Color colorPlayer2;
    private Point newPointStart;
    private String newText;
    private Point newPointEnd;


    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public GameChangedEvent(Object source, Color color) {
        super(source);
        this.newColor = color;
    }

    public GameChangedEvent(Object source, Point pointStart, Point pointEnd) {
        super(source);
        this.newPointStart = pointStart;
        this.newPointEnd = pointEnd;
    }

    public GameChangedEvent(Object source, Color colorPlayer1, Color colorPlayer2) {
        super(source);
        this.colorPlayer1 = colorPlayer1;
        this.colorPlayer2 = colorPlayer2;
    }

    public GameChangedEvent(Object source, String text, Color colorBoard) {
        super(source);
        this.newText = text;
        this.newColorJLabel = colorBoard;
    }

    public GameChangedEvent(Object source, String player1Name, String player2Name) {
        super(source);
        this.player2Name = player2Name;
        this.player1Name = player1Name;
    }

    public GameChangedEvent(Object source) {
        super(source);
    }

    public Color getNewColor() {
        return newColor;
    }

    public Point getNewPointStart() {
        return newPointStart;
    }

    public Point getNewPointEnd() {
        return newPointEnd;
    }

    public Color getNewColorJLabel() {
        return newColorJLabel;
    }

    public String getNewText() {
        return newText;
    }

    public Color getColorPlayer1() {
        return colorPlayer1;
    }

    public Color getColorPlayer2() {
        return colorPlayer2;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

}
