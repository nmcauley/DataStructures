import javax.swing.*;
import java.util.Arrays;
import java.util.Observable;
import java.util.Random;

public class Lab08Model extends Observable {
    private Observable observable = new Observable();
    int[] array;
    int columns, h;
    int runtimeSum = 0;



    public Lab08Model(int width, int height) {
        array = new int[width];
        columns = width;
        h = height;
    }

    public int[] getArray() {
        return array;
    }

    public void randomize(){
        int max = h;
        int min = 0;
        // values will be between -255 to 255 (inlcusive)
        Random generator = new Random();
        for(int i = 0 ; i < array.length; i++){
                int value = generator.nextInt(max - min + 1) + min;
                this.array[i] = value;
        }
    }
    //bubble sort
    void sort() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                setChanged();
                notifyObservers();
            }
        }
    }


    public static void main(String[] args){
        Lab08Model test1 = new Lab08Model(20, 100);
        test1.randomize();
        System.out.println("Unsorted: \n" + Arrays.toString(test1.array));
        System.out.println("\nTest1 sorted rows:");
        test1.sort();
        System.out.println(Arrays.toString(test1.array));

    }
}
