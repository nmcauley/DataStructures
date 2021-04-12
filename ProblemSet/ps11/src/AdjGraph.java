// a simple implementation for graphs with adjacency lists

// Problem Set 11 starter file

import java.lang.reflect.Array;
import java.util.*;

public class AdjGraph implements Graph {

    // is it a directed graph (true or false) :
    private boolean digraph;

    private int totalNodes;
    // all the nodes in the graph:
    private Vector<String> nodeList;

    private int totalEdges;
    // all the adjacency lists, one for each node in the graph:
    private Vector<LinkedList<Integer>>  adjList;

    // all the weights of the edges, one for each node in the graph:
    private Vector<LinkedList<Integer>> adjWeight;

    // every visited node:
    private Vector<Boolean> visited;

    // list of nodes pre-visit:
    private Vector<Integer> nodeEnum;

    public AdjGraph() {
        init();
    }

    public AdjGraph(boolean ifdigraph) {
        init();
        digraph = ifdigraph;
    }

    public void init() {
        nodeList = new Vector<String>();
        adjList = new Vector<LinkedList<Integer>>();
        adjWeight = new Vector<LinkedList<Integer>>();
        visited = new Vector<Boolean>();
        nodeEnum = new Vector<Integer>();
        totalNodes = totalEdges = 0;
        digraph = false;
    }

    // set vertices:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i ++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            adjWeight.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes ++;
        }
    }

    // add a vertex:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
        adjWeight.add(new LinkedList<Integer>());
        totalNodes ++;
    }

    public int getNode(String node) {
        for (int i = 0; i < nodeList.size(); i ++) {
            if (nodeList.elementAt(i).equals(node)) return i;
        }
        return -1;
    }

    // return the number of vertices:
    public int length() {
        return nodeList.size();
    }

    // add edge from v1 to v2:
    public void setEdge(int v1, int v2, int weight) {
        LinkedList<Integer> tmp = adjList.elementAt(v1);
        if (adjList.elementAt(v1).contains(v2) == false) {
            tmp.add(v2);
            adjList.set(v1,  tmp);
            totalEdges ++;
            LinkedList<Integer> tmp2 = adjWeight.elementAt(v1);
            tmp2.add(weight);
            adjWeight.set(v1,  tmp2);
        }
    }

    public void setEdge(String v1, String v2, int weight) {
        if ((getNode(v1) != -1) && (getNode(v2) != -1)) {
            // add edge from v1 to v2:
            setEdge(getNode(v1), getNode(v2), weight);
            // for undirected graphs, add edge from v2 to v1 as well:
            if (digraph == false) {
                setEdge(getNode(v2), getNode(v1), weight);
            }
        }
    }

    // keep track whether a vertex has been visited or not,
    //    for graph traversal purposes:
    public void setVisited(int v) {
        visited.set(v, true);
        nodeEnum.add(v);
    }

    public boolean ifVisited(int v) {
        return visited.get(v);
    }


    // new for Problem Set 11:
    public LinkedList<Integer> getNeighbors(int v) {
        return adjList.get(v);
    }

    public int getWeight(int v, int u) {
        LinkedList<Integer> tmp = getNeighbors(v);
        LinkedList<Integer> weight = adjWeight.get(v);
        if (tmp.contains(u)) {
            return weight.get(tmp.indexOf(u));
        } else {
            return Integer.MAX_VALUE;
        }
    }

    // clean up before traversing the graph:
    public void clearWalk() {
        nodeEnum.clear();
        for (int i = 0; i < nodeList.size(); i ++)
            visited.set(i, false);
    }

    public void walk(String method) {
        clearWalk();
        // traverse the graph:
        for (int i = 0; i < nodeList.size(); i ++) {
            if (ifVisited(i) == false) {
                if (method.equals("BFS")) {
                    BFS(i);      // i is the start node
                } else if (method.equals("DFS")) {
                    DFS(i); // i is the start node
                } else {
                    System.out.println("unrecognized traversal order: " + method);
                    System.exit(0);
                }
            }
        }
        System.out.println(method + ":");
        displayEnum();
    }
