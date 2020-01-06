package hackerrank.problems;

public class RotLeft implements Problem{
    public RotLeft() {
        super();
    }
    
    public void execute() {
        
        int[] arr = {1, 2, 3, 4, 5};
        int d = 4;
        
        System.out.println("The function is of the format: int rotLeft(int[] arr); arr: [");
        
        for (int i : arr) System.out.print(i + ", ");
        System.out.print("]; d : " + d);
        
        System.out.println("\nAnswer: ");
        for (int i : this.rotLeft(arr, d)) System.out.print(i + " ");
        System.out.print('\n');
    }
    
    public int[] rotLeft(int[] arr, int d) {
        int length = arr.length;
        int[] rotated = new int[length];
        
        for (int i = 0; i < arr.length; i++) {
            rotated[(((i - d) % length) + length) % length] = arr[i]; // Unwieldy equation because java calculates remainder instead of modulus.
        }
        
        return rotated;
    }
}
