import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


// explicit import of every Java class we use from the Swing package:
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;


// this PS04starterCode Java class will:
//   extend JComponent to draw into a Graphics object, and
//   implement ActionListener to periodically repaint the Graphics object.
class PS04starterCode extends JComponent implements ActionListener {

    static final int H_SIZE = 256;
    static final int V_SIZE = 512;

    // TODO: draw the content of this 2D array of integers,
    //       where each integer value in the array should be represented thus:
    //       from MIN_VALUE to 0 (included) - black color
    //       from 1 to 254 - gray color at given intensity
    //       from 255 to MAX_VALUE - white color
    Int2DArray instance = new Int2DArray(H_SIZE, V_SIZE);
    int[][] pixels = instance.dimensionalArray;


//    javax.swing.Timer timer;


    // we have to implement actionPerformed() since we implement the ActionListener interface:
    public void actionPerformed(ActionEvent e) {
        System.out.println("here be actionPerformed() for PS04starterCode");

        // tell the JComponent that it ought to repaint itself:
        this.repaint();
    } // end of actionPerformed()


    // we override the JComponent's paintComponent() method, to do some drawing:
    //  and we receive the currently active graphics for our JComponent:
    public void paintComponent(Graphics pGraphics) {
        System.out.println("here be paintComponent() for PS04starterCode");
        //
        // "The Graphics class is the abstract base class for all graphics contexts
        //   that allow an application to draw onto components that are realized on\
        //   various devices, as well as onto off-screen images."
        // https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html
        super.paintComponent(pGraphics);

        // clear background at every re-painting:
        pGraphics.setColor(Color.PINK);
        Shape lClipArea = pGraphics.getClip();
        int lWidth = lClipArea.getBounds().width;
        int lHeight = lClipArea.getBounds().height;
        pGraphics.fillRect(0,0,lWidth,lHeight);

        for(int i = 0; i < pixels.length; i++){
            for (int j = 0; j < pixels[i].length; j++) {
                int current = pixels[i][j];
                if(current <= 0){
                    //black
                    pGraphics.setColor(new Color(0,0,0));
                    pGraphics.drawRect(i, j, 1, 1);
                }
                else if(current >= 1 && current <= 254){
                    //gray - varying degrees
                    pGraphics.setColor(new Color(current, current, current));
                    pGraphics.drawRect(i, j, 1, 1);
                } else{
                    //white pixel
                    pGraphics.setColor(new Color(255, 255, 255));
                    pGraphics.drawRect(i, j, 1, 1);
                }
            }
        }
    } // end of paintComponent()


    // client code - main() method:
    public static void main(String[] args) {
        // instantiate the main JComponent, i.e. "this" Java class:
        PS04starterCode theMainJComponent = new PS04starterCode();

        // create JFrame where we (the main object in its JComponent identity) can paint:
        JFrame aJFrame = new JFrame();
        aJFrame.add(theMainJComponent);
        aJFrame.setSize(H_SIZE, V_SIZE);
        aJFrame.setVisible( true );

    } // end of main()


}