import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class StickFigurePanel extends JPanel{
    static final int WIDTH = 500;
    static final int HEIGHT = 500;
    // bottom center coordinates
    private int baseX;
    private int baseY;
    private Timer timer;
    private Color color;
    private int size; //height of the body
    int armsLength; // 
    //int legsLength; //y direction only
    int headWidth;
    /*int neckLength;
    int eyesWidth;
    int noseWidth;
    int mouthWidth;*/
    final static int DELAY = 20;

    /*public class MyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            moveFigure(0); //negative for left positive for rigth
            repaint();
        }
    
    }*/
    public StickFigurePanel(int x, int y, Color color, int size){
        setX(x);
        setY(y);
        this.size = size;
        this.color = color;
        /*armsLength = size/2;
        legsLength = size/2;*/
        headWidth = size/2;
        /*neckLength = size/6;
        eyesWidth= headWidth/8;
        noseWidth= headWidth/6;
        mouthWidth= headWidth/5;*/
        /*timer = new Timer(DELAY, new MyListener());
        timer.start(); */
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }
    public void setX(int x){
        this.baseX = x;
    }
    public void setY(int y){
        this.baseY = y;
    }
    public void setSize(int size){
        this.headWidth = size;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setTimer(Timer timer){
        this.timer = timer;
        //timer.start();
    }
    public Timer getTimer(){
        return timer;
    }
    public boolean isVisible(JCheckBox checkbox){
        boolean visible = true;
        if(checkbox.isSelected()){
            visible = false;
        }
        return visible;
    }
    //moves the figure to left or rigth direction left => dx<0
    public void moveFigure(int dx){
        baseX = baseX + dx;
        //have it reappear on the left/rigth side again until the animation is stopped by a button
        if(dx>0 && (baseX<=0 || baseX >= WIDTH-armsLength) ){
            baseX = 0; // right direction
        }
        if(dx<0 && (baseX<=0 || baseX >= WIDTH-armsLength)){
            baseX = WIDTH-armsLength; // left direction
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g); 
        g.setColor(color);
        int topOfTheHead = baseY-size;

        //head
        if(isVisible(StickFigureApp.headCheckBox)){
        g.drawOval(baseX-headWidth/2,topOfTheHead,headWidth,headWidth);
        }
        //eyes
        if(isVisible(StickFigureApp.eyesCheckBox)){
        g.drawOval(baseX-headWidth/4,topOfTheHead+headWidth/4,headWidth/8,headWidth/8);
        g.drawOval(baseX+headWidth/4,topOfTheHead+headWidth/4,headWidth/8,headWidth/8);
        }
        //nose
        if(isVisible(StickFigureApp.noseCheckBox)){
        g.drawLine(baseX-headWidth/10,topOfTheHead+headWidth/2,baseX+headWidth/10,topOfTheHead+headWidth/2);
        g.drawLine(baseX-headWidth/10,topOfTheHead+headWidth/2,baseX+headWidth/25,topOfTheHead+2*headWidth/3);
        g.drawLine(baseX+headWidth/25,topOfTheHead+2*headWidth/3,baseX+headWidth/10,topOfTheHead+headWidth/2);
        }
        //mouth
        if(isVisible(StickFigureApp.mouthCheckBox)){
        g.drawLine(baseX-headWidth/8,topOfTheHead+3*headWidth/4,baseX+headWidth/8,topOfTheHead+3*headWidth/4);
        }
        //body
        if(isVisible(StickFigureApp.bodyCheckBox)){
        g.drawLine(baseX,topOfTheHead+headWidth,baseX,topOfTheHead+headWidth*5/2);
        }
        //arms
        if(isVisible(StickFigureApp.armsCheckBox)){
        g.drawLine(baseX-2*headWidth,topOfTheHead+4*headWidth/3,baseX+2*headWidth,topOfTheHead+4*headWidth/3);
        }
        //legs
        if(isVisible(StickFigureApp.legsCheckBox)){
        g.drawLine(baseX,topOfTheHead+headWidth*5/2,baseX+2*headWidth,topOfTheHead+headWidth*4);
        g.drawLine(baseX,topOfTheHead+headWidth*5/2,baseX-2*headWidth,topOfTheHead+headWidth*4);
        }
        repaint(); 
    }
   

}