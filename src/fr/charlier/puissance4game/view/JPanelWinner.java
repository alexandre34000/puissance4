package fr.charlier.puissance4game.view;

import javax.swing.*;
import java.awt.*;

public class JPanelWinner extends JLabel {


    public JPanelWinner() {
        super();
        this.setBackground(Color.white);
        this.setText(" Vous etes est le gagnant");
        this.setForeground(Color.black);
        this.setFont(new Font("SansSerif", Font.PLAIN, 50));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
    }
}
