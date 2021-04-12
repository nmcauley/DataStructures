import java.lang.reflect.Array;
import java.util.*;

public class HuffTree<Key, E> {
    private MinHeap<Integer, String> heap;        // heap for building the tree
    private BinNode<Integer, String> root;        // root for traversal
    private Dictionary<String, String> codeTable; // huffman letter<->code table
    private Dictionary<String, Integer> codeFreq; // huffman letter<->frequency table

    //contains array of result arrays [0] is the key and [1] is the huffman code for
    //all values of the tree
    private ArrayList<String[][]> huffmanResults;

    public HuffTree(String letters, int[] weights) {
        init(letters, weights);
        buildTree();
        codeTable = new Hashtable<String, String>();
        buildCodeTable();
        summary();
    }

    private void init(String letters, int[] weights) {
        codeFreq = new Hashtable<String, Integer>();
        for(int i = 0; i < letters.length(); i ++)
            codeFreq.put(letters.substring(i, i + 1), weights[i]);
        int maxNum = letters.length();
        // BinNode<Integer, String>[] nodes = (BinNode<Integer, String>[]) new Object[maxNum];
        @SuppressWarnings("unchecked")
        BinNode<Integer, String>[] nodes = new BinNode[maxNum];
        for(int i = 0; i < maxNum; i ++) {
            nodes[i] = new BinNode<Integer, String>(weights[i], letters.substring(i, i + 1));
        }
        heap = new MinHeap<Integer, String>(maxNum, maxNum, nodes);
        heap.display();
    }
    private void buildTree() {
        while(heap.length() > 1) {
            BinNode<Integer, String> node1 = heap.removeMin();
            BinNode<Integer, String> node2 = heap.removeMin();
            BinNode<Integer, String> newnode = new BinNode<Integer, String>(node1.getKey() + node2.getKey(), " ");
            newnode.setLeft(node1);
            newnode.setRight(node2);
            heap.insert(newnode);
            heap.display();
        }
        root = heap.removeMin();
        System.out.println("Huffman tree built. Root weight = " + root.getKey());
    }
    public void summary() {
        if (codeTable.isEmpty()) {
            System.out.println("Summary can't be provided. The Huffman Code Table is empty!");
            return;
        }
        // display the code & compute the sum of weighted path lengths
        Enumeration<String> keys = codeFreq.keys();
        int sumOfWeightedPath = 0;
        while(keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println("Letter: " + key + " " + codeTable.get(key));
            sumOfWeightedPath += codeTable.get(key).length() * codeFreq.get(key);
        }
        System.out.println("Total letters: " + root.getKey());
        System.out.println("Sum of weighted path lengths: " + sumOfWeightedPath);
        System.out.println("Average code length: " + sumOfWeightedPath * 1.0 / root.getKey());
    }

    // recursively calls getPath and then accesses it through huffmanResults
    private void buildCodeTable() {
        huffmanResults = new ArrayList<>();
        // by calling this we will now how an array containing all of the leaves and codes
        getPath(this.root, "");

        // first value is key and the second is the code and we can then iterate through and add
        // it to the dictionary
        for(String[][] results : huffmanResults){
            codeTable.put(results[0][0], results[0][1]);
        }

    }

    // key part here is to not overly complicate and simply add 0 to path as we move left
    // and add 1 as we traverse right until reaching a leaf and storing path and code into array
    private void getPath(BinNode node, String path){
        if(node.isLeaf()){
            String[][] result = new String[1][2];
            result[0][0] = (String) node.getValue();
            result[0][1] = path;
            huffmanResults.add(result);
            //testing code to see if the results are properly accepted
//            System.out.println(huffmanResults.size());
//            System.out.println(node.getValue() + ":" + path);
        }
        else{
            //left path
            getPath(node.getLeft() ,path + "0" );
            //right path
            getPath(node.getRight() , path + "1");
        }
    }

    // function 2: encode a message
    public String encode(String inStr) {
        if (codeTable.isEmpty()) { System.out.println("Encoding not possible. Huffman Code Table empty!"); return ""; }
        String outCode = "";
        for(int i = 0; i < inStr.length(); i ++) {
            String letter = inStr.substring(i, i+1);
            // here we use the codeTable built by buildCodeTable()
            outCode += codeTable.get(letter);
        }
        return outCode;
    }
    // function 3: decode a message
    public String decode(String inCode) {
        String outStr = "";
        BinNode<Integer, String> currentNode = root;
        if (currentNode.isLeaf()) { System.out.println("Decoding not possible. Huffman Tree empty!"); return ""; }
         System.out.println("about to decode the Huffman code: " + inCode);
         System.out.println("using the tree: " + root.inorder());
         //iterate through the string
         for(int i = 0 ; i < inCode.length(); i++){
             //left
             if(inCode.charAt(i) == '0'){
                 currentNode = currentNode.getLeft();
             }
             else{
                 //right
                 currentNode = currentNode.getRight();
             }
             // reached leaf
             if(currentNode.isLeaf()){
                 outStr = outStr + currentNode.getValue();
                 //reset
                 currentNode = root;
             }
         }
        return outStr;
    }
    public static void main(String[] argv) {
        int[] weights = {2, 7, 24, 32, 37, 42, 42, 120};
        String letters = "ZKMCDLUE";
        HuffTree<Integer, String> tree = new HuffTree<Integer, String>(letters, weights);
        System.out.println("DEED" + " encoded as " + tree.encode("DEED"));
        System.out.println("0110111111011001110111101" + " decodes into " + tree.decode("0110111111011001110111101"));

//        for(String[][] results : tree.huffmanResults){
//            System.out.println("for loop "+results[0][0] + results[0][1] +"\n # of results " + tree.huffmanResults.size());
//
//        }
    }
}