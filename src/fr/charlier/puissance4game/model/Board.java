package fr.charlier.puissance4game.model;

import java.awt.*;

public class Board {

    private int column = 0;
    private int row = 0;
    private int posYOrigin = 0;
    private int posXOrigin = 0;
    private int posYFinale = 0;
    private int posXFinale = 0;
    private Color colorToken = Color.white;
    private int valueOfToken = 0;

    public Board() {
    }


    public Board(int column, int row, int posXOrigin, int posYOrigin, int posXFinale, int posYFinale, int valueOfToken, Color colorOfToken) {

        this.posXFinale = posXFinale;
        this.posYFinale = posYFinale;
        this.posXOrigin = posXOrigin;
        this.posYOrigin = posYOrigin;
        this.colorToken = colorOfToken;
        this.column = column;
        this.row = row;
        this.valueOfToken = valueOfToken;
    }

    @Override
    public String toString() {
        return " BoardGame have in the column : " + column + " in the row : " + row + "for  posXOrigin :" + this.posXOrigin + "and for posYOrigin : " + this.posYOrigin + "and for posXFinale" + this.posXFinale + " and for posYFinale : " + this.posYFinale +
                " and for color : " + this.colorToken + " ValueOfToken = " + this.valueOfToken;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPosYOrigin() {
        return posYOrigin;
    }

    public void setPosYOrigin(int posYOrigin) {
        this.posYOrigin = posYOrigin;
    }

    public int getPosXOrigin() {
        return posXOrigin;
    }

    public void setPosXOrigin(int posXOrigin) {
        this.posXOrigin = posXOrigin;
    }

    public int getPosYFinale() {
        return posYFinale;
    }

    public void setPosYFinale(int posYFinale) {
        this.posYFinale = posYFinale;
    }

    public int getPosXFinale() {
        return posXFinale;
    }

    public void setPosXFinale(int posXFinale) {
        this.posXFinale = posXFinale;
    }

    public Color getColor() {
        return colorToken;
    }

    public void setColor(Color color) {
        this.colorToken = color;
    }

    public int getValueOfToken() {
        return valueOfToken;
    }

    public void setValueOfToken(int valueOfToken) {
        this.valueOfToken = valueOfToken;
    }


}
