package fr.charlier.puissance4game.view;

import fr.charlier.puissance4game.controller.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/*
 *
 * Welcome View for choose the players
 *
 * */

public class WelcomeView extends JLayeredPane implements ActionListener {

    JPanelImage backgroundImageFirstPanel = new JPanelImage("salon.png");
    JPanel mainPanel = null;
    JRadioButton player2 = null;
    JRadioButton ia = null;
    String player1Name = "Player 1";
    String player2Name = "Player 2";
    GameController controller;


    public WelcomeView(GameController controller) {
        super();
        this.controller = controller;
        createAndShowUI();
    }

    public void createAndShowUI() {

        mainPanel = new JPanel();

        GridBagConstraints c = new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();
        mainPanel.setLayout(gbl);
        mainPanel.setBackground(Color.pink);

        JLabel titleLabel = new JLabel();
        titleLabel.setText("PLAYER");
        titleLabel.setFont(new Font("Courrier", Font.BOLD, 70));
        titleLabel.setBackground(Color.blue);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel secondLabel = new JLabel();
        secondLabel.setText(" VS");
        secondLabel.setFont(new Font("Courrier", Font.ITALIC, 70));
        secondLabel.setHorizontalAlignment(SwingConstants.CENTER);

        player2 = new JRadioButton("PLAYER 2");
        player2.setMnemonic(KeyEvent.VK_B);
        player2.setActionCommand("player2");
        player2.setSelected(true);
        player2.setFont(new Font("Courrier", Font.ITALIC, 30));
        player2.setBackground(Color.yellow);
        player2.setHorizontalAlignment(SwingConstants.CENTER);

        ia = new JRadioButton("IA");
        ia.setMnemonic(KeyEvent.VK_C);
        ia.setActionCommand("IA");
        ia.setFont(new Font("Courrier", Font.ITALIC, 30));
        ia.setHorizontalAlignment(SwingConstants.CENTER);

        JButton buttonChoice = new JButton("Valider");
        buttonChoice.setActionCommand("Valider");
        buttonChoice.setBounds(50, 600, 200, 100);
        buttonChoice.setFont(new Font("Courrier", Font.BOLD, 30));
        buttonChoice.setBorder(BorderFactory.createBevelBorder(0));

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        gbl.setConstraints(titleLabel, c);
        mainPanel.add(titleLabel);


        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        gbl.setConstraints(secondLabel, c);
        mainPanel.add(secondLabel);


        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.3;
        c.weighty = 0.7;
        c.fill = GridBagConstraints.HORIZONTAL;
        gbl.setConstraints(player2, c);
        mainPanel.add(player2);


        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.5;
        c.weighty = 0.7;
        c.fill = GridBagConstraints.HORIZONTAL;
        gbl.setConstraints(ia, c);
        mainPanel.add(ia);

        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.3;
        c.weighty = 0.3;
        c.insets = (new Insets(10, 10, 10, 50));
        c.fill = GridBagConstraints.BOTH;
        gbl.setConstraints(buttonChoice, c);
        mainPanel.add(buttonChoice);

        //Register a Listener for the radio button and button
        buttonChoice.addActionListener(this);
        player2.addActionListener(this);
        ia.addActionListener(this);

        backgroundImageFirstPanel.setBounds(0, 0, getWidth(), getHeight());
        mainPanel.setBounds(400, 200, 800, 700);
        add(backgroundImageFirstPanel, new Integer(0), 0);
        add(mainPanel, new Integer(1), 1);
    }

    /**
     * resize the panel from windows component
     */
    public void toBeResized(Dimension size) {

        backgroundImageFirstPanel.setBounds(0, 0, getWidth(), getHeight());
        mainPanel.setLocation((getWidth() / 2 - mainPanel.getWidth() / 2), (getHeight() / 2 - mainPanel.getHeight() / 2));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case ("IA"): {
                setPlayer2Name("IA");
                player2.setSelected(false);
            }
            break;

            case ("player2"): {
                setPlayer2Name("Player 2");
                ia.setSelected(false);
            }
            break;

            case ("Valider"): {
                controller.notifyPlayersSelected(getPlayer1Name(), getPlayer2Name());
            }
            break;

            default:
                System.out.println("radio non valide");
                break;
        }


    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

}
