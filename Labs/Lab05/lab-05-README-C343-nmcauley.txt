C343/Fall 2020
LabTask-05
09/25/2020 09:17
Nolan Cauley nmcauley


TASK A:

For checking the balance of the bst it is relatively simple to follow the rules of a balanced tree. This is as follows:
If the tree is null then it is balanced.
If the difference between the height of the roots subtrees are greater than 1 then the tree is not balanced. Otherwise it is.

For implementation the if statements follow this layout and the key here is to check whether the root has a left and right subtree. If it does then using the .getSize() methods we find the difference between the two subtrees; if less then one returns false and else, true.
If this is not the case then checkBalance() returns false.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK B:

So this process relied heavily on the "trust the process" mindset.
By basing off of the preorder traversal that was already implemented I simply adapted air for the other traversals and instead of display() only printing the preorder traversal it now prints all three.

The techniques are as follows:
postorder() - for a postorder traversal we need to start from the bottom to the top of the left subtree, followed by the right subtree until finally printing the root's node.
So after checking if the node is null it recursively calls on the left subtree, then the right with the action being performed is printing the node.

inorder() - The difference between preorder and ignorer is that instead of printing the subtrees first we print the left subtree, the root and then the right subtree. 
For implementation it is the same but now we recursively call the on the left of the entry with a print statement before the right recursion.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK C:

For finding the k-th smallest value my initial instinct is to check if the node is null then we should return null instead of 0 so not to confuse the count we will be keeping of the smallest numbers. 
No matter what we will have to traverse the entirety of the tree to see if we have the k-th smallest so I plant to to an inorder traversal to hopefully be able to traverse as quickly as possible

findKthSmallest(int k){
Int count;

If(this == null) - > Return null

Else this.left.findKthSmallest(k)

}


This was my original thought process until I researched the problem and found a different process on https://www.techiedelight.com/find-kth-smallest-largest-element-bst/ that details a completely new approach that is similar in essence but not exactly what I was gonna do. 

For this implementation they also say to do an inorder sort since that places everything in ascending order but the difference is that they say to place the values in an array and keep count until you reach the specified index.


But the weird part is the specification that the algorithm must check every single node in the tree? Is that not efficient if we know that if we sort it inorder then we can act accordingly?

I am going to go for the route of implementing into an array (all the elements for the sake of "Make sure that your algorithm checks every single node in the tree!")

BinNode[] array;

If entry == null -> return null

If left != null -> findkthSmallest(left)
While also adding an updated count that acts as a key to place into the array.

Return array[k];


I over complicated and confused myself now.


