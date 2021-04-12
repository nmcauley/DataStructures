import java.util.Arrays;

public class DynamicArray {
    Integer[] array = new Integer[10];
    int currentSize = array.length;
    /**
     * The "dynamic array" version of removeAt()
     * removes the element found at the specified index-th position
     * by shifting all elements that come after it to the "left".
     * I.e.: if we are removing the 2nd element,
     * then the 3rd element becomes the 2nd,
     * and the 4th element becomes the 3rd, and so on.
     *
     * Finally, the size of the array has to be decreased,
     * so we'll know, the next time we add an element to the array,
     * that we can overwrite what was (before the removeAt()
     * operation) the last element  of the array.
     *
     * @param index The index in the array of the element to be removed.
     * @return The object that was removed.
     * null if the the specified index does not exist in the array.
     */
    Integer removeAt(int index) {
        if(index >= currentSize || index < 0){
            return null;
        }
        else {
            Integer removedValue = this.array[index];
            for (int i = index; i < currentSize; i++) {
                if ((i + 1) >= currentSize) {
                    this.array[i] = null;
                } else this.array[i] = this.array[i + 1];
            }
            currentSize -= 1;
            return removedValue;
        }
    }

    public static void main(String[] args){
        DynamicArray dynamicArray1 = new DynamicArray();
        for(int i = 0; i < dynamicArray1.array.length; i++){
            dynamicArray1.array[i] = i;
        }

        System.out.println("Initial dynamic array of length 10: " + Arrays.toString(dynamicArray1.array));
        System.out.println("Removing index 3 ...\nRemoved value at index 3: "+ dynamicArray1.removeAt(3));
        System.out.println("Updated array:" + Arrays.toString(dynamicArray1.array) + "\nUpdated Size: " + dynamicArray1.currentSize);
        System.out.println();
        System.out.println("Removing index 2 ... \nRemoved value at index 2: " + dynamicArray1.removeAt(2));
        System.out.println("Updated array:" + Arrays.toString(dynamicArray1.array) + "\nUpdated Size: " + dynamicArray1.currentSize);
        System.out.println();
        System.out.println("Removing index 4 ... \nRemoved value at index 4: " + dynamicArray1.removeAt(4));
        System.out.println("Updated array:" + Arrays.toString(dynamicArray1.array) + "\nUpdated Size: " + dynamicArray1.currentSize);
        System.out.println();
        System.out.println("Removing index 7 ... \nRemoved value at index 7: " + dynamicArray1.removeAt(7));
        System.out.println("Updated array:" + Arrays.toString(dynamicArray1.array) + "\nUpdated Size: " + dynamicArray1.currentSize);
    }
}
