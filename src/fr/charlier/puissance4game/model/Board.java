package fr.charlier.puissance4game.model;


import fr.charlier.puissance4game.controller.Constante;

import java.awt.*;
import java.util.ArrayList;

public class Board {


    private int column = 0;
    private int row = 0;
    private int posYOrigin = 0;
    private int posXOrigin = 0;
    private int posYFinale = 0;
    private int posXFinale = 0;
    private Color colorToken = Color.white;


    private int valueOfToken = 0;
    //static ArrayList<BoardGame> list;

    public Board(){
    }



    public Board(int column, int row, int posXOrigin, int posYOrigin, int  posXFinale, int posYFinale,int valueOfToken, Color colorOfToken){

    this.posXFinale = posXFinale;
    this.posYFinale = posYFinale;
    this.posXOrigin = posXOrigin;
    this.posYOrigin = posYOrigin;
    this.colorToken = colorOfToken;
    this.column =column;
    this.row = row;
    this.valueOfToken = valueOfToken;
}
   @Override
    public String toString (){
        return " BoardGame have in the column : " + column + " in the row : " + row +"for  posXOrigin :" + this.posXOrigin + "and for posYOrigin : " + this.posYOrigin + "and for posXFinale" + this.posXFinale + " and for posYFinale : " + this.posYFinale +
                " and for color : " + this.colorToken + " ValueOfToken = " +this.valueOfToken;
    }











/*
    // return the number of column
    public int findColumnNumber() {
        int posX = (getPoint().x / columnSize);
        return posX;
    }

    // return the number of row
    public int findRowNumber() {
        int posY = getPoint().y / rowSize;
        return posY;
    }

    //return the number of the column and the row
    public Point findPositionToken() {
        Point tokenPosition = new Point();
        tokenPosition.x = newPointEnd.x / Constante.TOKEN_WIDTH;
        tokenPosition.y = (newPointEnd.y / Constante.TOKEN_HEIGHT) - 1;
        return tokenPosition;
    }

    *//*  return coordonnate of position start and set column position*//*
    public Point findStartPosition() {//findStartPosition
        Point columnPosition = new Point();
        int posYStart = 0;
        columnPosition.x = findColumnNumber() * columnSize;
        columnPosition.y = posYStart;
        return columnPosition;
    }

    *//* return coordonnate of position end and set row position*//*
    public Point findEndPosition(int posYFinale) {
        Point rowPosition = new Point();
        rowPosition.x = newPointStart.x;
        rowPosition.y = (posYFinale * rowSize) + rowSize;
        return rowPosition;
    }

    */


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

    public void setColor(Color color) {
        this.colorToken = color;
    }

    public Color getColor() {
        return colorToken;
    }


    public int getValueOfToken() {
        return valueOfToken;
    }

    public void setValueOfToken(int valueOfToken) {
        this.valueOfToken = valueOfToken;
    }



}
