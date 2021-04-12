import org.w3c.dom.Node;

public class BSTJr <K extends Comparable<?super K>> {
    BinNode<K> root;
    BinNode<K> curr;
    int count = 0; // for kth smallest

    // TODO for C343/Fall 2020 - Lab 05 part A
    // "unbalanced" is used for balance checking:
    //    if a node is unbalanced, the tree will be unbalanced
    BinNode<K> unbalanced = null;

    public BSTJr() {
        root = null;
        curr = null;
    }
    public void build(K[] ks) {
        for (int i = 0; i < ks.length; i ++)
            insert(ks[i]);
    }
    public void insert(K k) {
        BinNode<K> t = new BinNode<K>(k);
        if (root == null) {
            root = curr = t;
        } else {
            curr = search(root, k);
            if (k.compareTo(curr.getKey()) < 0)
                curr.setLeft(t);
            else
                curr.setRight(t);
        }
    }
    public BinNode<K> search(BinNode<K> entry, K k) {
        if (entry == null)
            return null;
        else {
            entry.setSize(entry.getSize() + 1); //update the size of the subtree by one
            if (entry.isLeaf())
                return entry;
            if (k.compareTo(entry.getKey()) < 0) {
                /*  bug in original version: if (k.compareTo(curr.getKey()) < 0) {  */
                if (entry.getLeft() != null)
                    return search(entry.getLeft(), k);
                else
                    return entry;
            } else {
                if (entry.getRight() != null)
                    return search(entry.getRight(), k);
                else
                    return entry;
            }
        }
    }
    public void display() {
        if (root == null) return;
        System.out.println("Preorder enumeration: key(size-of-the-subtree)");
        preorder(root);
        System.out.println();

        System.out.println("Inorder enumeration: key(size-of-the-subtree)");
        inorder(root);
        System.out.println();

        System.out.println("Postorder enumeration: key(size-of-the-subtree)");
        postorder(root);
        System.out.println();


    }

    // bottom-up recursion on left subtree, right subtree, and then finally the root.
    private void postorder(BinNode<K> entry) {
        if(entry == null){
            return;
        }
        postorder(entry.getLeft());
        postorder(entry.getRight());
        System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
    }

    // prints left subtree, root, then the right subtree
    public void inorder(BinNode<K> entry) {
        if(entry == null){
            return;
        }
        inorder(entry.getLeft());
        System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");

        //recurs to the right
        inorder(entry.getRight());
    }


    //prints entry then recurs on the left and then right subtrees
    public void preorder(BinNode<K> entry) {
        System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
        if (entry.getLeft() != null) preorder(entry.getLeft());
        if (entry.getRight() != null) preorder(entry.getRight());
    }

    public BinNode findKthSmallest(BinNode<K> entry, int k){
        BinNode[] array = new BinNode[root.getSize()]; // for kth smallest
        if(entry == null){
            return null;
        }
        if(entry.getLeft() != null) {
            findKthSmallest(entry.getLeft(), k);
            array[count] = entry;
            count++;
        }
        findKthSmallest(entry.getRight(), k);

        return array[k];
    }


    // TODO for C343/Fall 2020 - Lab 05 part A
    // implement checkBalance(),
    // and you may write treeHeight(node) as helper function
    // empty trees are balanced
    public boolean checkBalance(){
        if(this.root == null){
            return true;
        }
        if(this.root.getRight() != null && this.root.getLeft() != null) {
            int difference = this.root.getLeft().getSize() - this.root.getRight().getSize();
            if (difference < 1) {
                return false;
            } else return true;
        }
        else return false;
    }



    public static void main(String[] argv) {
        BSTJr<Integer> tree = new BSTJr<Integer>();
        BSTJr<Integer> tree2 = new BSTJr<Integer>();
        BSTJr<Integer> tree3 = new BSTJr<Integer>();
        BSTJr<Integer> tree4 = new BSTJr<>();
        Integer[] ks = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11};
        System.out.println("Tree 1:");
        tree.build(ks);
        tree.display();
        System.out.println("is the tree balanced? " + tree.checkBalance() + "\n");

        System.out.println("Tree 2:");
        Integer[] array2 = {15, 2, 4, 5, 29, 42};
        tree2.build(array2);
        tree2.display();
        System.out.println("return 3rd smallest: " + tree2.findKthSmallest(tree2.root, 2));
        System.out.println("Is tree 2 balanced? " + tree2.checkBalance()+ "\n");

        System.out.println("Tree 3:");
        Integer[] array3 = {22, 12, 8, 41, 2, 5, 9, 60, 532,};
        tree3.build(array3);
        tree3.display();
        System.out.println("return 5th smallest: " + tree2.findKthSmallest(tree2.root, 5));
        System.out.println("Is tree 3 balanced? " + tree3.checkBalance());

        System.out.println("\nTree 4 (null): ");
        tree4.display();
        System.out.println("Is tree 4 balanced? " + tree4.checkBalance());
    }
}