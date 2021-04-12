C343/Fall 2020
Lab08
10/24/2020 18:50
Nolan Cauley nmcauley
 
All of the piece by piece explanations are commented in the code (especially for this assignment)

But in short summary the process is as follows

Instance Variables: 

originalArray[] : this is the stored input value for the array (in the state it was received in)

sortedArray[] : this is the final array that the sorted values are placed according to the keyCounter array.

keyCounter[] : stores a set of values from 0 - k.
length of keyCounter array is that of the maxKey + 1 so we have 0 through maxKey otherwise it would be 0 through (maxKey - 1.) Starts as 0 values from the beginning to then be incremented according to the frequency of our values in the originalArray[].

To describe the process I'll begin from the inputted array through the methods and then to the handled data to be the output

In order to be able to access the input array is by assigning it to the originalArray instance variable from here we call the method findMax()

Input array from this point will be referred to as originalArray

findMax() : 
Iterates through the length of the original array in order to obtain a maxKey value. This is the value that we will keep track of in order to keep tab on all possible values that are in the array to be sorted.

If the value at the current index is greater than the current maxKey then the maxKey is replaced.

After we have our maxKey we now fill the keyCounter array with 0 value to be able to increment in the rest of countingSort()

Now back into countingSort() we are using a foreach loop in order to apply the appropriate increment to the corresponding keyCounter index.

Finally the keyCounter[] is iterated through and the running sum of counts is tabulated

The sorted array stage begins and now by keeping track of the current value in originalArray we apply the corresponding value from the keyCounter (-1 since it is initiated as orginalArray.length + 1) and applying our current value to sortedArray.

Now that we have assigned that value we decrement the keyCounters value for that key

Finally we return the sortedArray.

By passing one of the values at key 268435399 we obtain a Java heap space error that creates an OutOfMemoryError. This is similar to previous problems when we were handling heap space overflows.
This was done by approximating the max number and then within that range find the largest in the other values (thousands / hundreds) to derive the largest possible number without crashing the application
