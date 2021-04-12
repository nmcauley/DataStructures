C343/Fall 2020
ProblemSet-10
11/02/2020 00:32
Nolan Cauley nmcauley

TASK A:

If this graph were a directed graph then the traversal would be much more specific and dependent upon the path we select. Due to it being undirected we can travel along any edge connected to our current index. In summary if we do not take into account the 'cost' of the edges as we traverse we can go left to right from the root without any backtracking.
With us starting at E and going as far as possible we begin with F.
From F we travel across to C so we only have to travel down from here.
C -> A we can visit B or A which are unvisited but if we went to B we would have to backtrack inorder to reach our final node D
A -> B we only have the choice of B or backtracking to a previously visited node.
B -> D this is our final unvisited node, the rest are backtracking and this finishes our DFS graph traversal.

DFS and BFS do not take edge weights into account
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
TASK B:
pointer = 4 bytes
vertex label =  2 bytes
edge presence/absence = 1 byte 
(ignore edge weights and their memory requirements for now)

Matrix:
Does not account for pointer

We account for all possible edge cases so 6 * 6 = 36 possible cases whether they are present or not
Edges (present and absent) = 36 * 1 -> 36 bytes
Pointer = 0

Vertex Label = 6 vertices * 2 bytes = 12 bytes

Total cost for adjacency matrix = 36 + 12 -> 48 bytes 


List:
Accounts for pointers and null pointers 6 null pointers (not sure they weren't explained in class) and 9 pointers for each edge
Pointers = 15 * 4 bytes = 60 bytes

Vertex = 6 vertices * 2 byte = 12 bytes
Does not account for edge absences only present in linked list implementation
Edge = 0 for list

Total cost for adjacency list = 60 + 12 -> 72 bytes

Adjacency matrix is going to be more efficient for this problem due to the high cost of pointers that drastically brings up the cost for a list implementation.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
TASK C:
Pointer = 2 bytes
Vertex label = 1 byte
Edge (presence/absence) = 1

Matrix:
Does not account for pointer

We account for all possible edge cases so 6 * 6 = 36 possible cases whether they are present or not
Edges (present and absent) = 36 * 1 -> 36 bytes (remains the same)

Vertex Label = 6 vertices * 1 bytes = 6 bytes

Total cost for adjacency matrix = 36 + 6 -> 42 bytes 

List:
Accounts for pointers and null pointers 6 null pointers and 9 pointers
Pointers = 15 * 2 bytes = 30 bytes

Vertex = 6 vertices * 1 byte = 6 bytes
Does not account for edge absences only present in linked list implementation
Edge = 0 for list 

Total cost for adjacency list = 30 + 6 -> 36 bytes

This drastically dropped the cost of the list implementation for the cost of a pointer and almost made it require less space than the matrix. The edge absence presence is what maintained the requirement for the matrix and by trimming on the costs for lists assets made it more efficient this time around

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK D:

In my client code I could not get my component counter to work and it was until I realized I called walk that the ifVisited had been set to true thus ignoring the main code counting the components this is because:
We set a variable as a counter that as we progress through the nodeList we call DFS on unvisited nodes since as we recursively travel through the component tree we set them as visited already in DFS() so we are only counting at the beginning of new components.

The next issue concerned that of counting the amount of individual nodes in the given component


For client test code we instantiated a graph and used our String[] of vertices to set to the graph (i.e. letters A - J). Then from here we decide what edges we want to set. Once we do this we can check the current amount of nodes and edges by using display()

