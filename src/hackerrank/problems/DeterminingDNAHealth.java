package hackerrank.problems;

import java.util.Arrays;

public class DeterminingDNAHealth implements Problem {
    public DeterminingDNAHealth() {
        super();
    }

    public void execute() {
        
        String[] genes = {"a", "b", "c", "aa", "d", "b"};
        int[] healths = {1, 2, 3, 4, 5, 6};
        String[] strands = {"caaab", "xyz", "bcdybc"};
        int[] strand_starts = {1, 0, 2};
        int[] strand_ends = {5, 4, 4};
        
        System.out.print("The function is of the format: int getTotalX(List<Integer> a, List<Integer> b); genes: [");
        for (String s : genes) System.out.print(s + ", ");
        System.out.print("], healths: [");
        for (int i : healths) System.out.print(i + ", ");
        System.out.print("], strands: [");
        for (String s : strands) System.out.print(s + ", ");
        System.out.print("], strands_starts: [");
        for (int i : strand_starts) System.out.print(i + ", ");
        System.out.print("], strand_ends: [");
        for (int i : strand_ends) System.out.print(i + ", ");
        System.out.println("]");

        this.determiningDNAHealth(genes, healths, strands, strand_starts, strand_ends);
    }
    
    public void determiningDNAHealth(String[] genes, int[] health, String[] strands, int[] strand_starts, int[] strand_ends) {
        
        int lowest_health = Integer.MAX_VALUE, highest_health = 0;
        
        if (strands.length == 0) {System.out.println("0 0"); return;}
        
        for (int i = 0; i < strands.length; i++) {
            String d = strands[i];
            int first = strand_starts[i];
            int last = strand_ends[i];
            int strand_health = 0;
            // This is where the code for HackerRank begins
            // Test each gene in the correct range
            for (int j = 0; j + first < last + 1; j++) {
                String gene = genes[j + first];
                int index = d.indexOf(gene);
                while (index != -1) {
                    strand_health += health[j + first];
                    index = d.indexOf(gene, index + 1);
                }
            }
            if (strand_health < lowest_health) lowest_health = strand_health;
            if (strand_health > highest_health) highest_health = strand_health;
        }
        
        System.out.println(lowest_health + " " + highest_health);
    }
}