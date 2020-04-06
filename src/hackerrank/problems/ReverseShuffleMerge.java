package hackerrank.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class ReverseShuffleMerge implements Problem {
    public ReverseShuffleMerge() {
        super();
    }

    public void execute() {
        String s1 = "aacdbdcb", s2 = "bdabaceadaedaaaeaecdeadababdbeaeeacacaba", s3 = "sbcnzxqnrygkocahxjebvueaawwcythjdrhvizqsshgtwdolmillxpshxpxqrywkivceufclhydhshrklkphajbftuapiocjlcthfirhgaohfysqjolssbzhbovdstbyqdpnjbpfmgqrzfctcwcrztvgbegunarvecseoulabaonguckqbtrvuagreyclyjytpvozqdnhldlnsocenuzksawirgsbjobpldjdlrxbricrauuksbmecvvwagnnacaqghmjpzrlsvlpbbcuaddgvlhvuvkxexjcfhxrodmcwlrzyyiksuksshhonahsyzbbprwuitmoyoqurtqsaslevgvpfbzkkhgcnpjdpseuiylluvdetsqssbrxpiclxxvosuqipsqvvwsezhl";
        
        System.out.println(reverseShuffleMerge(s1) + " " + reverseShuffleMerge(s2) + " " + reverseShuffleMerge(s3));
    }
    
    public static String reverseShuffleMerge(String s) {
        int[] chars = new int[26], skippable = new int[26];
        for (int j = 0; j < s.length(); j++) {
            int index = s.charAt(j) - 97;
            chars[index]++;
        }
        for (int i = 0; i < skippable.length; i++){
            chars[i] /= 2;
            skippable[i] = chars[i];
        }
        
        int[] brick = Arrays.copyOf(chars, chars.length);
        int[] frequency = new int[26];
        List<Integer> buffer = new ArrayList<Integer>();
        String end_string = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (buffer.size() == 0 || (end_string.length() > 0 && // The OR block determines whether the last char added has the same value as the current char,
                                       c == end_string.charAt(end_string.length() - 1) && // If it does, and we are also no longer pressed to include a char with that value, the buffer will continue to add chars
                                       frequency[end_string.charAt(end_string.length() - 1) - 97] + skippable[end_string.charAt(end_string.length() - 1) - 97] == 0)) {
                for(int j = i - buffer.size(); j >= 0; j--){
                    buffer.add((int) s.charAt(j));
                    skippable[s.charAt(j) - 97]--;
                    if (skippable[s.charAt(j) - 97] + frequency[s.charAt(j) - 97] < 0) {
                        break;
                    }
                }
            }
            
            boolean isSmallest = true;
            
            for (int j = 0; j < buffer.size(); j++) {
                if (frequency[buffer.get(j) - 97] == brick[buffer.get(j) - 97]) continue;
                else if (c > buffer.get(j).intValue()) {
                    isSmallest = false;
                    break;
                }
            }
            
            if (isSmallest && chars[(int)(c - 97)] > 0) {
                    end_string += c;
                    frequency[c - 97]++;
                    chars[(int)(c - 97)]--;
            }
            if (buffer.size() > 0) buffer.remove(0);
        }
            return end_string;
    }
}