//------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------
    // Problem Set 11 TODO:
    //
    // write your methods here.
    //input source node index

    public void dijkstra1(int sourceNode){
        //initialize
        // array for keeping track of tables; length is total vertices
        int[] dist = new int[totalNodes];

        ArrayList<Integer> unvisited = new ArrayList<>(totalNodes);
        for(int i=0;i < totalNodes;i++){ unvisited.add(i); }
        //fill arrays with inf and false
        Arrays.fill(dist, Integer.MAX_VALUE);
        // set 0 for source value
        dist[sourceNode] = 0;

        //until we have visited all nodes
        while(!unvisited.isEmpty()){
            //find minimal distance node
            int u = findMinVert(unvisited, dist);
            //remove the min from unvisited
            unvisited.remove(unvisited.indexOf(u));
            //we have reached an unreachable point
            if(dist[u] == Integer.MAX_VALUE){
                break;
            }
            //now to relax upon the neighbors
            LinkedList<Integer> neighbors = getNeighbors(u);
            //search among the neighbors for unvisited ones
            for(int i = 0; i < neighbors.size(); i++){
                //current neighbor
                int v = neighbors.get(i);
                //if we have not visited it; relax
                if(unvisited.contains(v)){
                    dist[v] = relax(dist[u], dist[v], getWeight(u, v));
                }
            }
        }
        //print results
        System.out.println("Shortest path from source node " + nodeList.elementAt(sourceNode));
        for(int i = 0; i < dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("Vertex " + nodeList.elementAt(i) + ": unreachable");
            } else {
                System.out.println("Vertex " + nodeList.elementAt(i) + ": " + dist[i]);
            }

        }
    }
    //returns neighbor node with the minimum weight
    public int findMinVert(ArrayList<Integer> list, int[] dist) {
        //current from list
        int v = list.get(0);
        //current dist
        int minDis = dist[v];
        for(int i = 1; i < list.size(); i++){
            if(dist[list.get(i)] < minDis){
                v = list.get(i);
                minDis = dist[v];
            }
        }
        return v;
    }

    //returns new min or the unchanged min
    //input are the distance for vertex u, vertex v and the edge weight between them
    public int relax(int u, int v, int weight) {
        if (v > u + weight) {
            v = u + weight;
        }
        return v;
    }
    //------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------
    public void topologicalSortWithQueue(){
        ArrayList<Integer> sortedVertices = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
        int[] count = new int[totalNodes];
        Arrays.fill(count, 0);
        int v;
        //edge processing count initializer
        for(v = 0; v < totalNodes; v++){
            for(int i = 0; i < getNeighbors(v).size(); i++){ //go through every neighbor
                count[getNeighbors(v).get(i)]++; //increment count of inDegree
            }
        }
        // q initializer
        for(v = 0; v < count.length; v++) {
            if(count[v] == 0){
                Q.add(v); //v has no prerequisites and added to the queue
            }
        }

        while(!Q.isEmpty()){
            v = Q.remove();
            sortedVertices.add(v);
            for(int i = 0; i < getNeighbors(v).size(); i++){ //go through every neighbor
                int currentNode = getNeighbors(v).get(i);
                count[currentNode]--; //increment count of inDegree
                if(count[currentNode] == 0){
                    Q.add(currentNode);
                }
            }
        }
        if(sortedVertices.size() != totalNodes){
            System.out.println("Solution Not Found.");
        } else{
            for (int i = 0; i < sortedVertices.size(); i++) {
                System.out.print(nodeList.get(sortedVertices.get(i)) + " ");
            }
        }
    }
    //------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------

    public void DFS(int v) {
        setVisited(v);
        LinkedList<Integer> neighbors = adjList.elementAt(v);
        for (int i = 0; i < neighbors.size(); i ++) {
            int v1 = neighbors.get(i);
            if (ifVisited(v1) == false) {
                DFS(v1);
            }
        }
    }

    public void BFS(int s) {
        ArrayList<Integer> toVisit = new ArrayList<Integer>();
        toVisit.add(s);
        while (toVisit.size() > 0) {
            int v = toVisit.remove(0);   // first-in, first-visit
            setVisited(v);
            LinkedList<Integer> neighbors = adjList.elementAt(v);
            for (int i = 0; i < neighbors.size(); i ++) {
                int v1 = neighbors.get(i);
                if ( (ifVisited(v1) == false) && (toVisit.contains(v1) == false) ) {
                    toVisit.add(v1);
                }
            }
        }
    }

    public void display() {
        System.out.println("total nodes: " + totalNodes);
        System.out.println("total edges: " + totalEdges);
    }

    public void displayEnum() {
        for (int i = 0; i < nodeEnum.size(); i ++) {
            System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
        }
        System.out.println();
    }
    public static void main(String argv[]) {
        AdjGraph g1 = new AdjGraph(true);
        String[] nodes1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        g1.setVertices(nodes1);
        g1.setEdge("A", "B", 10);
        g1.setEdge("A", "D", 20);
        g1.setEdge("A", "F", 2);
        g1.setEdge("B", "C", 3);
        g1.setEdge("B", "D", 5);
        g1.setEdge("C", "E", 15);
        g1.setEdge("E", "F", 3);
        g1.setEdge("E", "D", 11);
        g1.setEdge("F", "D", 10);
        g1.setEdge("F", "G", 20);
        g1.setEdge("F", "H", 6);
        g1.setEdge("H", "I", 9);
        g1.setEdge("H", "J", 2);
        g1.dijkstra1(1);
        System.out.println();
        //second example: g2
        AdjGraph g2 = new AdjGraph(true);
        String[] nodes2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        g2.setVertices(nodes2);
        g2.setEdge("a", "b", 9);
        g2.setEdge("a", "f", 5);
        g2.setEdge("a", "e", 3);
        g2.setEdge("b", "c", 5);
        g2.setEdge("b", "f", 4);
        g2.setEdge("c", "d", 2);
        g2.setEdge("c", "f", 8);
        g2.setEdge("d", "f", 7);
        g2.setEdge("d", "e", 1);
        g2.setEdge("e", "f", 5);
        g2.setEdge("f", "g", 3);
        g2.setEdge("g", "a", 2);
        g2.setEdge("g", "h", 1);
        g2.setEdge("g", "i", 12);
        g2.setEdge("g", "j", 8);
        g2.dijkstra1(0);
        System.out.println();
        //third example: g3
        AdjGraph g3 = new AdjGraph(true);
        String[] nodes3 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        g3.setVertices(nodes3);
        g3.setEdge("1", "3", 5);
        g3.setEdge("3", "4", 1);
        g3.setEdge("3", "1", 6);
        g3.setEdge("4", "2", 7);
        g3.setEdge("4", "10", 10);
        g3.setEdge("10", "5", 2);
        g3.setEdge("5", "6", 3);
        g3.dijkstra1(3);
        System.out.println();
        //11.14 from pdf
        AdjGraph g4 = new AdjGraph(true);
        //11.14 from the problemset
        String[] nodes4 = {"J1", "J2", "J3", "J4", "J5", "J6", "J7"};
        g4.setVertices(nodes4);
        g4.setEdge("J1", "J2", 5);
        g4.setEdge("J1", "J3", 1);
        g4.setEdge("J2", "J6", 6);
        g4.setEdge("J2", "J4", 7);
        g4.setEdge("J2", "J5", 10);
        g4.setEdge("J4", "J5", 2);
        g4.setEdge("J5", "J7", 3);
        g4.dijkstra1(3);
        System.out.println("Topological search: 4");
        g4.topologicalSortWithQueue();
        System.out.println();
        AdjGraph g5 = new AdjGraph(true);
        String[] nodes5 = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        g5.setVertices(nodes5);
        g5.setEdge("A", "C", 5);
        g5.setEdge("A", "B", 1);
        g5.setEdge("C", "G", 6);
        g5.setEdge("B", "C", 7);
        g5.setEdge("G", "H", 10);
        g5.setEdge("G", "I", 2);
        System.out.println("Topological search: 5");
        g5.topologicalSortWithQueue();
        System.out.println();
        AdjGraph g6 = new AdjGraph(true);
        String[] nodes6 = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        g6.setVertices(nodes6);
        g6.setEdge("A", "B", 5);
        g6.setEdge("B", "C", 1);
        g6.setEdge("B", "D", 6);
        g6.setEdge("C", "E", 7);
        g6.setEdge("E", "F", 10);
        g6.setEdge("E", "G", 2);
        g6.setEdge("E", "H", 2);
        g6.setEdge("E", "I", 2);
        System.out.println("Topological search: 6");
        g6.topologicalSortWithQueue();
    }
} // end of class AdjGraph