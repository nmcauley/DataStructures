import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class Lab08Controller implements Observer {
    private Lab08View view;
    private Lab08Model model;
    javax.swing.Timer timer;



    public Lab08Controller(Lab08Model m, Lab08View v){
        m.addObserver(this);
        model = m;
        view = v;
    }

    public static void main(String[] arg){
        Lab08Model model = new Lab08Model(1200, 720);
        Lab08View view = new Lab08View(1200, 720);
        Lab08Controller controller = new Lab08Controller(model, view);

        //populate
        model.randomize();
        System.out.println("Unsorted: \n" + Arrays.toString(controller.model.array));
        controller.model.sort();
        System.out.println("\nTest1 sorted rows:");
        System.out.println(Arrays.toString(controller.model.array));
    }

    @Override
    public void update(Observable o, Object arg) {
        view.clear();
        for(int i = 0; i < model.array.length; i++){
            view.drawPoint(i, model.array[i]);
        }
//        timer = new Timer(5000, view);
//        timer.start();

    }
}
