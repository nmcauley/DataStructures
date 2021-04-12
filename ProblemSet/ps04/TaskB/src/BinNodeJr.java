public class BinNodeJr <E extends Comparable<?super E>>{
    private E value;
    private BinNodeJr<E> left;
    private BinNodeJr<E> right;

    public BinNodeJr(E e) {
        this.value = e;
        this.left = this.right = null;
    }

    public void setLeft(BinNodeJr<E> node) {
        left = node;
    }

    public void setRight(BinNodeJr<E> node) {
        right = node;
    }

    public boolean find(E q) {
        if(this.value.compareTo(q) == 0){
            return true;
        }
        if(this.left == null && this.right != null){
            return this.right.find(q);
        }
        else if(this.left != null && this.right == null){
            return this.left.find(q);
        }
        else if((this.left == null && this.right == null)){
            return false;
        }
        else return this.left.find(q) || this.right.find(q);
    }

    public static void main(String[] args) {
        BinNodeJr<Integer> root = new BinNodeJr<Integer>(8);
        BinNodeJr<Integer> node1 = new BinNodeJr<Integer>(28);
        BinNodeJr<Integer> node2 = new BinNodeJr<Integer>(38);
        BinNodeJr<Integer> node3 = new BinNodeJr<Integer>(40);
        BinNodeJr<Integer> node4 = new BinNodeJr<Integer>(9);
        BinNodeJr<Integer> node5 = new BinNodeJr<Integer>(77);
        BinNodeJr<Integer> node6 = new BinNodeJr<Integer>(3);
        BinNodeJr<Integer> node7 = new BinNodeJr<Integer>(21);
        BinNodeJr<Integer> node8 = new BinNodeJr<Integer>(16);
        BinNodeJr<Integer> node9 = new BinNodeJr<Integer>(674);

        // root
        root.setLeft(node1);
        root.setRight(node2);

        //node 1 - left of root
        node1.setLeft(node3);

        // node 3 - left of 1
        node3.setRight(node7);
        node3.setLeft(node8);

        // node 2 - right of root
        node2.setRight(node4);
        node2.setLeft(node5);

        //node 4 - right of 2
        node4.setRight(node6);
        node4.setLeft(node9);

        // find() needs to be implemented
        System.out.println("is 21 found in the tree: " + root.find(21));
        // find(38) should return true
        System.out.println("is 200 found in the tree: " + root.find(200));
        // find(100) should return false

        // should return false since we are checking from a smaller subtree
        System.out.println("is 8 in the tree (starting from node1): " + node1.find(8));
        System.out.println("is 40 in the tree (starting from node1): " + node1.find(40));

        //Should be false
        System.out.println("is 16 in the tree (starting from node2): " + node2.find(16));

        //Should be true
        System.out.println("is 16 in the tree (starting from node3): " + node3.find(16));
    }
}