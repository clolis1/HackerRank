package hackerrank.problems;

public class BirthdayCakeCandles implements Problem {
    public BirthdayCakeCandles() {
        super();
    }

    public void execute() {
        final int[] ar = {4, 4, 1, 3};
        
        System.out.println("The function is of the format: int birthdayCakeCandles(int[] ar); ar : ");
        
        for (int i : ar) System.out.print(i + ", ");
        
        System.out.println("\nAnswer: " + this.birthdayCakeCandles(ar));
    }
    
    public int birthdayCakeCandles(int[] ar) {
        class Candle {
            int height;
            int count;
            
            public Candle() {
                height = 0;
                count = 0;
            }
            
            void new_tallest(int x) {
                height = x;
                count = 1;
            }
            
            void increase_count() {
                count++;
            }
        }
        Candle tallest = new Candle();
        
        for (int i : ar) {
            if (i > tallest.height) tallest.new_tallest(i);
            else if (i == tallest.height) tallest.increase_count();
        }
        
        return tallest.count;
    }
}
