import java.util.Arrays;

public class Lab09CountingSort {
    //   ***input***:
//    A is an unsorted array of  n  integer keys
//            (and  k  is the largest value of all keys in A)
//    A may contain more than one entry for any given key value
    int[] originalArray;

    //***output***:
//    C will be a sorted array of  n  integer keys (we can preserve the input array A)
    int[] sortedArray;

//***intermediate array***:
//    B is an array of  k  integer counters, initially all set to 0
//    (B is constructed as histogram in the first stage, and it is rebuilt as a lookup table in the second stage,
//    for use in the third stage of the algorithm)
    int[] keyCounter;

    //k  is the largest value of all keys in keys bounds the range (0 - k)
    int maxKey = 0;

    //if we have crossed the memory max
    boolean containsOverflow = false;

    //header for function; modifies the original/unsorted array
    public void findMax(){
        //iterates and checks for max value to set maxKey
        for(int i = 0; i < originalArray.length; i++) {
            //checks if the value is over the breaking point
            if(originalArray[i] > 268435399){
                //used to notify that we can no longer proceed with the current max
                containsOverflow = true;
                //returns us from the method
                return;
            }
            //checks if the current value is greater
            if(maxKey < originalArray[i]) {
                //current value is the new maxKey
                maxKey = originalArray[i];
            }
        }
        //now we assign our array containing the key values to that given length
        // length of keyCounter array is that of the maxKey + 1 so we have 0 through maxKey otherwise it would be 0 through (maxKey - 1)
        keyCounter = new int[maxKey + 1];
        //sets all values to 0 for initial counter
        Arrays.fill(keyCounter, 0);
    }

    //takes an int[] and returns an int[]
    public int[] countingSort(int[] unsortedArr){
        //sets the input to our instance variable which is grabbed in our helper methods.
        originalArray = unsortedArr;
        //find max value in the array
        findMax();
        //checks if too big of a number exists
        if(containsOverflow){
            System.out.println("Too big of a maximum number has been input.");
            return null;
        } //else; we have max under the overflow point
        else {

            //iterates through the input array counting the frequency
            for (int i : originalArray) {
                //increments the index in the keyCounter depending on how many times we see the value in the originalArray
                keyCounter[i] += 1;
            }
            //now we iterate through the keyCounter Array to run apply our running sum of values
            for (int i = 1; i < keyCounter.length; i++) {
                //we are applying the previous sum of counts to our current and so on
                keyCounter[i] += keyCounter[i - 1];
            }


            //now its time to sort and create our sorted array; setting the length to that of our input
            sortedArray = new int[unsortedArr.length];
            //checks if the value if one of the values is
            //iterates from backwards from length - 1 (last index) to 0
            for (int i = (originalArray.length - 1); i >= 0; i--) {
                //current value in the originalArray
                int current = originalArray[i];
                //the corresponding index in the keyCounter is the orignalArray (index - 1)
                sortedArray[keyCounter[current] - 1] = current;
                //decrements the value in the keyCounter so we know
                keyCounter[current] -= 1;
            }

            //returns the sorted array (i.e. sortedArray)
            System.out.println();
            return sortedArray;
        }
    }

    public static void main(String[] args){
        //object variable
        Lab09CountingSort testObj1 = new Lab09CountingSort();
        //array with small values
        int[] test1 = {2, 3, 4, 5, 4, 4, 0};
        //calling method on array
        testObj1.countingSort(test1);
        //print tests
        System.out.println("Original (unsorted) Array: " + Arrays.toString(testObj1.originalArray) + "\nMax Key: " + testObj1.maxKey);
        System.out.println("Sorted Array: " + Arrays.toString(testObj1.sortedArray) +"\n");

        Lab09CountingSort testObj2 = new Lab09CountingSort();
        //sets values that are all the same
        int[] test2 = {10, 10, 10, 10, 10};
        //calling method on array
        testObj2.countingSort(test2);
        //print tests
        System.out.println("Original (unsorted) Array: " + Arrays.toString(testObj2.originalArray) + "\nMax Key: " + testObj2.maxKey);
        System.out.println("Sorted Array: " + Arrays.toString(testObj2.sortedArray) +"\n");

        Lab09CountingSort testObj3 = new Lab09CountingSort();
        //sets large number of values
        int[] test3 = {0, 22, 36, 21, 5};
        //calling method on array
        testObj3.countingSort(test3);
        //print tests
        System.out.println("Original (unsorted) Array: " + Arrays.toString(testObj3.originalArray) + "\nMax Key: " + testObj3.maxKey);
        System.out.println("Sorted Array: " + Arrays.toString(testObj3.sortedArray) +"\n");

        //failure point
//        Lab09CountingSort testObjBreak = new Lab09CountingSort();
//        //larger values(significantly) to find break point 199999999
//        int[] test4 = {268435400, 1, 2, 3, 4, 5};
//        //calling method on array
//        testObjBreak.countingSort(test4);
//        //print tests
//        System.out.println("Original (unsorted) Array: " + Arrays.toString(testObjBreak.originalArray) + "\nMax Key: " + testObjBreak.maxKey);
//        System.out.println("Sorted Array: " + Arrays.toString(testObjBreak.sortedArray) +"\n");

        Lab09CountingSort testObj4 = new Lab09CountingSort();
        int[] test5 = {1, 2, 3, 4, 4, 5, 6, 7, 9, 23, 10, 10};
        //calling method on array
        testObj4.countingSort(test5);
        //print tests
        System.out.println("Original (unsorted) Array: " + Arrays.toString(testObj4.originalArray) + "\nMax Key: " + testObj4.maxKey);
        System.out.println("Sorted Array: " + Arrays.toString(testObj4.sortedArray) + "\n");

        Lab09CountingSort testObj5 = new Lab09CountingSort();
        //now to sort in reverse order
        int[] test6 = {13, 10, 10, 6, 5, 4, 4, 3, 2, 0};
        //calling method on array
        testObj5.countingSort(test6);
        //print tests
        System.out.println("Original (unsorted) Array: " + Arrays.toString(testObj5.originalArray) + "\nMax Key: " + testObj5.maxKey);
        System.out.println("Sorted Array: " + Arrays.toString(testObj5.sortedArray));
    }
}
