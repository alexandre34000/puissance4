package fr.charlier.puissance4game.view;

import javax.swing.*;
import java.awt.*;

public class JPanelPlayers extends JPanel {


    /**
     * Creates a new JPanel with the specified layout manager and buffering
     * strategy.
     *
     * @param layout           the LayoutManager to use
     * @param isDoubleBuffered a boolean, true for double-buffering, which
     *                         uses additional memory space to achieve fast, flicker-free
     */
  /*  public JPanelEstWest(LayoutManager layout, boolean isDoubleBuffered, Color colorButton) {
        super(layout, isDoubleBuffered);
        this.colorButton = colorButton;
    }*/
    private Color colorFillOval = null;
    private Color colorBackground = new Color(0,0,0,0);



    private Color foregroundColor = Color.black;
    private String text = null;
  /*  private int width = 500;
    private int height = 500;*/



    public JPanelPlayers(Color colorFillOval, String text){

        super();
        this.colorFillOval = colorFillOval;
      //  this.setBackground(this.colorBackground);
        JLabel jLabel = new JLabel();
        jLabel.setText(text);
        jLabel.setSize(getWidth(),getHeight());
        jLabel.setBackground(colorBackground);
        jLabel.setOpaque(true);
        jLabel.setText(text);
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);
        jLabel.setForeground(foregroundColor);
        jLabel.setFont(new Font("SansSerif", Font.PLAIN, 50));
        // this.setLayout()
        add(jLabel);
        setOpaque(false);
    }


    public void paintComponent (Graphics g){
        super.paintComponent(g);

        g.setColor(this.colorFillOval);
        g.fillOval(0, (getHeight()/2)-50, getWidth(), getWidth());
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




  /*  public Color getColorButton() {
        return colorButton;
    }

    public void setColorButton(Color colorButton) {
        this.colorButton = colorButton;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
*/
}
