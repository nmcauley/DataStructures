
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

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
//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------
    public int primMST() {
        //Initialize
        int cost = 0; //initial cost is 0; MST is empty
        int[] dist = new int[totalNodes];
        ArrayList<Integer> unvisited = new ArrayList<>();
        for (int i = 0; i < totalNodes; i++) { unvisited.add(i);} //vertices not yet in the MST
        // Prim's algorithm can start from any node; here 0 is used as the source
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        System.out.println("Traversal:");
        while(!unvisited.isEmpty()) {
            int u = findMinVert(unvisited, dist);
            //remove u from unvisited and add u's dist to cost variable
            unvisited.remove(unvisited.indexOf(u));
            System.out.println("removed: " + nodeList.get(u) + " cost: " + dist[u]);
            cost += dist[u];

            //update dist[v] for every neighbor of u
            LinkedList<Integer> neighbors = getNeighbors(u);
            //search among the neighbors for unvisited ones
            for(int i = 0; i < neighbors.size(); i++){
                //current neighbor
                int v = neighbors.get(i);
                dist[v] = primRelax(dist[v], getWeight(u, v)); //relax
            }
        }
        return cost;
    }
    public int primRelax(int v, int weight){
        // relaxation operation:
        if (weight < v ){ v = weight; }
        //    weight(u, v) is the weight of the edge from u to v
        // note - the update of the distance is different from Dijkstra's algorithm
        return v;
    }

    //find vertex u with the smallest dist[u] among all unsettled vertices (S).
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
//---------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------

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
        AdjGraph g1 = new AdjGraph(false);
        String[] nodes1 = {"A", "B", "C", "D", "E", "F"};
        g1.setVertices(nodes1);
        g1.setEdge("A", "B", 1);
        g1.setEdge("A", "D", 3);
        g1.setEdge("B", "D", 5);
        g1.setEdge("B", "E", 1);
        g1.setEdge("B", "C", 6);
        g1.setEdge("E", "D", 1);
        g1.setEdge("E", "F", 4);
        g1.setEdge("E", "C", 5);
        g1.setEdge("F", "C", 2);
        g1.setEdge("F", "B", 8);
        System.out.println("MST cost for graph 1:\nExpected = 9 \nActual = " + g1.primMST() + "\n");

        //second example: g2
        AdjGraph g2 = new AdjGraph(false);
        String[] nodes2 = {"a", "b", "c", "d", "e"};
        g2.setVertices(nodes2);
        g2.setEdge("a", "b", 2);
        g2.setEdge("a", "c", 3);
        g2.setEdge("a", "d", 10);
        g2.setEdge("a", "e", 5);
        g2.setEdge("b", "c", 4);
        g2.setEdge("b", "d", 1);
        g2.setEdge("b", "e", 8);
        g2.setEdge("c", "d", 6);
        g2.setEdge("c", "e", 2);
        g2.setEdge("d", "e", 14);
        System.out.println("MST cost for graph 2:\nExpected = 8 \nActual = " + g2.primMST()  + "\n");

        //second example: g3
        AdjGraph g3 = new AdjGraph(false);
        String[] nodes3 = {"1", "2", "3", "4", "5", "6"};
        g3.setVertices(nodes3);
        g3.setEdge("1", "2", 2);
        g3.setEdge("1", "4", 1);
        g3.setEdge("1", "5", 4);
        g3.setEdge("2", "3", 3);
        g3.setEdge("2", "6", 7);
        g3.setEdge("4", "5", 8);
        g3.setEdge("4", "3", 5);
        g3.setEdge("3", "6", 12);
        g3.setEdge("3", "1", 9);
        g3.setEdge("4", "2", 11);
        System.out.println("MST cost for graph 3:\nExpected = 17 \nActual = " + g3.primMST()  + "\n");
    }
}