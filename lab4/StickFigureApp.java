import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//timer and buttons should have different listeners 
public class StickFigureApp extends JFrame{
    private final int WIDTH = 200;
    private final int HEIGHT = 200;
    private JButton forward;
    private JButton backward;
    private JButton stop;
    private JSlider heightSelect;
    private JColorChooser colorSelect;
     static JCheckBox eyesCheckBox;
     static JCheckBox noseCheckBox;
     static JCheckBox mouthCheckBox;
     static JCheckBox armsCheckBox;
     static JCheckBox legsCheckBox;
     static JCheckBox headCheckBox;
     static JCheckBox bodyCheckBox;
    private static JPanel visibilityPanel; // checkboxes
    private static JPanel movementPanel; //move stop buttons
    private static JPanel selectionPanel; //color and height
    private static StickFigurePanel stickFigure;
    //titles of the panels
    private JLabel moveTitle;
    private JLabel colorTitle;
    private JLabel visibilityTitle;
    private JLabel heightTitle;

    boolean movingRight;
    boolean movingLeft;

    public StickFigureApp(String title){
        this.setTitle(title);
        createComponents();
        
        //timer doesnt work correctly for buttons
        MovementListener move = new MovementListener();
        Timer timer = new Timer(StickFigurePanel.DELAY, move);
        stickFigure.setTimer(timer);
        forward.addActionListener(new MovementListener());
        backward.addActionListener(new MovementListener());
        stop.addActionListener(new MovementListener());
        movingRight = false;
        movingLeft = false;
        
    }
    public void createComponents(){
        //panels
        visibilityPanel = new JPanel();
        movementPanel = new JPanel();
        selectionPanel = new JPanel();
        stickFigure = new StickFigurePanel(WIDTH,HEIGHT,Color.BLACK,200);
        //buttons
        forward = new JButton("Move right");
        backward = new JButton("Move left");
        stop = new JButton("Stop");
        
        
        //checkboxes
        eyesCheckBox = new JCheckBox("Eyes");
        noseCheckBox = new JCheckBox("Nose");
        mouthCheckBox = new JCheckBox("Mouth");
        armsCheckBox = new JCheckBox("Arms");
        legsCheckBox = new JCheckBox("Legs");
        headCheckBox = new JCheckBox("Head");
        bodyCheckBox = new JCheckBox("Body");

        eyesCheckBox.addActionListener(new CheckListener());
        noseCheckBox.addActionListener(new CheckListener());
        mouthCheckBox.addActionListener(new CheckListener());
        armsCheckBox.addActionListener(new CheckListener());
        legsCheckBox.addActionListener(new CheckListener());
        headCheckBox.addActionListener(new CheckListener());
        bodyCheckBox.addActionListener(new CheckListener());
        //Selecters
        heightSelect = new JSlider();
        
        colorSelect = new JColorChooser(Color.BLACK);
        colorSelect.getSelectionModel().addChangeListener(new ColorListener());
        moveTitle = new JLabel("Movement options");
        colorTitle = new JLabel("Color options");
        visibilityTitle = new JLabel("Visibility options");
        heightTitle = new JLabel("Size options / ");
        visibilityPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        movementPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        selectionPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        //adding titles to the panels
        movementPanel.add(moveTitle);
        visibilityPanel.add(visibilityTitle);
        selectionPanel.add(heightTitle);
        selectionPanel.add(colorTitle, BorderLayout.NORTH);
        heightSelect.addChangeListener(new HeightListener());
        //add properties to relevant panels
        movementPanel.add(forward);
        movementPanel.add(backward);
        movementPanel.add(stop);

        
        visibilityPanel.add(eyesCheckBox);
        visibilityPanel.add(noseCheckBox);
        visibilityPanel.add(mouthCheckBox);
        visibilityPanel.add(armsCheckBox);
        visibilityPanel.add(legsCheckBox);
        visibilityPanel.add(headCheckBox);
        visibilityPanel.add(bodyCheckBox);

        selectionPanel.add(heightSelect);
        selectionPanel.add(colorSelect);
    }
    //ChangeListener for HeightSelecter
    class HeightListener implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            int height = heightSelect.getValue();
            stickFigure.setSize(height);
            stickFigure.repaint();
        }
        
    }
    //ActionListener for movement buttons ?  stop is working+
    class MovementListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int direction = 0;
            if(movingRight){
                direction = 5;
            }
            if(movingLeft){
                direction = -5;
            }
            if(movingRight || movingLeft){
                stickFigure.getTimer().start();
                stickFigure.moveFigure(direction); 
                stickFigure.repaint();
            }
            
            if(e.getSource() == forward){
                movingRight = true;
                movingLeft = false;
            }
            if(e.getSource() == backward){
                movingLeft = true;
                movingRight = false;
            }
            if(e.getSource() == stop){
                stickFigure.getTimer().stop();
            }
            
        }
    }
    //ChangeListener for ColorSelector
    class ColorListener implements ChangeListener{


        @Override
        public void stateChanged(ChangeEvent e) {
            Color selected = colorSelect.getColor();
            stickFigure.setColor(selected);
            stickFigure.repaint();
        }
            
    }
    //ActionListener for Checkboxes
    class CheckListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            stickFigure.isVisible(new JCheckBox());
            
        }
        
    }
        
    public static void main(String[] args) {
        StickFigureApp myStickFigure = new StickFigureApp("Stick Figure");
        myStickFigure.setLayout(new BorderLayout());
        myStickFigure.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myStickFigure.getContentPane().add(visibilityPanel,BorderLayout.WEST);
        myStickFigure.getContentPane().add(movementPanel,BorderLayout.EAST);
        myStickFigure.getContentPane().add(selectionPanel,BorderLayout.SOUTH);
        myStickFigure.getContentPane().add(stickFigure,BorderLayout.CENTER);
        myStickFigure.pack();
        myStickFigure.setVisible(true);
    }
}

