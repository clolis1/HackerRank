package hackerrank.util;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ComplexMath {
    public ComplexMath() {
        super();
    }
    
    public static int findLCM (List<Integer> list) {
        HashMap<Integer, Integer> final_list = new HashMap<Integer, Integer>();
        
        for (int i : list) {
            HashMap<Integer, Integer> list_i = ComplexMath.getPrimeFactors(i);
            list_i.forEach((key, val) -> {
                if (final_list.containsKey(key) && val > final_list.get(key)) {
                    final_list.replace(key, val);
                }
                else if (!final_list.containsKey(key)) {
                    final_list.put(key, val);
                }
            });
        }
        
        AtomicInteger lcm = new AtomicInteger(1);
        final_list.forEach((key, val) -> lcm.set(lcm.get() * (int) Math.pow(key, val)));
        
        return lcm.get();
    }
    
    public static HashMap<Integer, Integer> getPrimeFactors (int n) {
        
        HashMap<Integer, Integer> pFactors = new HashMap<Integer, Integer>();
        
        if (n == 1 || n == 0) {
            return pFactors;
        }
        
        if (n % 2 == 0) pFactors.put(2, 0);
        while (n % 2 == 0) {
            n /= 2;
            pFactors.replace(2, pFactors.get(2) + 1); // Increase multiplicity by one.
        }
        
        if (n % 3 == 0) pFactors.put(3, 0);
        while (n % 3 == 0) {
            n /= 3;
            pFactors.replace(3, pFactors.get(3) + 1); // Increase multiplicity by one.
        }
        
        double square_root = Math.floor(Math.sqrt(n));
        double temp = n;
        
        for (int i = 5; i <= square_root; i++) {
            if (temp % i == 0) pFactors.put(i, 0); // add i to list of prime factors
            while (temp % i == 0) {
                pFactors.replace(i, pFactors.get(i) + 1); // Increase multiplicity by one
                temp /= i; // temp is divided by one of its prime factors.
                square_root = Math.floor(Math.sqrt(temp)); // New square root value to save time.
            }
        }
        if (temp != 1.0) pFactors.put((int) temp, 1); // Using this method, there cannot be another factor greater than than this quotient.
        return pFactors;
    }
}
