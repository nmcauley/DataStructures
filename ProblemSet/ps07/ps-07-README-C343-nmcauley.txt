C343/Fall 2020
ProblemSet-07
10/03/2020 13:20
Nolan Cauley nmcauley

PS07Model :
dist(String, String)
This implementation is the same as that of our editDistance from ps06 except for some slight differences. In summary, we create d[][] which stores the values of the distance as we traverse through the two strings. We traverse through the corresponding characters and if they match then there will be a cost of 0, otherwise 1. The cost is important as we now calculate the cost of insertion, deletion, and substitution; whichever is the min is our editDistance. Updates to this assignment are now to have a char[][] that contains our values for which operation we are choosing. Whichever we select we place into the corresponding spot of the char[][] until the loop completes thus notifying our observer which will be discussed in PS07Controller's update().


dLine & eLine : 
Returns a row from either the e[][] or d[][] array. Simply checks if the given number is within the ranges of the array's length and returns the row

aString() & bString() :
dist() saves the two string inputs into the instance variables aString and bString which are retrieved in these functions

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

PS07View :
Instance variables for width height, the jFrame, and Graphics. These are instantiated in the constructor. 

drawPoint() :
Layers if else if statements to check the value of r g and b from the input. Truncates their values within the bounds of rob values 0 - 255
After that it sets a new color at the specified r g b values and then draws a rectangle at the specified x and y.

clear()
Not sure when this is ever implemented but it sets the color to rgb 127, 127, 127 and draws a rectangle the size of the current width and height.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

PS07Controller :
Instance variables for a view and model which are instantiated in the constructor along with the observer method.

We read the files into the main method and in order to trigger the update method we need to call dist() on our declared model with the 2 scanned in files as input.

update() :
Upon triggering, we check if this is the first time calling update, in which case we illustrate the two string values horizontally and vertically in the manner of a Levenshtein table. This is executed in stringLines(). So update does not have much but the following procedures...
if(firstCount == 0){
     stringLines();
     arrayColor();
     firstCount++;
    }else{
 arrayColor();
}
So after our first iteration we will only be calling our arrayColor() method which paints the values of e[][] into the Jframe

stringLines() : 
Turning the aString and bString into charArray we can then compare each character for its value. This can be done by having variables containing only punctuation, only vowels, or only consonants and using .contains(Character.toString(...)) on our current char. Depending on the value we call .drawPoint on our view variable at the either (x = i, y = 0) for our horizontal line and vice versa for the vertical string. This is all contained within a loop through the length of string 1 and 2.

arrayColor() :
This method is basically an overcomplicated for each loop that as we go through every row of e[][] we are assigning colors based on the current char stored in:
char curr = model.eLine(i)[j - 1];

Instead of creating a separate function to assign a highlight to the minimum value in the rows of d[][] I kept a running min index outside of the inner for loop that compares the values and stores the corresponding index of the minimum index;
After the loop that index is then assigned a black pixel.
