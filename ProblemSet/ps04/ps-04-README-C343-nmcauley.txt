C343/Fall 2020
ProblemSet-04
09/22/2020 22:12
Nolan Cauley nmcauley

TASK A:
I have the random values out but we never learned how to use JFrame and graphics stuff. I'm not sure how to set the values between the range and honestly I spent majority of the time trying to fix the overflow caused by Integer.MAX and MIN.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK B:
My thought process when implementing find() was that it would check if the current value compares to the value we are searching for. If the given value is comparable then it returns true and then from here we check if the left or right are null when deciding to recursively loop through the tree.

If this were a sorted tree then it would be remarkably simpler to just check if the value is equal and then how it compares to the value. Then we would only be concerned with one side of the tree and if that side is null or not.


------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK A REVISION:

For the resubmit I changed the following to create a correct output:

Int2DArray:
Created a method initArray that fills the values of the int[][] with values ranging from Integer.MIN_VALUE to Integer.MAX_VALUE which is called in the constructor for the Int2DArray class.

StarterCode:
Now in paintComponent we loop through our int[][] object from Int2DArray and paint onto our jFrame accordingly. We check if our value is less than 0, between 1 - 254, or at MAX_VALUE to set the current color as black gray or white respectively. Setting black and white is pretty straightforward but with grey the only thing we needed to do to ensure that we had varying scales of gray intensity is by setting our new color to the current value that we initially compared with. Other than that we simply draw using the established color using a rectangle at the current index location with width and height of 1