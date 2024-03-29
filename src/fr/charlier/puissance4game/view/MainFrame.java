package fr.charlier.puissance4game.view;

import fr.charlier.puissance4game.controller.GameController;
import fr.charlier.puissance4game.controller.GameView;
import fr.charlier.puissance4game.controller.Constante;
import fr.charlier.puissance4game.games.GameChangedEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends GameView implements ActionListener, ComponentListener {


    JFrame jFrame = null;
    JPanel mainPanel = null;
    JLayeredPane jLayeredPane = null;
    JPanelImage imagePanelBackground = new JPanelImage("salon.png");
    JPanelPlayers jPanelLeft = new JPanelPlayers(Constante.TOKEN_COLOR_PLAYER1, "PLAYER 1");
    JPanelPlayers jPanelRight = new JPanelPlayers(Constante.TOKEN_COLOR_PLAYER2, "PLAYER 2");
    JPanelWinner jPanelWinner = new JPanelWinner();
    JPanelImage imagePanelFont = new JPanelImage("puissance41.png");
    JPanelAnimate ajp = new JPanelAnimate();
    JButton buttonStart = null;
    JButton buttonClose = null;

    Boolean start = true;
    Dimension size = null;


    public MainFrame(GameController controller) {
        super(controller);
        createAndShowGUI();
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public void createAndShowGUI() {

        //Create and set up the window.

        jFrame = new JFrame();
        jFrame.setTitle("puissance 4");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(Constante.WINDOWS_WIDTH, Constante.WINDOWS_HEIGHT);
        jFrame.setExtendedState(jFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        jFrame.setResizable(true);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.addComponentListener(this);

        jLayeredPane = new JLayeredPane();
        jLayeredPane.setBackground(Color.blue);

        imagePanelBackground.setBounds(0, 0, 800, 700);
        jPanelLeft.setBounds(50, 300, Constante.JPANEL_ESTWEST_WIDTH, Constante.JPANEL_ESTWEST_HEIGHT);
        jPanelRight.setBounds(1700, 300, Constante.JPANEL_ESTWEST_WIDTH, Constante.JPANEL_ESTWEST_HEIGHT);

        ajp.setBounds(400, 100, Constante.JPANEL_ANIMATE_WIDTH, Constante.JPANEL_ANIMATE_HEIGHT);
        ajp.setOpaque(false);

        jPanelWinner.setBounds(400, 400, Constante.JPANEL_WINNER_WIDTH, Constante.JPANEL_WINNER_HEIGHT);
        jPanelWinner.setOpaque(true);
        jPanelWinner.setVisible(false);

        imagePanelFont.setBounds(400, 200, Constante.JPANEL_FONT_WIDTH, Constante.JPANEL_FONT_HEIGHT);
        imagePanelFont.setOpaque(false);
        //  imagePanelFont.addMouseListener(new MyMouseAdapter() );
        buttonStart = new JButton("start");
        buttonStart.setBounds(50, 900, 100, 50);
        buttonStart.addActionListener(this);

        buttonClose = new JButton("close");
        buttonClose.setBounds(1750, 900, 100, 50);
        buttonClose.addActionListener(this);

        jLayeredPane.add(imagePanelBackground, new Integer(0), 0);
        jLayeredPane.add(jPanelLeft, new Integer(1), 1);
        jLayeredPane.add(jPanelRight, new Integer(1), 1);
        jLayeredPane.add(ajp, new Integer(3), 3);
        jLayeredPane.add(imagePanelFont, new Integer(4), 4);
        jLayeredPane.add(jPanelWinner, new Integer(5), 5);
        jLayeredPane.add(buttonStart, new Integer(1), 1);
        jLayeredPane.add(buttonClose, new Integer(1), 1);

        mainPanel.add(jLayeredPane);
        jFrame.setContentPane(mainPanel);
    }


    @Override
    public void displayWinner() {
        jPanelWinner.setVisible(true);
    }

    @Override
    public void mouseListenerActivated() {

        imagePanelFont.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                //  super.mouseReleased(evt);
                imagePanelFont.removeMouseListener(this);
                getController().notifyPointChanged(evt.getPoint());

                System.out.println("MAINFRAME  is mousse listener super ca marche2 + mousse =" + " dans le thread EDT = " + SwingUtilities.isEventDispatchThread());
            }
        });
    }

    @Override
    public void display() {
        jFrame.setVisible(true);
    }

    @Override
    public void close() {
        System.exit(0);
    }

    @Override
    public void colorChanged(GameChangedEvent event) {
        ajp.setColor(event.getNewColor());
    }

    @Override
    public void pointChanged(GameChangedEvent event) {
        int speed = 10;

        for (int i = 0; i < event.getNewPointEnd().y / speed; i++) {
            event.getNewPointStart().y = i * speed;
            ajp.setPosX(event.getNewPointStart().x);
            ajp.setPosY(event.getNewPointStart().y);
            ajp.paintImmediately(event.getNewPointStart().x, 0, Constante.TOKEN_WIDTH, event.getNewPointEnd().y + Constante.TOKEN_HEIGHT);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        getController().notifyAnimateTerminated();
    }

    @Override
    public void playerChanged(GameChangedEvent event) {
        jPanelLeft.setColorFillOval(event.getColorPlayer1());
        jPanelLeft.repaint();
        jPanelRight.setColorFillOval(event.getColorPlayer2());
        jPanelRight.repaint();
    }

    @Override
    public void winnerFounded(GameChangedEvent event) {
        jPanelWinner.setText(event.getNewText() + " est le gagnant");
        jPanelWinner.setBackground(event.getNewColorJLabel());
        //  jPanelWinner.setVisible(true);
    }

    @Override
    public void restartInvoked(GameChangedEvent event) {
        jPanelWinner.setVisible(false);
        ajp.repaint();
    }


   /* Click on button start*/
    @Override
    public void actionPerformed(ActionEvent e) {
        mouseListenerActivated();
        if (e.getSource() == buttonStart) {
            if (start) {
                getController().notifyGameStart();
                buttonStart.setText("reStart");
                start = false;
            } else {
                getController().notifyGameRestart();
            }
        } else if (e.getSource() == buttonClose) {
            getController().closeView();
        }
    }

    /**
     * Invoked when the component's size changes.
     *
     * @param e
     */
    @Override
    public void componentResized(ComponentEvent e) {

        size = mainPanel.getSize();
        size.setSize(mainPanel.getHeight() * 2.03, mainPanel.getHeight());
        imagePanelBackground.setSize(size);
        jPanelLeft.setSize(mainPanel.getWidth() / 8, mainPanel.getHeight() / 2);
        jPanelRight.setSize(mainPanel.getWidth() / 8, mainPanel.getHeight() / 2);
        jPanelRight.setLocation((mainPanel.getWidth() / 8 * 7) - 50, 300);
        imagePanelFont.setLocation((mainPanel.getWidth() / 2) - (imagePanelFont.getWidth() / 2), (mainPanel.getHeight() / 2) - (imagePanelFont.getHeight() / 2));
        ajp.setLocation(imagePanelFont.getX(), imagePanelFont.getY() - 100);
        jPanelWinner.setLocation(imagePanelFont.getX(), (imagePanelFont.getHeight() / 2) + Constante.JPANEL_WINNER_HEIGHT);
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    /*@Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mousserelease");
        if(mousse) {
        if (e.getSource() == imagePanelFont) {
         //   points.x = e.getX();
         //   points.y = e.getY();
         //   getController().notifyPointChanged(points);
        //mouseListenerActivated(false);
                System.out.println("getController.notifyPointChanged");

                System.out.println(e.getClickCount());
                getController().notifyPointChanged(e.getPoint());
        //    imagePanelFont.removeMouseListener(this);
            }
        }
    }*/

    /**
     * Invoked when the component's position changes.
     *
     * @param e
     */
    @Override
    public void componentMoved(ComponentEvent e) {

    }

    /**
     * Invoked when the component has been made visible.
     *
     * @param e
     */
    @Override
    public void componentShown(ComponentEvent e) {

    }

    /**
     * Invoked when the component has been made invisible.
     *
     * @param e
     */
    @Override
    public void componentHidden(ComponentEvent e) {

    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
 /*   @Override
    public void mouseClicked(MouseEvent e) {


    }*/

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
    /*    *//*
    @Override
    public void mousePressed(MouseEvent e) {
      *//*  if (e.getSource() == jPanelLeft) {
            getController().notifyPlayerChanged("player1");
        } else if (e.getSource() == jPanelRight) {
            getController().notifyPlayerChanged("player2");
        }*//*
    }


    *//**
     * Invoked when the mouse enters a component.
     *
     * @param e
     *//*
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    *//**
     * Invoked when the mouse exits a component.
     *
     * @param e
     *//*
    @Override
    public void mouseExited(MouseEvent e) {

    }*/

    /*

    class MyMouseAdapter extends MouseAdapter{
        public Boolean getM(){
            return mousse;
        }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseClicked(e);

                System.out.println("super ca marche mousse=" +mousse);
                //  imagePanelFont.removeMouseListener(this);
                if (mousse) {
                    setMousse(false);
                    getController().notifyPointChanged(e.getPoint());

                }
                System.out.println("super ca marche2 + mousse ="+mousse);
            }

    }
*/

//mouseListenerIsActive = true;
       /* MouseListener ml =new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                getController().notifyPointChanged(e.getPoint());
            }
        };
        if(isActive){
            imagePanelFont.addMouseListener(ml);
              }
        else{ imagePanelFont.removeMouseListener(ml);
        }*/

}
