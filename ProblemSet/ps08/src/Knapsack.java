public class Knapsack {

    public boolean recursiveKnapsackSubsetSum(int[] arr, int kSum) {
        int size = arr.length;
        if (size == 0) {
            return false;
        }
        //checks if there is only one element --> if that equals our kSum
        if (size == 1) {
            return (arr[0] == kSum);
        }
        // now call helper at the starting index (0)
        return recursiveHelper(arr, 0, kSum);
    }


    static boolean recursiveHelper(int[] arr, int start, int kSum){
        int size = arr.length;
        //we have found our subset
        if(kSum == 0){
            return true;
        }
        //if this is our only element left
        if((size - start) == 1){
            return (arr[start] == kSum);
        }

        //grabs our element
        int element =  arr[start];

        // checks if there is the solution by either including the current index or by rejecting it
        //include --> kSum - first number
        //reject --> kSum
        return (recursiveHelper(arr, start + 1,kSum - element)
                || recursiveHelper(arr, start + 1, kSum));
    }

    // Dynamic Programming
    public boolean dynamicKnapsackSubsetSum(int[] arr, int kSum){
        int size = arr.length;

        //array for memoization +1 length for both the sum and the array values for the result
        //at memo[i][j]
        boolean[][] memo = new boolean[size + 1][ kSum + 1];
        //initialize array values in memo
        for(int i = 0; i <= size; i++){
            memo[i][0] = true;
        }

        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= kSum; j++){
                //same as recursive with either implementing or rejecting the current element
                //check to see if our current element is larger than kSum (if so replaces with previous memo)
                if(arr[i - 1] > j){
                    memo[i][j] = memo[i - 1][j];
                    //this is the substitute for recursion in which we retrieve our previous kSum
                } else{
                    //setting our result
                    memo[i][j] = (memo[i - 1][j] || memo[i - 1][j - arr[i - 1]]);
                }
            }
        }
        //last index to see end result;
        return memo[size][kSum];
    }


    public static void main(String[] args){
        Knapsack knapsack = new Knapsack();
        int kSum = 5;
        int[] test1 = {1, 4, 5}, test2 = {3, 4}, test3 = {10, 1, 2, 3};
        System.out.println("Recursive Testing with kSum: " + kSum);
        System.out.println("Test 1: " + knapsack.recursiveKnapsackSubsetSum(test1, kSum));
        System.out.println("Test 2: " + knapsack.recursiveKnapsackSubsetSum(test2, kSum));
        System.out.println("Test 3: " + knapsack.recursiveKnapsackSubsetSum(test3, kSum));

        System.out.println("\nDynamic Testing with kSum: " + kSum);
        System.out.println("Test 1: " + knapsack.dynamicKnapsackSubsetSum(test1, kSum));
        System.out.println("Test 2: " + knapsack.dynamicKnapsackSubsetSum(test2, kSum));
        System.out.println("Test 3: " + knapsack.dynamicKnapsackSubsetSum(test3, kSum));
    }
}
