package hackerrank.problems;

import java.util.Arrays;
import java.util.LinkedList;

public class FraudulentActivityNotifications implements Problem {
    public FraudulentActivityNotifications() {
        super();
    }

    public void execute() {
        int[] arr1 = {10, 20, 30, 40, 50, 60};
        int[] arr2 = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        
        int d1 = 3, d2 = 5;
        
        System.out.println(activityNotifications(arr1, d1) + " " + activityNotifications(arr2, d2));
    }
    
    public static int activityNotifications(int[] expenditure, int d) {
        if (d == expenditure.length) return 0;
        int notifications = 0;
        boolean odd = d % 2 == 1 ? true : false;
        
        int[] countArray = new int[201];
        
        for (int i = 0; i < d; i++) {
            countArray[expenditure[i]]++;
        }
        
        for (int i = 0; i < expenditure.length - d; i++) {
            double median = 0.0;
            int count = 0;
            if (odd) {
                for (int j = 0; j < countArray.length; j++) {
                count += countArray[j];
                    if (count > d / 2) {
                        median = j;
                        break;
                    }
                }
            }
            else {
                for (int j = 0; j < countArray.length; j++) {
                count += countArray[j];
                    if (count == d / 2) {
                        int temp = -1;
                        median = j;
                        while (temp == -1) {
                            if (countArray[++j] > 0) temp = j;
                        }
                        median += temp;
                        median /= 2.0;
                        break;
                    }
                    else if (count > d / 2) {
                        median = j;
                        break;
                    }
                }
            }
            if (expenditure[i + d] >= median * 2.0) notifications++;
            countArray[expenditure[i]]--;
            countArray[expenditure[i + d]]++;
        }
        
        return notifications;
    }
}
