C343/Fall 2020
ProblemSet-08
10/20/2020 00:49
Nolan Cauley nmcauley

TASK B:

recursiveKnapsackSubsetSum(int[] arr, int kSum)
Goal for this function is to check the initial size of the input array and upon doing so we reach the following:

If the array.length == 0 then we automatically return false
If there is only one element in the array we check to see if that element is equal to the sum since there are no possible subsets.

Otherwise we call upon our helper method to naively check.

recursiveHelper(int[] arr, int start, int kSum)
The key part about this function is the way we keep track of the index we are implementing or rejecting. This will be further illuminating in the recursion explanation.

Covering our base cases kSum == 0 means we found our subset and automatically result to a true result.
Otherwise, we check to see if our start is the only element left in our array and this is possible by subtracting the index by the length of the array. If it equals 1 we check if the element equals the sum much like in our earlier method.

Now we begin by grabbing the int value at our start index and then recursively call 
checks if there is the solution by either including the current index or by rejecting it
        include --> kSum - first number
        reject --> kSum

Returns true if at least one of the calls returns true.

Thus we achieve an exponential time complexity

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK C:
public boolean dynamicKnapsackSubsetSum(int[] arr, int kSum)
For memoizing our table (memo[][]) we iterate through the 0 column and set the values as true since they are representing the element's values

Now we loop through in order to check if the current element is greater than the sum 
same as recursive with either implementing or rejecting the current element
check to see if our current element is larger than kSum 
(if so replaces with previous memo)
This is arr[i - 1] > j

Else we do the same as the above method and check the result depending on keeping the element or upon keeping it.

Now we retrieve our result in the element
memo[arr.length][ksum]

Thus we achieve a polynomial time complexity




