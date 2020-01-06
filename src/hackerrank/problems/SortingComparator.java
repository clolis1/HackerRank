package hackerrank.problems;

import java.util.Comparator;

public class SortingComparator implements Problem {
    class Player {
        String name;
        int score;
        Player(String s, int i) {
            name = s;
            score = i;
        }
    }
    
    public SortingComparator() {
        super();
    }

    public void execute() {
        Player[] players = {new Player("amy", 100), new Player("david", 100), new Player("heraldo", 50), new Player("aakansha", 75), new Player("aleksa", 150)};
        
        mergeSort(players, players.length);
        
        for (Player p : players) System.out.println(p.name + " " + p.score);
    }
    
    public static int compare(Player a, Player b) {
        if (a.score < b.score) return 1;
        else if (a.score > b.score) return -1;
        
        if (a.name.compareTo(b.name) < 0) return -1;
        else if (a.name.compareTo(b.name) > 0) return 1;
        
        return 0;
    }
    
    public static void mergeSort(Player[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Player[] l = new Player[mid];
        Player[] r = new Player[n - mid];
        
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        
        merge(a, l, r, mid, n - mid);
    }
    
    public static void merge(Player[] a, Player[] l, Player[] r, int left, int right) {
      
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (compare(l[i], r[i]) <= 0) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
