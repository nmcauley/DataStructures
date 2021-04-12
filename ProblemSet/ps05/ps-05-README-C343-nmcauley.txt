C343/Fall 2020
ProblemSet-05
09/29/2020 20:17
Nolan Cauley nmcauley

TASK A:

Simple declarations of the three classes.


------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK B:

Set it to the size of my screen for instantiating the objects (holy smokes it shows just how long it takes for the bubble sort algorithm)

I will revert it to a smaller size so I don't have to wait 3 years for it to finish.


------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK C: 

For handling the model class the process worked as follows:
Constructor method includes initializing the array with the input variables for height and width.

getArray() - simply returns the array

Randomize() - two variables max and min to represent the spectrum of values that will be generated. By using a nested for loop and a random number generator we can declare each value of the array.

sortRows() - used a bubble sort algorithm due to the ease of implementing it when sorting arrays. Efficiency will be described later but overall it iterates through the values of the rows using a nested for loop and then finally another loop to compare and swap the values. If the current value is larger then it is stored in a temporary variable and placed in the following value while that value is placed in the current index.

As observable this function notifies update whenever it is finished.

sortColumns() - same as sortRows(); used a bubble sort algorithm due to the ease of implementing it when sorting arrays. Efficiency will be described later but overall it iterates through the values of the rows using a nested for loop and then finally another loop to compare and swap the values. If the current value is larger then it is stored in a temporary variable and placed in the following value while that value is placed in the current index.

This function also notifies the observer...

sortArray1() - simply calls sortColumns() and then sortRows()

sortArray2() - simply calls sortRows() and then sortColumns()


------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


TASK D:

drawPoint(...) - 
This method is a giant if statement deciding the color for the pixel depending on the value (from the model)

If between the ranges then by accessing the instance variable for frame.getGraphics() then we can set the color and draw the rectangle.

Everything here is pretty straightforward except for a key part that was -254 to -1. Because the color red only goes from 0 to 255 then I opted to get the value by subtracting the difference between the the value and 255 and then that difference to 255 in order to obtain the right decrease in intensity for red

clear() - sets the color to black and makes a rectangle the size of the frame.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK E:

The controller class implements observer and in the constructor sets the model as the observable.

Once the observer is triggered the update() method is invoked which does the following:

Paints the values of the model onto the view.
This is done by looping through all values of the array and thus plugging them into drawpoint with the row value being the y value and j being the x.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK F:

1 & 2 : I don't think so that either of them are fully sorted in that when I print out the visualization It presents the initial update but then after some time it update more and the images colors are much smoother; indicating that the numbers have been further sorted I assume.

But when I do test out displaying the arrays in client tests in the main of the model it produces fully sorted arrays so that is where I have my doubts.

3. For both of them I think it O(n^4) or something similar since each one use bubble sort to sort their values and bubble sort has the time complexity of O(n^2)
This is definitely illuminating in the strength of using heap sort instead for an algorithm. It runs O(logn) I believe and is markedly faster.

4.In order to gain the average time I ran a for loop for 10 iterations of randomizing and 
Sorting the array and then adding the runtimes to obtain a better average. This is because every other time I tested it I would get varying numbers due to the arbitrary nature of the values.

The results are as follows:

Average time for sortArray1: 134141 nanoseconds

Average time for sortArray2: 134575 nanoseconds

So the results seem to be that they do compute in around the same manner of complexity. 
