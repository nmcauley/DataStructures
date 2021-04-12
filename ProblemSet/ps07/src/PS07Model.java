import java.io.File;
import java.util.Arrays;
import java.util.Observable;
import java.util.Scanner;

public class PS07Model extends Observable{
    private Observable observable = new Observable();
    private int height, width;
    int d[][];
    char e[][];
    String aString, bString;

    public PS07Model(int w, int h) {
        height = h;
        width = w;
    }

//    accept two strings s1 and s2, and return an integer value with the computed Edit distance between the two strings.
    public int dist(String s1, String s2) {
        aString = s1; bString = s2;
        int distance, cost;
        // initialize table (d[][] from the instructions):
        d = new int[s1.length() + 1][s2.length() + 1];
        e = new char[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            d[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            d[0][j] = j;
        }

// fill the "Dynamic Programming" table
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                //checks if equal
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cost = 0;
                } else {
                    //operation needed
                    cost = 1;
                }
                int deletion = d[i - 1][j] + 1;
                int insertion = d[i][j - 1] + 1;
                int substitution = d[i - 1][j - 1] + cost;
                //takes the min of either inserting, deleting, or substituted
                int min = Math.min(Math.min(deletion, insertion), substitution);

                char explanation = ' ';
                if(min == deletion){explanation = 'D';}
                else if(min == substitution && cost == 1){ explanation = 'S'; }
                else if(min == insertion){explanation = 'I';}
                e[i][j] = explanation;
                d[i][j] = min;

            }
        }
        setChanged();
        notifyObservers();

        distance = d[s1.length()][s2.length()];
        return distance;
    }

//    return one row of the d array, as built while running the Dynamic Programming algorithm, in the dist() method
    // built upon indices (input 1 --> index 0)
    public int[] dLine(int i){
        if(i < 0 && i > d.length){return null;}
        return d[i - 1];
    }

//    return one row of the e array, as built while running the Dynamic Programming algorithm, in the dist() method
    public char[] eLine(int i){
        if(i >= 0 && i > e.length){return null;}
        return e[i - 1];
    }

    //returns s1 from the dist() algorithm
    public String aString(){
        return aString;
    }
    //returns s2 from the dist() algorithm
    public String bString(){
        return bString;
    }

    public static void main(String[] args) throws Exception {

        PS07Model test = new PS07Model(21,32);
//        System.out.println(test.dist(book1, book2));
        System.out.println(test.dist("honda", "hyundai"));
    }
}
