public interface Int2DArrayADT {

    // prints out the array by rows in a matrix format.
    public void display();

    // sets the desired input at the desired index location
    public void set( int row, int col, int input);

    //given a specific row and column the value at that index is returned from the array
    public Integer get(int row, int col);

    // replaces every value in the array with the value 0.
    public void zeroArray();
}
