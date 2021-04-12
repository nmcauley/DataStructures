// C343 Fall 2020
//
// a simple implementation for graphs with adjacency lists

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;
import java.util.jar.JarOutputStream;

public class AdjGraph implements Graph {
    //tracks number of edges
    int[][] NofE;

    // is it a directed graph (true or false) :
    private boolean digraph;

    private int totalNodes;
    // all the nodes in the graph:
    private Vector<String> nodeList;

    private int totalEdges;
    // all the adjacency lists, one for each node in the graph:
    private Vector<LinkedList<Integer>>  adjList;

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
        visited = new Vector<Boolean>();
        nodeEnum = new Vector<Integer>();
        totalNodes = totalEdges = 0;
        //this needs to be set from false -> true
        digraph = true;
    }

    // set vertices:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i ++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes ++;
        }
    }

    // add a vertex:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
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


    // Problem Set 10 TODO:
    public void componentsAndSizes(){
        int componentCount = 0;
        for(int i = 0; i < nodeList.size(); i++){
            if(!ifVisited(i)){
//                System.out.println("Current: " +nodeList.get(i));
                DFS(getNode(nodeList.get(i)));
                componentCount++;
            }
        }
        System.out.println("Total components: " + componentCount);
    }
    public void DFS(int v) {
        setVisited(v);
        LinkedList<Integer> neighbors = adjList.elementAt(v);

        int nodeCounter = 0;
        for (int i = 0; i < neighbors.size(); i ++) {
            int v1 = neighbors.get(i);
            if (ifVisited(v1) == false) {
                DFS(v1);
                nodeCounter++;
//                System.out.println("Component " + i +" contains " + nodeCounter + " nodes.");
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

    public void floydNoWeights(){
        // V x V matrix
        NofE = new int[totalNodes][totalNodes];

        //Start with all values at Integer.MAX_VALUE
        for(int[] i : NofE){
            for(int j = 0; j < i.length; j++){
                    i[j] = Integer.MAX_VALUE;
            }
        }
        // set all counters to 0 where we know they are 0: A,A B,B C,C etc...
        for (int i = 0; i < totalNodes; i++){
            NofE[i][i] = 0;
        }
        //now we assign our edge cases
        for(int i = 0; i < adjList.size(); i++){
            //obtain each index and see if they have any edges
            LinkedList<Integer> current = adjList.get(i);

            //now we add 1 to NofE if there are any edges in current. if so then that location can be obtained by get() retrieving the index
            //for the edge in adjList
            for(int j = 0; j < current.size(); j++) {
                int location = current.get(j);
                NofE[i][location] = 1;
            }
        }

        for (int k = 0; k < totalNodes; k++){
            for(int i = 0; i < totalNodes; i++){
                for (int j = 0; j < totalNodes; j++){
                    if(NofE[i][j] > NofE[i][k] + NofE[k][j] && NofE[i][k] != Integer.MAX_VALUE && NofE[k][j] != Integer.MAX_VALUE){
                        NofE[i][j] = NofE[i][k] + NofE[k][j];
                    }
                }
            }
        }
        printResults(NofE);
    }

    private void printResults(int[][] results) {
        System.out.println("Results for the shortest path matrix: ");
        System.out.println("  "+nodeList.toString());
        int count = 0;
        for(int[] i : results){
            System.out.print(nodeList.get(count) + " ");
            count++;
            for(int j = 0; j < i.length; j++) {
                if(i[j] == Integer.MAX_VALUE){
                    System.out.print(" _ ");
                } else
                    System.out.print(" " + i[j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args){
        AdjGraph g1 = new AdjGraph();
        String[] vertices = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        g1.setVertices(vertices);
        // A -> B
        g1.setEdge(0, 1, 0);
        // A -> C
        g1.setEdge(0, 2, 0);
        // D -> E
        g1.setEdge(3, 4, 0);
        // F -> G
        g1.setEdge(5, 6, 0);
        // G -> H
        g1.setEdge(6, 7, 0);
        // H -> I
        g1.setEdge(7, 8, 0);
        // I -> J
        g1.setEdge(8, 9, 0);
        g1.display();
//        g1.walk("DFS");
        //EXPECTED: 3 components; 3 nodes, 2 nodes, 5 nodes
//        g1.componentsAndSizes();
        g1.floydNoWeights();
        System.out.println();



        AdjGraph g2 = new AdjGraph();
        String[] vertices2 = {"A", "B", "C", "D", "E"};
        g2.setVertices(vertices2);
        // A -> B
        g2.setEdge(0, 1, 0);
        // A -> C
        g2.setEdge(0, 2, 0);
        // A -> D
        g2.setEdge(0, 3, 0);
        // E -> B
        g2.setEdge(4, 1, 0);
        // B -> C
        g2.setEdge(1, 2, 0);
        // D -> B
        g2.setEdge(3, 1, 0);
        // C -> E
        g2.setEdge(2, 4, 0);
        // D -> A
        g2.setEdge(3, 0, 0);
        g2.display();
//        g2.walk("DFS");
        //EXPECTED: 1 component; 10 nodes
//        g2.componentsAndSizes();
        g2.floydNoWeights();
        System.out.println();

        AdjGraph g3 = new AdjGraph();
        g3.setVertices(vertices);
        // C -> E
        g3.setEdge(2, 4, 0);
        // E -> C
        g3.setEdge(4, 2, 0);
        // D -> A
        g3.setEdge(5, 0, 0);
        // B -> C
        g3.setEdge(1, 2, 0);
        // A -> F
        g3.setEdge(0, 5, 0);
        // H -> J
        g3.setEdge(7, 9, 0);
        // H -> I
        g3.setEdge(7, 8, 0);
        g3.display();
//        g3.walk("DFS");
        //EXPECTED: 10 components; 1 node x10.
//        g3.componentsAndSizes();
        g3.floydNoWeights();
    }

    // Provide 3 different graph examples,
    //   with at least 10 nodes for each different graph,
    //   following these steps 1) ... 4) for each graph:

    // 1) instantiate a new graph,
    // 2) assign2 vertices and edges to the graph,
    // 3) then display2 the graph's content (use display() )
    // 4) finally call your componentsAndSizes() method to provide
    //    output results as from Problem Set 10 instructions


} // end of class AdjGraph