package fr.charlier.puissance4game.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LayeredPaneCenter extends JPanel implements ActionListener, MouseMotionListener {



    JPanelAnimate animateJPanel = new JPanelAnimate();

    //  ImagePanel imageFont = new ImagePanel("puissance41.png");

    private JLayeredPane layeredPane;

   /* private JCheckBox onTop;
    private JComboBox layerList;*/
    private int windowsWidth = 0;
    private int windowsHeight = 0;

    public LayeredPaneCenter() {
        //   setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        addComponentListener(new ComponentAdapter() {
            /**
             * Invoked when the component's size changes.
             *
             * @param e
             */
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Component c = (Component) e.getSource();
                System.out.println("compenentHeight" + c.getHeight());
                System.out.println("componentWidth" + c.getWidth());

            }
        });

        setOpaque(false);

        //Create and set up the layered pane.
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1000, 1000));

        layeredPane.addMouseMotionListener(this);

        //This is the origin of the first label added.
        Point origin = new Point(10, 20);
        Point origin1 = new Point(50, 50);

        //This is the offset for computing the origin for the next label.
        int offset = 35;

  /*      // construction du ButtonBar
        ButtonBar buttonsBar = new ButtonBar();
        Component c = buttonsBar.buildBuutonPanel();
        c.setBounds(100, 20, 800, 50);
        layeredPane.add(c);*/


     /*   animateJPanel = new AnimateJPanel1();

        animateJPanel.setBounds(100, 100, 800,700 );
        animateJPanel.setBackground(Color.green);
        layeredPane.add(animateJPanel, new Integer(0), 0);
*/
        // Construction de imageFont
     /*   ImagePanel imageFont = new ImagePanel("puissance41.png");
        Component c1 = imageFont.buildImagePanel("puissance41.png");
        c1.setBounds(100, 100, 800, 700);*/
       // ((JPanel) c1).setOpaque(false);
        // c1.setBackground(Color.yellow);
     //   layeredPane.add(c1, new Integer(1), 1);
        add(layeredPane);



    }




    public void mouseMoved(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
    } //do nothing

    //Handle user interaction with the check box and combo box.
    public void actionPerformed(ActionEvent e) {

    }


    public void animate() {
     /*   //  animateJPanel.goAnimatePanel();
        new Thread(new Runnable() {
            public void run() {
                // ajp.paintComponent();
                animateJPanel.goAnimatePanel();
            }
        }).start();*/
    }
}



//   animate();
//   setBackground(Color.cyan);

//Adjustments to put Duke's toe at the cursor's tip.
/*    private static final int XFUDGE = 40;
    private static final int YFUDGE = 57;
    //Action commands
    private static String ON_TOP_COMMAND = "ontop";
    private static String LAYER_COMMAND = "layer";*/



    /* imagePanel.setBounds(0, 0, 800, 800);
        layeredPane.add(imagePanel, new Integer(0), 0);*/

     /*  layeredPane.setBorder(BorderFactory.createTitledBorder(
                "Move the Mouse to Move Duke"));*/

          /*      setWindowsHeight(c.getHeight());
                System.out.println("get" + getWindowsHeight());*/


// ImagePanel imagePanel = new ImagePanel("salon.png");

 /* private String[] layerStrings = {"Yellow (0)", "Magenta (1)",
            "Cyan (2)", "Red (3)",
            "Green (4)"};
    private Color[] layerColors = {Color.yellow, Color.magenta,
            Color.cyan, Color.red,
            Color.green};*/

//Create the control pane for the top of the frame.
/*    private JPanel createControlPanel() {
        onTop = new JCheckBox("Top Position in Layer");
        onTop.setSelected(true);
        onTop.setActionCommand(ON_TOP_COMMAND);
        onTop.addActionListener(this);

        layerList = new JComboBox(layerStrings);
        layerList.setSelectedIndex(2);    //cyan layer
        layerList.setActionCommand(LAYER_COMMAND);
        layerList.addActionListener(this);

        JPanel controls = new JPanel();
        controls.add(layerList);
        controls.add(onTop);
        controls.setBorder(BorderFactory.createTitledBorder(
                "Choose Duke's Layer and Position"));
        return controls;
    }*/

//Make Duke follow the cursor.


//   System.out.println(this.getWindowsHeight());
// System.out.println(this.windowsWidth);
//   dukeLabel.setLocation(e.getX()-XFUDGE, e.getY()-YFUDGE);


    /*  String cmd = e.getActionCommand();

        if (ON_TOP_COMMAND.equals(cmd)) {
            if (onTop.isSelected())
                layeredPane.moveToFront(dukeLabel);
            else
                layeredPane.moveToBack(dukeLabel);

        } else if (LAYER_COMMAND.equals(cmd)) {
            int position = onTop.isSelected() ? 0 : 1;
            layeredPane.setLayer(dukeLabel,
                    layerList.getSelectedIndex(),
                    position);
        }*/

