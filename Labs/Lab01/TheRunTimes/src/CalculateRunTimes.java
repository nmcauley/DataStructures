class CalculateRunTimes {

    int countInstructions(int n) {
        // for example 1:
        int instructioncounter = 0;
        int i = 0;
        instructioncounter++;
        int j = 0;
        instructioncounter++;
        int sum1 = 0;
        instructioncounter++;
        for (i = 1, instructioncounter++; i <= n; i++) {
            sum1++;
            instructioncounter++;
        }
        return instructioncounter;
    }

    int countInstructions7(int n) {
        // for example 7:
        int instructionCounter = 0;
        int m = n;
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[][] d = new int[n + 1][n + 1];
        int i, j;
        d[0][0] = 0;
        int c;

        instructionCounter+= 8;
        for (i = 1, instructionCounter++; i <= m; i++) {
            for (j = 1, instructionCounter++; j <= n; j++) {
                instructionCounter++;
                if (a[i] == b[j]) {
                    c = 0;
                } else {
                    c = 1;
                }
                d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), d[i - 1][j - 1] + c);
                instructionCounter++;
            }
        }
        return instructionCounter;
    }

}

class TheRunTimes{
        public static void main(String[] args){
            CalculateRunTimes runtimes = new CalculateRunTimes();
            for(int i = 10; i <= 10000; i *= 10){
                System.out.println("in Example 1, for size " + i + ", instructioncounter is: " + runtimes.countInstructions(i));
                System.out.println("(instructioncounter / n) = " + runtimes.countInstructions(i) / i);
            }

            System.out.println();
            for(int i = 10; i <= 10000; i *= 10){
                System.out.println("in Example 7, for size " + i + ", instructioncounter is: " + runtimes.countInstructions7(i));
                System.out.println("(instructioncounter / n) = " + runtimes.countInstructions7(i) / i);
            }
        }
}

