package fr.charlier.puissance4game.view;


import fr.charlier.puissance4game.controller.Constante;

import javax.swing.*;
import java.awt.*;

public class JPanelAnimate extends JPanel {

    private int posX = 0;
    private int posY = 0;
    Point points = new Point(posX, posY);
    private Color color = new Color(0, 0, 0, 0);


    public JPanelAnimate() {
        super();
    /*   setDoubleBuffered(true);
       isOptimizedDrawingEnabled();*/
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(getColor());
        g.fillOval(getPosX(), getPosY(), Constante.TOKEN_WIDTH, Constante.TOKEN_HEIGHT);

    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPoints() {
        return points;
    }

    public void setPoints(Point p) {
        this.points = p;
    }


}
