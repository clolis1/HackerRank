package hackerrank.problems;

public class TimeConversion implements Problem {
    public TimeConversion() {
        super();
    }

    public void execute() {
        String s = "12:45:54PM";
        
        System.out.println("The function is of the format: String timeConversion(String s); s : " + s);
        
        System.out.println("\nAnswer: " + this.timeConversion(s));
    }
    
    public String timeConversion(String s) {
        s = (s.endsWith("PM")) ? ((Integer.parseInt(s.substring(0, 2)) + 12) + s.substring(2, 8)) : s.substring(0, 8);
        if (s.startsWith("12")) s = "00" + s.substring(2, 8);
        if (s.startsWith("24")) s = "12" + s.substring(2, 8);
        return s;
    }
}
