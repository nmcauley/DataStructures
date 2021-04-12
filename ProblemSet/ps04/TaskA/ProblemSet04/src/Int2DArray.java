import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Int2DArray extends Canvas{
    public int[][] dimensionalArray;

    // constructor of 2-dimensional array of integers.
    // input is the specified number of rows and the second is the specified number of columns.
    public Int2DArray(int row, int col) {
        dimensionalArray = new int[row][col];
        initArray();
    }

    public void display(){
        for(int[] row : dimensionalArray){
            System.out.println(Arrays.toString(row));
        }
    }

    public void set(int row, int col, int input) { dimensionalArray[row][col] = input; }

    public Integer get(int row, int col) { return dimensionalArray[row][col]; }

    public void zeroArray() {
        for(int i = 0; i < dimensionalArray.length; i++){
            for(int j = 0; j < dimensionalArray[i].length; j++){
                dimensionalArray[i][j] = 0;
            }
        }
    }

    // given an integer getRow will return that numbered row from the array.
    // returns nulls if the specified row does not exist.
    public int[] getRow(int row){
        try {
            return dimensionalArray[row];
        }catch(Exception ex){
            return null;
        }

    }

    //sets all values in the specified column to 0
    public void deleteColumn(int col){
        for(int[] row : dimensionalArray){
            // checks if col is within the bounds of the array otherwise nothing is done.
            if(dimensionalArray.length < col){break;}
            row[col] = 0;
        }
    }

    public void initArray() {
        // fills the array with random integers (between 0 - 100) using the set(...) method
        for (int row = 0; row < dimensionalArray.length; row++) {
            for (int col = 0; col < dimensionalArray[row].length; col++) {
                //random number generator
                long min = Integer.MIN_VALUE;
                long max = Integer.MAX_VALUE;
                int value = (int) (min + (max - min) * Math.random());
                // set value
                set(row, col, value);
            }
        }
    }


    public static void main(String[] args) {
        Int2DArray test = new Int2DArray(200, 200);

    }
}


