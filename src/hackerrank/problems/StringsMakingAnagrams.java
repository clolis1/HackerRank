package hackerrank.problems;

public class StringsMakingAnagrams implements Problem {
    public StringsMakingAnagrams() {
        super();
    }

    public void execute() {
        String a = "cde", b = "dcf";
        
        System.out.println(makeAnagram(a, b));
    }
    
    public static int makeAnagram(String a, String b) {
        int[] a_count = new int[26], b_count = new int[26];
        
        for(int i = 0; i < a.length(); i++) {
            switch (a.charAt(i)){
                case 'a': a_count[0]++; break;
                case 'b': a_count[1]++; break;
                case 'c': a_count[2]++; break;
                case 'd': a_count[3]++; break;
                case 'e': a_count[4]++; break;
                case 'f': a_count[5]++; break;
                case 'g': a_count[6]++; break;
                case 'h': a_count[7]++; break;
                case 'i': a_count[8]++; break;
                case 'j': a_count[9]++; break;
                case 'k': a_count[10]++; break;
                case 'l': a_count[11]++; break;
                case 'm': a_count[12]++; break;
                case 'n': a_count[13]++; break;
                case 'o': a_count[14]++; break;
                case 'p': a_count[15]++; break;
                case 'q': a_count[16]++; break;
                case 'r': a_count[17]++; break;
                case 's': a_count[18]++; break;
                case 't': a_count[19]++; break;
                case 'u': a_count[20]++; break;
                case 'v': a_count[21]++; break;
                case 'w': a_count[22]++; break;
                case 'x': a_count[23]++; break;
                case 'y': a_count[24]++; break;
                case 'z': a_count[25]++;
            }
        }
        
        for(int i = 0; i < b.length(); i++) {
            switch (b.charAt(i)){
                case 'a': b_count[0]++; break;
                case 'b': b_count[1]++; break;
                case 'c': b_count[2]++; break;
                case 'd': b_count[3]++; break;
                case 'e': b_count[4]++; break;
                case 'f': b_count[5]++; break;
                case 'g': b_count[6]++; break;
                case 'h': b_count[7]++; break;
                case 'i': b_count[8]++; break;
                case 'j': b_count[9]++; break;
                case 'k': b_count[10]++; break;
                case 'l': b_count[11]++; break;
                case 'm': b_count[12]++; break;
                case 'n': b_count[13]++; break;
                case 'o': b_count[14]++; break;
                case 'p': b_count[15]++; break;
                case 'q': b_count[16]++; break;
                case 'r': b_count[17]++; break;
                case 's': b_count[18]++; break;
                case 't': b_count[19]++; break;
                case 'u': b_count[20]++; break;
                case 'v': b_count[21]++; break;
                case 'w': b_count[22]++; break;
                case 'x': b_count[23]++; break;
                case 'y': b_count[24]++; break;
                case 'z': b_count[25]++;
            }
        }
        
        int counter = 0;
        for (int i = 0; i < a_count.length; i++) {
            counter += Math.abs(a_count[i] - b_count[i]);
        }
        
        return counter;
    }
}
