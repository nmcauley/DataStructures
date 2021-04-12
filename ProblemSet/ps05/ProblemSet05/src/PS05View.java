import javax.swing.*;
import java.awt.*;
import javax.swing.JComponent;

public class PS05View extends JComponent {
    public int height;
    public int width;
    public JFrame jFrame;
    private Graphics g;


    public PS05View(int w, int h) {
        height = h;
        width = w;
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(h, w);
        jFrame.setVisible(true);
        g = jFrame.getGraphics();
    }

//    public void paintComponents(Graphics g){
//        super.paintComponents(g);
//        g.setColor(color);
//        g.drawRect(xPixel, yPixel,1, 1);
//    }

    //draws in the view, one point at a time.
    public void drawPoint(int x, int y, int value) {
        if (value <= -255) {
            // 100% red
            g.setColor(Color.red);
            g.drawRect(x, y,1, 1);
        } else if (value > -255 && value < 0) {
            // red at decreasing intensity to black
            g.setColor(new Color(255 - (255 + value) , 0, 0));
            g.drawRect(x, y,1, 1);

        } else if (value == 0) {
            // black (red/green/blue all at 0)
            g.setColor(Color.black);
            g.drawRect(x, y,1, 1);

        } else if (value > 0 && value <= 255) {
            // from black intensity to green
            g.setColor(new Color(0, value, 0));
            g.drawRect(x, y,1, 1);
        } else {
            // full intensity green
            g.setColor(Color.green);
            g.drawRect(x, y,1, 1);
        }
    }


    //clears entire content of view
    public void clear(){
        // sets entire view to black
        g.setColor(Color.black);
        g.drawRect(0, 0,width, height);
    }

}
