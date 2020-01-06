package hackerrank.problems;

public class RepeatedString implements Problem {
    public RepeatedString() {
        super();
    }

    public void execute() {
        
        String s = "aba";
        long n = 10;
        
        System.out.println("The function is of the format: long repeatedString(String s, long n); s: " + s + ", n : " + n);

        System.out.println("\nAnswer: " + this.repeatedString(s, n));
    }
    
    public long repeatedString(String s, long n) {
        int length = s.length(), a_count = 0, cutoff_length = (int) (n % length);
        long a_total = 0L;
        
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                a_count++;
                if (i < cutoff_length) a_total++;
            }
        }
        a_total += (n / length) * a_count;
        return a_total;
    }
}
