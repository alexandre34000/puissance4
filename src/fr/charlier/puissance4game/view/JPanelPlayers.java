package fr.charlier.puissance4game.view;

import javax.swing.*;
import java.awt.*;

public class JPanelPlayers extends JPanel {


    JLabel jLabel;
    private Color colorFillOval = null;
    private Color colorBackground = new Color(0, 0, 0, 0);
    private String playerName = "";
    private Color foregroundColor = Color.black;


    public JPanelPlayers(Color colorFillOval) {
        // super(layout, isDoubleBuffered);
        super();
        this.colorFillOval = colorFillOval;
        this.setBackground(this.colorBackground);
        jLabel = new JLabel();
        jLabel.setText(playerName);
        jLabel.setSize(getWidth(), getHeight());
        jLabel.setBackground(colorBackground);
        jLabel.setOpaque(true);
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);
        jLabel.setForeground(foregroundColor);
        jLabel.setFont(new Font("SansSerif", Font.PLAIN, 50));
        add(jLabel);
        setOpaque(false);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.colorFillOval);
        g.fillOval(0, (getHeight() / 2) - 50, getWidth(), getWidth());
    }


    public Color getColorFillOval() {
        return colorFillOval;
    }

    public void setColorFillOval(Color colorFillOval) {
        this.colorFillOval = colorFillOval;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        jLabel.setText(playerName);

      //  System.out.println("JPanelPlayer playername =" + playerName);
    }

}
