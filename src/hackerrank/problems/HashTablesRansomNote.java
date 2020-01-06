package hackerrank.problems;

import java.util.Hashtable;

public class HashTablesRansomNote implements Problem {
    public HashTablesRansomNote() {
        super();
    }

    public void execute() {
        
        String[] magazine1 = {"give", "me", "one", "grand", "today", "night"},
            note1 = {"give", "one", "grand", "today"},
            magazine2 = {"two", "times", "three", "is", "not", "four"},
            note2 = {"two", "times", "two", "is", "four"},
            magazine3 = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"},
            note3 = {"ive", "got", "some", "coconuts"};
        
        System.out.print("The function is of the format: void checkMagazine(String[] magazine, String[] note);\n");
        
        this.checkMagazine(magazine1, note1); System.out.println();
        this.checkMagazine(magazine2, note2); System.out.println();
        this.checkMagazine(magazine3, note3); System.out.println();
    }
    
    public void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> dictionary = new Hashtable<String, Integer>();
        
        for (String s : magazine) {
            if (dictionary.containsKey(s)) {
                dictionary.put(s, dictionary.get(s) + 1);
            }
            else {
                dictionary.put(s, new Integer(1));
            }
        }
        
        for (String s : note) {
            if (!dictionary.containsKey(s)) {
                System.out.print("No");
                return;
            }
            else if (dictionary.get(s).intValue() == 1) {
                dictionary.remove(s);
            }
            else {
                dictionary.put(s, dictionary.get(s) - 1);
            }
        }
        System.out.print("Yes");
    }
}
