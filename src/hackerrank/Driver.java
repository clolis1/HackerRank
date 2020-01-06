package hackerrank;
import hackerrank.util.ProblemSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;

public class Driver
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Hello! This program executes various algorithms to solve certain problems from HackerRank.com");
        System.out.println("Input a problem name. You can also type \"ls\" to list all problems available here. The following data will outputted to the screen:");
        System.out.println("The problem, the answer, and the time spent calculating.");
        System.out.println("By inputting the problem/method name followed by \"e\", as in \"#e\", a .txt file explaining the problem and solution used will be displayed to the console.");
        System.out.println("If a string inputted does not have an associated solution within this file, a message will appear to inform the user.");
        System.out.println("\nType Q to quit.\nPlease input a file name:");
        
        boolean running = true;
        
        ProblemSet pSet = new ProblemSet();
        
        while (running) {
            // Receive input from user.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            
            if (input == null) { // Error
                System.out.println("Error: Failed to read from console. Aborting...");
                break;
            }
            
            input = input.trim();
            input = input.toLowerCase();
            char[] i_array = input.toCharArray();
            boolean valid_string = false;
            boolean explain_please = false;
            
            if (i_array.length == 0) { // Check if input is empty
                // Do nothing. Prithee, be careful.
            }
            else if (i_array[0] == 'Q' || i_array[0] == 'q' && i_array.length == 1) { // Check if QUIT is executed
                System.out.println("Exiting program...");
                break;
            }
            else { // Determine if problem name exists, and return an error if it does not
                if (pSet.get(input) != null) valid_string = true;
            }
            
            if (valid_string && !explain_please) { // Execute the appropriate program, if it exists
                final long startTime = System.currentTimeMillis();
                pSet.get(input).execute();
                final long endTime = System.currentTimeMillis();
                
                double totalTime = (double)(endTime - startTime);
                totalTime = totalTime / 1000.000; // Convert to seconds
                if (totalTime == 0.0) { // Less than 1 millisecond of execution time
                    System.out.println("Total execution time: less than .001 seconds");
                }
                else{ // Print execution diration
                    System.out.println("Total execution time: " + totalTime + " seconds");
                }
            }
            else if (valid_string && explain_please) { // Display the appropriate explanation, if it exists
                String explanation = "explanations/" + input + ".txt";
                br = new BufferedReader(new FileReader(explanation));
                String line = null;
                // Print out explanation text file
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
            else { // input wasn't valid. An appropriate error message *should* have been displayed already
                // Mario, it that really you?
            }
        }
        System.out.println("Bye!");
    }
}