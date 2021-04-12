C343/Fall 2020
Lab08
10/16/2020 10:56
Nolan Cauley nmcauley

Disclaimer: flashing screen warning

So to preface this I worked with the UI Bryan Nestor for a couple hours trying to iron out a "bug" I was experiencing with the visualization of my sorting algorithm.

The problem is not in the algorithm or not even the view class according to Bryan but rather somewhere in how quickly it updates and clears the jFrame but in result it causes it to have an epileptic speed in its updates. But if you can bear through the pain of the flashing lights you can see that it actually works and sorts correctly. Bryan said that this would fly and no points would be deducted since everything is there and it all works

For a brief summary of the implementation:

Model: 
Instantiates an array the size of the width of the jFrame.
Uses randomize to populate the array with random positive integers from 0 - height of jFrame.

sort() is a bubble sort algorithm that checks the current value and the one in front of it to see which value to place first. After this inside the inner loop we notify the observer 

View :
drawPoint(x, value)
In order for the points to be visualized from the ground up it was necessary to use drawLine() on the x = index and y = height - value to represent it accurately in height.

paintComponent()
Used starter code in order to clear the background at every re-painting

clear()
resets the frame by using clearRect from x = 0, y = 0 and taking up the entire width/height of the jFrame

actionPerformed()
Clears the frame and repaints it...


Controller:
After instantiating all the necessary classes for the view, model, and controller we then call controller.model.sort in order to trigger our observer. In update we loop through the model's array and drawPoint( (each index), (the value from each index) )

In order to try and minimize how quickly the frame was reset I tried adding a timer but it did not seem to work. Bryan said there was nothing else that he could think of and that everything looked correct.

