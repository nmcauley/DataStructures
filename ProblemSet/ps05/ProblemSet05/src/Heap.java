public class Heap{

    /** store the elements in an array, listArray */
    private int[] listArray;
    private int listSize;
    private int maxSize;

    Heap(int max, int lsize, int[] array) {
        maxSize = max;
        listSize = lsize;
        listArray = array;
        heapify();
    }

    public void heapify() {
        for(int i = listSize/2 - 1; i >= 0; i --) {
            siftDown(i);
        }
    }

    public void insert(int inp) {
        assert listSize < maxSize : "exceed maxSize " + maxSize;
        listArray[listSize ++] = inp;
        /** sift up the newly added node if it is greater than its ancestors */
        siftUp(listSize - 1);
    }

    public int removeMax() {
        return remove(0);
    }

    public int remove(int pos) {
        assert (pos >= 0) && (pos < listSize) : "Illegal remove";
        if(pos == listSize -1) listSize --;
        else {
            /** swap the max (at position 0) with the last one, then remove the last one */
            swapNodes(pos, --listSize);
            /** call siftUp() & siftDown() to restore the heap */
            if(pos > 0) siftUp(pos);
            if(!isLeaf(pos)) siftDown(pos);
        }
        return listArray[listSize];
    }

    public void siftDown(int pos) {
        assert (pos >= 0) && (pos < listSize) : "Illegal heap position";
        /** System.out.println("now work on " + pos); */
        while(!isLeaf(pos)) {
            int i = left(pos);
            /** if the right child is greater than the left child, use the right child */
            if((i < listSize - 1) && (listArray[i] < listArray[i + 1])) i ++;
            if(listArray[i] > listArray[pos]) {
                swapNodes(i, pos);
            }
            pos = i;
        }
    }

    public void siftUp(int pos) {
        while(pos > 0) {
            int p = parent(pos);
            if(listArray[pos] > listArray[p]) {
                swapNodes(p, pos);
            }
            pos = p;
        }
    }

    public void swapNodes(int i, int j) {
        int tmp = listArray[i];
        listArray[i] = listArray[j];
        listArray[j] = tmp;
    }

    public boolean isLeaf(int pos) {
        if(pos < listSize/2) return false;
        else return true;
    }

    public int left(int pos) {
        assert 2 * pos + 1 < listSize : "left child is empty";
        return 2 * pos + 1;
    }

    public int right(int pos) {
        assert 2 * pos + 2 < listSize : "right child is empty";
        return 2 * pos + 2;
    }

    public int parent(int pos) {
        assert pos > 0 : "the node is already a root";
        return (int) Math.floor((pos - 1) / 2);
    }

    public void display() {
        String output = "[HeapSize: " + listSize + "] ";
        for(int i = 0; i < listSize; i ++) output += " " + listArray[i];
        System.out.println(output);
    }

    /** sort the entire heap */
    public void heapsort() { heapsort(listSize); }

    /** only the k largest numbers will be placed at the end of the heap */
    public void heapsort(int k) {
        int listSizeOld = listSize;
        if(k > listSize) k = listSize;
        for(int i = 0; i < k; i ++) {
            removeMax();
            //display();
        }
        listSize = listSizeOld;
    }


}
