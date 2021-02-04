package fr.charlier.puissance4game.view;


import fr.charlier.puissance4game.controller.Constante;

import javax.swing.*;
import java.awt.*;

public class JPanelAnimate extends JPanel {

    private int posX = 0;
    private int posY = 0;


    Point points = new Point(posX, posY);


    private Color color = new Color(0,0,0,0);



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


    public void goAnimatePanel(Point points) {

        setPosX((int) points.getX());

        setPosY((int) points.getY());

        System.out.println("dans animate panel1" + posX + "  :" + posY);

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

/*

startButton.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    progressBar.setValue(0);
    progressBar.setStringPainted(true);

    // Runs outside of the Swing UI thread
    new Thread(new Runnable() {
      public void run() {
        for (i = 0; i <= 100; i++) {

          // Runs inside of the Swing UI thread
          SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              progressBar.setValue(i);
            }
          });

          try {
            java.lang.Thread.sleep(100);
          }
          catch(Exception e) { }
        }
      }
    }).start();
  }
});











    public AnimateJPanel1() {
        super();


    }
*/

/*
public JPanel createJPanel(){
      JPanel jp =new JPanel();
    jp.setBounds(50,50,400,400);
    jp.setBackground(new Color(0, 0, 0, 200));
    jp.setOpaque(true);
     return jp;

}*/
/*public void initialise(){

    setBounds(50,50,400,400);
    setBackground(new Color(0, 0, 0, 200));
    setOpaque(true);
}*/


//  setBounds(100,100,400,400);
//   setBackground(new Color(50, 50, 50, 10));
// setOpaque(false);
// initialise();


// goAnimatePanel();
//createJPanel();
//   super();


       /* try {

            URL url =getClass().getResource("RegateF.png");
            if (url == null){
                System.out.println("Could find image!");
            }
            else{
                System.out.println("image chargée");
            }
            image= ImageIO.read(url);

        } catch (Exception ex) {
            ex.printStackTrace();
        }*/