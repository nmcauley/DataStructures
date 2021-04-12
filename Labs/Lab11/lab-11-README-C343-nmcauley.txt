C343/Fall 2020
Lab11
11/06/2020 12:11
Nolan Cauley nmcauley

First we fill the array with Integer.MAX_VALUE in NofE and with 0 values where they belong such as 0,0 1,1 2,2 and so forth...
We begin with the the max value so we can then pick and choose where to assign specific values in terms of edges 
 
For me, the bulk of the issue in implementing floydNoWeights() was not as much so in the algorithmic execution but more specifically in my initializing of the NofE[][]. I couldn't figure out how to tell if a node had edges and when I did which nodes it was directed towards. 
Upon testing code and playing with adjList I discovered that I could access exactly what I was talking about and assign the values in NofE for their respective edges

This was possible by looping through adjList grabbing each element and then creating a nested loop to see what elements were linked according to their values (index of the edge) I then set that location with a 1 to signify an edge.

From here we have "infinity" values to represent no edge 0 to represent where we are at the same node and 1 to represent an edge.

The next step is the actual implementation of the algorithm.
The only modification necessary from the pseudocode provided was in handling of Integer.MAX_VALUE. Upon doing we prevent overflow issues and negative cycles. Other than that we are complete and simply print our our results by replacing the "infinity" values with a _ in order to present a clean and precise matrix as demonstrated in the outputs

 