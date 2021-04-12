import java.util.Objects;
import java.util.Random;
import static java.lang.System.out;

public class RandomChunkOfDNA {
    // generate a random DNA sequence of length n:
    public String nextDNA(int n) {
        String lDNA = "";
        Random lRandomizer = new Random();

        for (int i = 0; i < n; i++) {
            int j = lRandomizer.nextInt(4);
            if (j == 0) lDNA += "A";
            else if (j == 1) lDNA += "T";
            else if (j == 2) lDNA += "C";
            else if (j == 3) lDNA += "G";
        }
        return lDNA;
    }

}

class HammingDNADistance{
    public static void main(String[] args) {
        RandomChunkOfDNA rndDNAGenerator = new RandomChunkOfDNA();
        String dna1;
        String dna2;
        for (int i = 10; i<=10000; i *= 10) {
            out.println("");
            dna1 = rndDNAGenerator.nextDNA(i);
            dna2 = rndDNAGenerator.nextDNA(i);
            out.println("The two DNA sequences " + i + " characters long: " + dna1 + ", " + dna2);
            out.println("Hamming count: " + computeHam(dna1, dna2));
        }
    }
    static int computeHam(String dna1, String dna2){
        int hamming = 0;
        for(int j = 0; j < dna1.length(); j++){
            if(dna1.charAt(j) == dna2.charAt(j)){
                continue;
            }
            else hamming++;
        }
        return hamming;
    }
}