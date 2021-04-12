import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class PS05Controller implements Observer {
    private PS05View view;
    private PS05Model model;

    public PS05Controller(PS05Model m, PS05View v){
        m.addObserver(this);
        model = m;
        view = v;
    }

    public static void main(String[] arg){
        PS05Model model = new PS05Model(1280, 720);
        PS05View view = new PS05View(1280, 720);
        PS05Controller controller = new PS05Controller(model, view);

        //populate
        model.randomize();
        model.sortArray1();
    }

    @Override
    public void update(Observable o, Object arg) {
        for(int i = 0; i < model.rows; i++){
            for(int j = 0; j < model.columns; j++){
                view.drawPoint( j, i, model.array[i][j]);
            }
        }
    }
}
