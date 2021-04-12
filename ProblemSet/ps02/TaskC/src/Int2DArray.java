import java.util.Arrays;
import java.util.Random;

public class Int2DArray implements Int2DArrayADT{
    private int[][] dimensionalArray;

    // constructor of 2-dimensional array of integers.
    // input is the specified number of rows and the second is the specified number of columns.
    public Int2DArray(int row, int col) {
        dimensionalArray = new int[row][col];
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



    public static void main(String[] args) {
        Random generator = new Random();
        Int2DArray test = new Int2DArray(4, 4);
        Int2DArray test02 = new Int2DArray(5, 2);
        Int2DArray test03 = new Int2DArray(8,8);
            // fills the array with random integers (between 0 - 100) using the set(...) method
            for (int row = 0; row < test.dimensionalArray.length; row++) {
                for (int col = 0; col < test.dimensionalArray[row].length; col++) {
                    test.set(row, col, generator.nextInt(100));
                }
            }
        System.out.println("Test 1 (elements filled using set() and displayed with display() methods): ");
        test.display();
        System.out.println("getRow test (from index 2): " + Arrays.toString(test.getRow(2)));
        System.out.println("deleteColumn test (from index 6): fail test ");
        test.deleteColumn(6);
        test.display();
        System.out.println("zeroArray test:");
        test.zeroArray();
        test.display();

        // fills the array with random integers (between 0 - 100) using the set(...) method
        for (int row = 0; row < test02.dimensionalArray.length; row++) {
            for (int col = 0; col < test02.dimensionalArray[row].length; col++) {
                test02.set(row, col, generator.nextInt(100));
            }
        }
        System.out.println("\nTest 2 (filled by set() and displayed with display() methods)");
        test02.display();
        System.out.println("getRow test (from index 5): fail test" + Arrays.toString(test02.getRow(5)));
        System.out.println("deleteColumn test (from index 0): ");
        test02.deleteColumn(0);
        test02.display();
        System.out.println("zeroArray test:");
        test02.zeroArray();
        test02.display();

        // fills the array with random integers (between 0 - 100) using the set(...) method
        for (int row = 0; row < test03.dimensionalArray.length; row++) {
            for (int col = 0; col < test03.dimensionalArray[row].length; col++) {
                test03.set(row, col, generator.nextInt(100));
            }
        }

        System.out.println("\nTest 3 (filled by set() and displayed with display() methods)");
        test03.display();
        System.out.println("getRow test (from index 6): " + Arrays.toString(test03.getRow(6)));
        System.out.println("deleteColumn test (from index 3): ");
        test03.deleteColumn(3);
        test03.display();
        System.out.println("zeroArray test:");
        test03.zeroArray();
        test03.display();

    }
}


