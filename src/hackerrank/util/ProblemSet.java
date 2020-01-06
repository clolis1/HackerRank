package hackerrank.util;

import hackerrank.problems.*;

import java.util.HashMap;

public class ProblemSet {
    
    //Instance Variables
    HashMap<String, Problem> probs;
    
    public ProblemSet() {
        probs = new HashMap<String, Problem>();
        
        probs.put("solvemefirst", new SolveMeFirst());
        probs.put("simplearraysum", new SimpleArraySum());
        probs.put("comparethetriplets", new CompareTheTriplets());
        probs.put("averybigsum", new AVeryBigSum());
        probs.put("diagnoldifference", new DiagnolDifference());
        probs.put("plusminus", new PlusMinus());
        probs.put("staircase", new Staircase());
        probs.put("minimaxsum", new MiniMaxSum());
        probs.put("birthdaycakecandles", new BirthdayCakeCandles());
        probs.put("timeconversion", new TimeConversion());
        probs.put("sherlockandarray", new SherlockAndArray());
        probs.put("appleandorange", new AppleAndOrange());
        probs.put("kangaroo", new Kangaroo());
        probs.put("betweentwosets", new BetweenTwoSets());
        probs.put("breakingtherecord", new BreakingTheRecord());
        probs.put("determiningdnahealth", new DeterminingDNAHealth());
        probs.put("sockmerchant", new SockMerchant());
        probs.put("countingvalleys", new CountingValleys());
        probs.put("jumpingontheclouds", new JumpingOnTheClouds());
        probs.put("repeatedstring", new RepeatedString());
        probs.put("2darrayds", new HourglassSum());
        probs.put("arraysleftrotation", new RotLeft());
        probs.put("newyearchaos", new NewYearChaos());
        probs.put("minimumswaps2", new MinimumSwaps2());
        probs.put("arraymanipulation", new ArrayManipulation());
        probs.put("hashtablesransomnote", new HashTablesRansomNote());
        probs.put("twostrings", new TwoStrings());
        probs.put("sherlockandanagrams", new SherlockAndAnagrams());
        probs.put("counttriplets", new CountTriplets());
        probs.put("frequencyqueries", new FrequencyQueries());
        probs.put("sortingbubblesort", new SortingBubbleSort());
        probs.put("markandtoys", new MarkAndToys());
        probs.put("sortingcomparator", new SortingComparator());
        probs.put("mergesortcountinginversions", new MergeSortCountingInversions());
        probs.put("fraudulentactivitynotifications", new FraudulentActivityNotifications());
        probs.put("stringsmakinganagrams", new StringsMakingAnagrams());
        probs.put("alternatingcharacters", new AlternatingCharacters());
        probs.put("sherlockandthevalidstring", new SherlockAndTheValidString());
        probs.put("specialstringagain", new SpecialStringAgain());
    }
    
    // Returns the associated Problem from the array, or null if it does not.
    public Problem get(String s){
        if (probs.containsKey(s)) return probs.get(s);
        return null;
    }
}
