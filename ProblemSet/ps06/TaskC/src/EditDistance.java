import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class EditDistance {

    public int editDistance(String s1, String s2) {
        long lTimeBefore = System.nanoTime();
        int distance;
        int c;
        // initialize table:
        int[][] table = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            table[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            table[0][j] = j;
        }
// fill the "Dynamic Programming" table
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                //checks if equal
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    c = 0;
                } else {
                    //replace
                    c = 1;
                }
                int min = Math.min(table[i - 1][j] + 1, table[i][j - 1] + 1);
                min = Math.min(min, table[i - 1][j - 1] + c);
                table[i][j] = min;
            }
        }
        distance = table[s1.length()][s2.length()];
        long lTimeAfter = System.nanoTime();
        long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
        System.out.println("Runtime: " + lElapsedNanoSeconds + " nanoseconds");
        return distance;
    }

    int hammingDistance(String s1, String s2){
        long lTimeBefore = System.nanoTime();
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        }
        long lTimeAfter = System.nanoTime();
        long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
        System.out.println("Runtime: " + lElapsedNanoSeconds + " nanoseconds");
        return count;
    }


    public String generateDNA(int length) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        String dna = "";
        for(int i = 0; i < length; i++) {
            dna = dna +letters.charAt(random.nextInt(letters.length()));
        }
        return dna;
    }

    public static void main(String[] arg) throws Exception {
        File file1 = new File("flatland01.txt");
        File file2 = new File("flatland02.txt");
        String book1 = "";
        String book2 = "";
        Scanner sc1 = new Scanner(file1);
        while (sc1.hasNextLine()){
            book1 = book1 + sc1.nextLine();
        }
        Scanner sc2 = new Scanner(file2);
        while (sc2.hasNextLine()){
            book2 = book2 + sc2.nextLine();
        }
         EditDistance ed = new EditDistance();

        System.out.println("book1 length " + book1.length());
        System.out.println("book2 length " + book2.length());
        System.out.println("Edit distance for texts: " + ed.editDistance(book1, book2));
        System.out.println("Hamming distance for texts: " + ed.hammingDistance(book1, book2));
        String s1 = ed.generateDNA(6);
        System.out.println("\nString 1: "+s1);
        String s2 = ed.generateDNA(6);
        System.out.println("String 2: "+s2);
        System.out.println("Hamming distance : " + ed.hammingDistance(s1,s2));
        System.out.println("edit distance : " + ed.editDistance(s1,s2));


        // infinite loop
//        int i = 4;
//            while(true) {
//                String s1 = ed.generateDNA(i);
//                String s2 = ed.generateDNA(i);
//
//                ed.editDistance(s1, s2);
//                ed.hammingDistance(s1, s2);
//                i *= 2;
//            }
    }
}