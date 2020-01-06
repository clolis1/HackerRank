package hackerrank.problems;

public class NewYearChaos implements Problem {
    public NewYearChaos() {
        super();
    }

    public void execute() {
        
        int[] arr1 = {2, 1, 5, 3, 4};
        int[] arr2 = {2, 5, 1, 3, 4};
        
        System.out.print("The function is of the format: int hourglassSum(int[] arr); arr1: [");
        
        for (int i : arr1) System.out.print(i + ", ");
        System.out.print("]; arr2 : ");
        for (int i : arr2) System.out.print(i + ", ");
        System.out.print("]\n");
        
        this.newYearChaos(arr1);
        this.newYearChaos(arr2);
        System.out.print('\n');
    }
    
    public void newYearChaos(int[] q) {
        int bribe_count = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] > i + 3) {
                System.out.println("Too chaotic"); return;
            }
            for (int j = (0 >= q[i] - 2) ? 0 : q[i] - 2; j < i; j++) if (q[j] > q[i]) bribe_count++;
        }
        System.out.println(bribe_count);
    }
}
