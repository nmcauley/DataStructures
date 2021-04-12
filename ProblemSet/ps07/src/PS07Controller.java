import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectStreamConstants;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class PS07Controller implements Observer{
    private PS07View view;
    private PS07Model model;

    public PS07Controller(PS07Model m, PS07View v){
        m.addObserver(this);
        model = m;
        view = v;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("Flatland01Truncate.txt");
        File file2 = new File("Flatland02Truncate.txt");
        String book1 = "";
        String book2 = "";
        Scanner sc1 = new Scanner(file1);
        while (sc1.hasNextLine()){
            book1 = book1 + sc1.nextLine();
        }
        Scanner sc2 = new Scanner(file2);
        while (sc2.hasNextLine()){
            book2 = book2 + sc2.nextLine();
        }

        int width = 2560;
        int height = 1600;
        PS07Model model = new PS07Model(width, height);
        PS07View view = new PS07View(width, height);

        PS07Controller controller = new PS07Controller(model, view);
        model.dist(book1, book2);

    }

    int firstCount = 0;
    @Override
    public void update(Observable o, Object arg) {
        if(firstCount == 0){
            stringLines();
            arrayColor();
            firstCount++;
        }else{
            arrayColor();
        }
    }

    // traverses the strings and appoints the appropriate color (y is a consonant for this)
    private void stringLines(){
        String punctuation = ".,;:\'\"\\ ";
        String consonant = "qwrtypsdfghjklzxcvbnm";
        String vowel = "aeiou";

        char[] s1 = model.aString.toCharArray();
        char[] s2 = model.bString.toCharArray();
        // horizontal line for aString
        for(int i = 0; i < s1.length; i++){
            if(vowel.contains(Character.toString(s1[i]))){
                //cyan
                view.drawPoint( i, 0, 0, 255, 255);
            }
            else if(consonant.contains(Character.toString(s1[i]))){
                //purple (consonant)
                view.drawPoint( i, 0, 128, 0, 128);

            } else{
                //white
                view.drawPoint( i, 0, 255, 255, 255);
            }
        }
        // vertical line for bString
        for(int i = 0; i < s2.length; i++){
            if(punctuation.contains(Character.toString(s2[i]))){
                //white
                view.drawPoint(0, i, 255, 255, 255);
            }
            else if(vowel.contains(Character.toString(s2[i]))){
                //cyan
                view.drawPoint(0, i, 0, 255, 255);
            } else{
                //purple (consonant)
                view.drawPoint(0, i, 128, 0, 128);
            }
        }
    }

    // represents the values of e[][] and d[][]
    // calls highlightMin to identify the minimal distance in the row
    private void arrayColor(){
        for(int i = 1; i <= model.e.length; i++){
            int min = 0;
            for(int j = 1 ; j <= model.eLine(i).length; j++){
                //stores consistent min for use later
                if(model.dLine(i)[min] > model.dLine(i)[j-1]){ min = j - 1; }

                char curr = model.eLine(i)[j - 1];
                if(curr == ' '){
                    //green
                    view.drawPoint(j, i,0, 255, 0);
                }
                else if(curr == 'S'){
                    //yellow
                    view.drawPoint(j, i,255, 255, 0);
                }
                else if(curr == 'D'){
                    //red
                    view.drawPoint(j, i,255, 0, 0);
                }
                else{
                    //blue
                    view.drawPoint(j, i,0, 0, 255);
                }
            }
            view.drawPoint(min, i, 0, 0, 0);
        }

    }
}
