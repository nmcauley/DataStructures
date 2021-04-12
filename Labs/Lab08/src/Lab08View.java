import javax.swing.*;
import java.awt.*;
import javax.swing.JComponent;
import java.awt.event.*;

public class Lab08View extends JComponent implements ActionListener{
    public int height;
    public int width;
    public JFrame jFrame;
//    private Graphics g;


    public Lab08View(int w, int h) {
        height = h;
        width = w;
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(w, h);
        jFrame.setVisible(true);
        jFrame.add(this);
    }

    //draws in the view, one point at a time.
    public void drawPoint(int x, int value) {
        jFrame.getGraphics().setColor(Color.CYAN);
        jFrame.getGraphics().drawLine(x, height - value, x, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        // clear background at every re-painting:
        Shape lClipArea = g.getClip();
        int lWidth = lClipArea.getBounds().width;
        int lHeight = lClipArea.getBounds().height;
        g.fillRect(0,0,lWidth,lHeight);
    }


    //clears entire content of view
    public void clear(){
        jFrame.getGraphics().setColor(Color.RED);
        jFrame.getGraphics().clearRect(0, 0, width, height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.clear();
        this.repaint();
    }
}
