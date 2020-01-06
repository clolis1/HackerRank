package hackerrank.problems;

public class SherlockAndTheValidString implements Problem {
    public SherlockAndTheValidString() {
        super();
    }

    public void execute() {
        String s1 = "aabbcd", s2 = "aabbccddeefghi", s3 = "abcdefggfedecba", s4 = "aaaabbcc";
        
        System.out.println(isValid(s1) + " " + isValid(s2) + " " + isValid(s3) + " " + isValid(s4));
    }
    
    public static String isValid(String s) {
        if (s.length() == 0 || s.length() == 1) return "YES";
        int[] letter_count = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'a': letter_count[0]++; break;
                case 'b': letter_count[1]++; break;
                case 'c': letter_count[2]++; break;
                case 'd': letter_count[3]++; break;
                case 'e': letter_count[4]++; break;
                case 'f': letter_count[5]++; break;
                case 'g': letter_count[6]++; break;
                case 'h': letter_count[7]++; break;
                case 'i': letter_count[8]++; break;
                case 'j': letter_count[9]++; break;
                case 'k': letter_count[10]++; break;
                case 'l': letter_count[11]++; break;
                case 'm': letter_count[12]++; break;
                case 'n': letter_count[13]++; break;
                case 'o': letter_count[14]++; break;
                case 'p': letter_count[15]++; break;
                case 'q': letter_count[16]++; break;
                case 'r': letter_count[17]++; break;
                case 's': letter_count[18]++; break;
                case 't': letter_count[19]++; break;
                case 'u': letter_count[20]++; break;
                case 'v': letter_count[21]++; break;
                case 'w': letter_count[22]++; break;
                case 'x': letter_count[23]++; break;
                case 'y': letter_count[24]++; break;
                case 'z': letter_count[25]++;
            }
        }
        
        int[] frequency_counter = new int[2];
        int f1 = 0, f2 = 0;
        for (int i = 0; i < letter_count.length; i++) {
            while (i < letter_count.length && letter_count[i] == 0) {
                i++;
            }
            if (i >= letter_count.length) break;
            if (frequency_counter[0] == 0) {frequency_counter[0] = letter_count[i]; f1++;}
            else if (letter_count[i] == frequency_counter[0]) f1++;
            else if (frequency_counter[1] == 0) {frequency_counter[1] = letter_count[i]; f2++;}
            else if (letter_count[i] == frequency_counter[1]) f2++;
            else return "NO";
        }
        if (frequency_counter[0] > 0 && frequency_counter[1] == 0) return "YES";
        if (frequency_counter[0] == 1 && f1 == 1) return "YES";
        if (frequency_counter[1] == 1 && f2 == 1) return "YES";
        if (f1 > 1 && f2 > 1) return "NO";
        if (Math.abs(frequency_counter[0] - frequency_counter[1]) > 1 &&
            (f1 == 1 || f2 == 1)) return "NO";
        return "YES";
    }
}