//make a windows size




/*  *//**
 * Create the GUI and show it.  For thread safety,
 * this method should be invoked from the
 * event-dispatching thread.
 * <p>
 * Returns an ImageIcon, or null if the path was invalid.
 * <p>
 * Invoked when the component's size changes.
 *
 * @param e
 * <p>
 * Invoked when the component's size changes.
 * @param e
 * <p>
 * Returns an ImageIcon, or null if the path was invalid.
 * <p>
 * Invoked when the component's size changes.
 * @param e
 * <p>
 * Invoked when the component's size changes.
 * @param e
 * <p>
 * Returns an ImageIcon, or null if the path was invalid.
 * <p>
 * Invoked when the component's size changes.
 * @param e
 * <p>
 * Invoked when the component's size changes.
 * @param e
 *//*
    public void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("LayeredPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        //Create and set up the content pane.
        JComponent newContentPane = new LayeredPaneDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        System.out.println("JFRAME height ant width" + frame.getHeight() + frame.getWidth());


    }*/

//Create and add the Duke label to the layered pane.
      /*  dukeLabel = new JLabel(icon);
        if (icon != null) {
            dukeLabel.setBounds(15, 225,
                    icon.getIconWidth(),
                    icon.getIconHeight());
        } else {
            System.err.println("Duke icon not found; using black square instead.");
            dukeLabel.setBounds(15, 225, 30, 30);
            dukeLabel.setOpaque(true);
            dukeLabel.setBackground(Color.BLACK);
        }*/
//  layeredPane.add(dukeLabel, new Integer(2), 0);

//Add control pane and layered pane to this JPanel.
//  add(Box.createRigidArea(new Dimension(0, 10)));
//   add(createControlPanel());
//  add(Box.createRigidArea(new Dimension(0, 10)));


// private JLabel dukeLabel;

//Create and load the duke icon.
// final ImageIcon icon = createImageIcon("salon.png");
//  final ImageIcon icon= createImageIcon("RegateF.png");


//Add several overlapping, colored labels to the layered pane
//using absolute positioning/sizing.
        /*for (int i = 0; i < layerStrings.length; i++) {
            JLabel label = createColoredLabel(layerStrings[i],
                    layerColors[i], origin);
            layeredPane.add(label, new Integer(i));
            origin.x += offset;
            origin.y += offset;
        }*/
     /*   JLabelTest1 j1 = new JLabelTest1("titi",Color.cyan, origin);
        Component c = j1.createJLabel();*/


/**
 * Returns an ImageIcon, or null if the path was invalid.
 * <p>
 * Invoked when the component's size changes.
 *
 * @param e
 */
  /*  protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = LayeredPaneDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }*/

//Create and set up a colored label.
  /*  private JLabel createColoredLabel(String text,
                                      Color color,
                                      Point origin) {
        JLabel label = new JLabel(text);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(color);
        label.setForeground(Color.black);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setBounds(origin.x, origin.y, 140, 140);
        return label;
    }*/



/* frame.addComponentListener(new ComponentAdapter() {
 *//**
 * Invoked when the component's size changes.
 *
 * @param e
 *//*
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Component c =(Component)e.getSource();
                System.out.println(c.getHeight());

                setWindowsHeight(c.getHeight());
                System.out.println("get"+getWindowsHeight());
            }
        });*/
// setWindowsHeight(frame.getHeight());
      /* // this.windowsHeight = frame.getHeight();
        this.windowsWidth = frame.getWidth();

        System.out.println( frame.getSize().getHeight()+ "   "+ this.getWindowsHeight());
        System.out.println(frame.getSize().getWidth());*/


/*
JFrame myFrame = ...

        JComponent glassPane = new JPanel(null);
        myFrame.setGlassPane(glassPane);

private void jLabelSettingsMouseClicked(java.awt.event.MouseEvent evt) {
        settingsActive = !this.jLabelEmargement.isVisible();
        if(!settingsActive){
        FSettings.setSize(222, 380);
        FSettings.setLocation(0, 150);
        FSettings.setBackground(new Color(226,236,241));
        glassPane.add(FSettings);
        this.frameLearners.setVisible(false);
        this.jLabelEmargement.setVisible(false);
        this.jLabelFinalEval.setVisible(false);
        this.jLabelLeaners.setVisible(false);
        }
        else{
        glassPane.remove(FSettings);
        this.frameLearners.setVisible(true);
        this.jLabelEmargement.setVisible(true);
        this.jLabelFinalEval.setVisible(true);
        this.jLabelLeaners.setVisible(true);
        }
        }*/
