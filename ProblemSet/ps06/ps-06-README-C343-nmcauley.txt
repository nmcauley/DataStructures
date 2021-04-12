C343/Fall 2020
ProblemSet-06
10/03/2020 20:33
Nolan Cauley nmcauley

TASK A:

A .50, T .35, C .10 G .05


Character:	Code-word:
A		0

G		100

C		101

T		11


A = 1*50 G = 3*5 C = 3*10  T = 2 * 35

50 + 15 + 30 +70 = 165/100 -> 1.65

1.65 bits per letter is the average cost

Compression ratio = 2 / 1.65 = 1.212

Created a Huffman tree using simple min heap sorting until A was to the left of the root and the proceeding letters were sorted leaving a code such as above in the table. Following the reading I multiplied the frequency by the letters and then added and divided to obtain the average cost per letter. From here we divide 2 by the cost to obtain our compression ratio.


------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


TASK B:

The Huffman tree is built in the following ways:
From the constructor we heapify in init() and then pass through buildTree to removes the first two values creating a new node to be added continuously into our Huffman tree. The arrays are also deconstructed one by one and created into nodes with appropriate weight and value 


Solution approach that I took was by implementing a helper function getPath() that would take a BinNode and a string for inputs. The resulting is as follows:
If the current node is a leaf then we will add our current node value into a 2dimensional array in index 0,0 and our string "path" into 0,1 which will later be accessed by buildCodeTable which calls getPath on its root to recursively obtain the values. If we are not at a leaf then we recursively call getPath on the left and right nodes with strings "0" and "1" concatenated to the path variable to reflect the traversal.


So an issue I ran into as I implemented my solution was in my global instance variable for the huffmanResults String[][] where I was storing all of the keys and codes. When I tested client code it would return the list twice when I was seeing the results from getPath to be added into the dictionary. It was as simple as I tested the getPath twice in the client so it added the values twice to the list without resetting. This completely fixed my issue.

In buildCodeTable() we run a for each loop through the huffmanResults list where we have our String[][] results. We then add them to the dictionary.

decode() was a perfect example of trusting the code when writing it. By simply following the rules of '0' == left and '1' == right we can navigate through the tree until reaching a leaf; upon doing so printing the value and concatenating it to our output. The tricky part was in once we reach our leaf to reset the current node to root so we can reiterate through the tree again.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


TASK C:

Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at EditDistance.editDistance(EditDistance.java:14)
	at EditDistance.main(EditDistance.java:83)

The problem definitely seems to involve either holding onto the table object for too long, or trying to process too much data at a time. This excerpt from geeksforgeeks seems to accurately describe the error; the leaking code is constantly used, the “cached” results end up consuming a lot of Java heap space and when the leaked memory fills all of the available memory in the heap region and Garbage Collection is not able to clean it.




Using the randomly generated DNA string (A-Z) the two following strings were compared for hamming and edit distance. The results are as follows ...

String 1: ZHEMKC
String 2: ZDDUUH

Hamming distance : 5
Runtime: 1573 nanoseconds

edit distance : 5
Runtime: 5694 nanoseconds

So for this instance the edit distance actually takes longer to compute (since it is checking for lowest possible edit solution) while the hamming is demonstrably quicker due to it simply checking if the characters are different or similar.





