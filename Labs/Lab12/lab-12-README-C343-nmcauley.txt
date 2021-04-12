C343/Fall 2020
Lab12
11/13/2020 18:58
Nolan Cauley nmcauley

Much of this implementation very identically to that of Dijkstra's algorithm with the only major discerning addition (or removal rather) is in our relaxation and overall output.

To begin, just as before, we initialize our variables that we will be maintaining for traversing and keeping track of what nodes we have seen

Our result and overall tabulation of our MST is kept in int count which starts at 0 to begin
int[] dist similar to Dijkstra for us to keep track of our current edge weight for each index initialized at the length of our total nodes

ArrayList<Integer> unvisited:
Used to keep track of what vertices we have visited or not initialized by filling it with corresponding node indices from 0 ... totalNodes - 1

Other than that we fill our dist array with MAX_VALUE and our source node(0 in this case) at 0 since we have not traversed anywhere and do not know their values

Now we begin our algorithm which lasts until unvisited is empty
To grab our u vertex we plug our current list of unvisited nodes and the dist array into findMinVert inorder to return the current min vertex. 

findMinVert() :
Given the list of unvisited nodes and distance graph we will use that to ascertain our current next node at the minimum distance possible and return that to be used in the main algorithm as variable u

After we grab our new minimum we need to add the distance for that node to our current cost and then remove u from unvisited (since you know...we visited it)

The next step is to check all of our current neighbors and relax upon their values if necessary
The relax for this will only require the current neighbors distance and the weight between or u vertex and this neighbor

primRelax(int v, int weight)
Only difference between this and Dijkstra's is now we our only keeping into account the edge weight between u and v to that of v instead of also taking into account u's distance
So now if the weight is less than v's current value then we replace v's with that of the weight and return v

This continues throughout until all vertices have been visited and in result we return our cost variable which will reflect our MST.
