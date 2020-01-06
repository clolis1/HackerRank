package hackerrank.problems;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CountTriplets implements Problem {
    public CountTriplets() {
        super();
    }

    public void execute() {
        
        List<Long> arr1 = new ArrayList<Long>();
        arr1.add(new Long(1L)); arr1.add(new Long(2L)); arr1.add(new Long(1L)); arr1.add(new Long(2L)); arr1.add(new Long(4L));
        
        List<Long> arr2 = new ArrayList<Long>();
        arr2.add(new Long(1L)); arr2.add(new Long(3L)); arr2.add(new Long(9L)); arr2.add(new Long(9L)); arr2.add(new Long(27L)); arr2.add(new Long(81L));
        
        List<Long> arr3 = new ArrayList<Long>();
        arr3.add(new Long(1L)); arr3.add(new Long(5L)); arr3.add(new Long(5L)); arr3.add(new Long(25L)); arr3.add(new Long(125L));
        
        List<Long> arr4 = new ArrayList<Long>();
        for (int i = 0; i < 100000; i++) arr4.add(new Long(1237L));
        
        long r1 = 2L, r2 = 3L, r3 = 5L, r4 = 1L;
        
        System.out.print("The function is of the format: int sherlockAndAnagrams(String s);\n");
        
        System.out.println(this.countTriplets(arr1, r1) + " " + this.countTriplets(arr2, r2) + " " + this.countTriplets(arr3, r3) + " " + this.countTriplets(arr4, r4));
    }
    
    public long countTriplets(List<Long> arr, long r) {
        long triplet_counter = 0L;
        
        if (arr.size() < 3) return 0L;
        
        Hashtable<Long, Long> need_2 = new Hashtable<Long, Long>(), need_1 = new Hashtable<Long, Long>();
        
        if (r == 1L) {
            //repurpose need_2 for this case
            for (Long l : arr) {
                need_2.computeIfPresent(l, (k, v) -> ++v);
                need_2.computeIfAbsent(l, k -> new Long(1));
            }
            
            AtomicLong atomic_counter = new AtomicLong(0L);
            need_2.forEach((key, val) -> {
                if (val >= 3) {
                    long temp = (long) (((long) val * ((long) val - 1) * ((long) val - 2)) / 6);
                    System.out.println(temp);
                    atomic_counter.set(atomic_counter.get() + temp);
                }
            });
            return atomic_counter.get();
        }
        
        for (int i = 0; i < arr.size(); i++) {
            Long temp = arr.get(i);
            
            if (need_1.containsKey(temp)) triplet_counter += need_1.get(temp);
            
            need_2.computeIfPresent(temp, (k, v) -> ++v);
            need_2.computeIfAbsent(temp, k -> new Long(1));
            
            if (temp % r == 0 && need_2.containsKey(temp / r)) {
                need_1.computeIfPresent(temp * r, (k, v) -> v + need_2.get(temp / r));
                need_1.computeIfAbsent(temp * r, k -> need_2.get(temp / r));
            }
        }
        
        return triplet_counter;
    }
}
