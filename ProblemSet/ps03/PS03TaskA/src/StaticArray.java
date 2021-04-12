import java.util.Arrays;

public class StaticArray {
    Integer[] array = new Integer[10];
    /**
     * The "static array" version of removeAt()
     * removes the element found
     * at the specified index-th position
     * by replacing it with a null value.
     *
     * @param index     The index in the array of the element to be removed.
     * @return          The object that was deleted.
     * since it says it returns the object that was deleted then it would return an Integer value
     */
    Integer removeAt(int index){
        Integer removedValue = this.array[index];
        this.array[index] = null;
        return removedValue;
    }

    public static void main(String[] args){
        StaticArray static1 = new StaticArray();
        for(int i = 0; i < static1.array.length; i++){
            static1.array[i] = i;
        }
        System.out.println("Static array of length 10: " + Arrays.toString(static1.array));
        System.out.println("Removing index 3 ...");
        System.out.println("Removed value at index 3: "+ static1.removeAt(3));
        System.out.println("Updated array:" + Arrays.toString(static1.array));
    }
}
