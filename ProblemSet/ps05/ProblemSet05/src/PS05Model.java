import javax.print.DocFlavor;
import java.io.ObjectStreamException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Observable;
import java.util.Random;

public class PS05Model extends Observable {
    private Observable observable = new Observable();
    int[][] array;
    int size, columns, rows;
    int runtimeSum = 0;

    public PS05Model(int width, int height) {
        array = new int[height][width];
        size = width * height;
        columns = width;
        rows = height;
    }

    public int[][] getArray() {
        return array;
    }

    public void randomize(){
        int max = 255;
        int min = -255;
        // values will be between -255 to 255 (inlcusive)
        Random generator = new Random();
        for(int i = 0 ; i < rows; i++){
            for(int j = 0; j < columns; j++){
                int value = generator.nextInt(max - min + 1) + min;
                this.array[i][j] = value;
            }
        }
    }

    //bubble sort O(n^2) complexity follows the same as sortColumns
    private void sortRows() {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                //for comparing the rows
                for (int k = 0; k < array[row].length - col - 1; k++) {
                    if (array[row][k] > array[row][k + 1]){
                        //replacement
                        int temp = array[row][k];
                        array[row][k] = array[row][k + 1];
                        array[row][k + 1] = temp;
                    }
                }
            }
        }
        setChanged();
        notifyObservers();
    }

    //this uses a bubble sort algorithm -- not the quickest but it is easy to implement.
    private void sortColumns(){
        //iterating through columns
        for (int i = 0; i < array[0].length; i++) {
            // Have we swapped one on this pass?
            boolean swapped;
            do{
                swapped = false;
                // now for each row in the column
                for (int j = 0; j < array.length - 1; j++) {
                    // checks the current with the value next to it (in the next row)
                    if (array[j][i] > array[j + 1][i]) {
                        // stores that value
                        int temp = array[j][i];
                        // replaces that value
                        array[j][i] = array[j + 1][i];
                        // stores the replaced values spot with temp
                        array[j + 1][i] = temp;
                        swapped = true;
                    }
                }
            }while(swapped);
        }
        setChanged();
        notifyObservers();
    }

    // sorts columns first and then rows
    public void sortArray1(){
        long lTimeBefore = System.nanoTime();
        this.sortColumns();
        this.sortRows();

        long lTimeAfter = System.nanoTime();
        long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
        System.out.println(lElapsedNanoSeconds);
        runtimeSum += lElapsedNanoSeconds;
    }

    // sorts rows first and then columns
    public void sortArray2(){
        long lTimeBefore = System.nanoTime();
        this.sortRows();
        this.sortColumns();

        long lTimeAfter = System.nanoTime();
        long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
        System.out.println(lElapsedNanoSeconds);
        runtimeSum += lElapsedNanoSeconds;
    }

    public static void main(String[] args){
        PS05Model test1 = new PS05Model(10, 12);
        test1.randomize();
        System.out.println("Test1 sorted rows:");
        test1.sortArray1();
        for(int[] rows : test1.array){
            System.out.println(Arrays.toString(rows));
        }

        test1.randomize();
        System.out.println("\nTest1 sorted (re-randomized):");
        test1.sortArray2();
        for(int[] rows : test1.array){
            System.out.println(Arrays.toString(rows));
        }

//        for(int i = 1; i <= 10; i++){
//            test1.randomize();
//            test1.sortArray1();
//        }
//        System.out.println("Average time for sortArray1: " + test1.runtimeSum / 10);

//                for(int i = 1; i <= 10; i++){
//            test1.randomize();
//            test1.sortArray2();
//        }
//        System.out.println("Average time for sortArray1: " + test1.runtimeSum / 10);

    }
}
