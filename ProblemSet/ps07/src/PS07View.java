import javax.swing.*;
import java.awt.*;

public class PS07View extends JComponent{
    int width, height;
    public JFrame jFrame;
    private Graphics graphics;

    public PS07View(int w, int h){
        height = h;
        width = w;
        jFrame = new JFrame();
        jFrame.setSize(w, h);
        jFrame.setVisible(true);
        graphics = jFrame.getGraphics();
    }


    //draws in the view, one point at a time.
    public void drawPoint(int x, int y, int r, int g, int b) {
        if(r < 0){ r = 0;}
        else if(r > 255){ r = 255;}
        if(g < 0){ g = 0;}
        else if(g > 255){ g = 255;}
        if(b < 0){b = 0;}
        else if(b > 255){ b = 255;}

        graphics.setColor(new Color(r, g, b));
        graphics.drawRect(x, y,1, 1);
    }


    //clears entire content of view
    public void clear(){
        // sets entire view to black
        graphics.setColor(new Color(127, 127, 127));
        graphics.drawRect(0, 0,width, height);
    }
}
