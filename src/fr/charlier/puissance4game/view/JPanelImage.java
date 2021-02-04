package fr.charlier.puissance4game.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JPanelImage extends JPanel {


    String urlText = "";
    int sizeX = 0;
    int sizeY = 0;
    private BufferedImage image = null;


    public JPanelImage(){
        super();


    }

    public JPanelImage(String text){
        super();
        this.urlText = text;
        try {
            URL url = getClass().getResource(urlText);
            if (url == null) {
                System.out.println("Could find image!");
            } else {
            //    System.out.println("image chargée");
            }
            image = ImageIO.read(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawImage(image,0,0,getWidth(),getHeight(),null);

    }
}


/*

    public ImagePanel(String urlText, int sizeX, int sizeY) {
        super();
        this.urlText = urlText;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
     //   image = requestImage();
    }


    private BufferedImage requestImage () {

        try {
            URL url = getClass().getResource(urlText);
            if (url == null) {
                System.out.println("Could find image!");
            } else {
                System.out.println("image chargée");
            }
            image = ImageIO.read(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return image;

    }
  */
/*   @Override
    public Dimension getPreferredSize() {
        return new Dimension(500,500);
      //  return image == null ? new Dimension(600,600): new Dimension(1000,1000);
    }*/


/*

   /*     buildImagePanel(urlText, sizeX, sizeY);
    }*/


    //  public void buildImagePanel(String urlText, int sizeX, int sizeY){

    //        pan.setOpaque(false);
    // setBackground(Color.red) {



/*
            try {

            URL url = getClass().getResource(urlText);
            if (url == null) {
                System.out.println("Could find image!");
            } else {
                System.out.println("image chargée");
            }
            image = ImageIO.read(url);

        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

//getSize()
/*

        JPanel draw =new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, 800, 700, null);
            }

        };
     draw.setPreferredSize(new Dimension(sizeX,sizeY));

      this.add(draw);

*/

/*System.out.println(this.

        public Image getImage() {
        Image image = null;

        URL url = getClass().getResource(urlText);
        if (url == null) {
            System.out.println("Could find image!");
        } else {
            System.out.println("image chargée");
        }
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    })


    //    return pan;

}*/





 /*  @Override
    public Dimension getPreferredSize() {
        return new Dimension(500,500);
      //  return image == null ? new Dimension(600,600): new Dimension(image.getWidth(), image.getHeight());
    }*/