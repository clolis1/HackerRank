package hackerrank.problems;

import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

public class SockMerchant implements Problem {
    public SockMerchant() {
        super();
    }

    public void execute() {
        
        int num_socks = 7;
        int[] socks = {1,2,1,2,1,3,2};
        
        System.out.println("The function is of the format: int sockMerchant(int n, int[] ar); n: " + num_socks + ", scores: [");
        for (int i : socks) System.out.print(i + ", ");
        System.out.print("]");

        System.out.println("]\nAnswer: " + this.sockMerchant(num_socks, socks));
    }
    
    public int sockMerchant(int n, int[] ar) {
        Hashtable<Integer, Integer> socks = new Hashtable<Integer, Integer>();
        for (int i : ar) {
            if (!socks.containsKey(i)) socks.put(i, 1);
            else socks.replace(i, (socks.get(i) + 1));
        }
        AtomicInteger counter = new AtomicInteger(0);
        socks.forEach((key, val) -> counter.set(counter.get() + val / 2));
        return counter.get();
    }
}
