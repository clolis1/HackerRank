package hackerrank.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;

public class RoadsAndLibraries implements Problem {
    public RoadsAndLibraries() {
        super();
    }

    public void execute() {
        int n1 = 3, c_lib1 = 2, c_road1 = 1, n2 = 6, c_lib2 = 2, c_road2 = 5;
        int n3 = 9, c_lib3 = 91, c_road3 = 84, n4 = 5, c_lib4 = 92, c_road4 = 23;
        int n5 = 8, c_lib5 = 10, c_road5 = 55, n6 = 1, c_lib6 = 5, c_road6 = 3;
        int n7 = 2, c_lib7 = 102, c_road7 = 1;
        int[][] cities1 = { {1, 2}, {3, 1}, {2, 3} }, cities2 = { {1, 3}, {3, 4}, {2, 4}, {1, 2}, {2, 3}, {5, 6} },
            cities3 = { {8, 2}, {2, 9} }, cities4 = { {2, 1}, {5, 3}, {5, 1}, {3, 4}, {3, 1}, {5, 4}, {4, 1}, {5, 2}, {4, 2} },
            cities5 = { {6, 4}, {3, 2}, {7, 1} }, cities6 = {}, cities7 = {};
        
        System.out.println(roadsAndLibraries(n1, c_lib1, c_road1, cities1) + " " + roadsAndLibraries(n2, c_lib2, c_road2, cities2) + " " + 
                           roadsAndLibraries(n3, c_lib3, c_road3, cities3) + " " + roadsAndLibraries(n4, c_lib4, c_road4, cities4) + " " +
                           roadsAndLibraries(n5, c_lib5, c_road5, cities5) + " " + roadsAndLibraries(n6, c_lib6, c_road6, cities6) + " " +
                           roadsAndLibraries(n7, c_lib7, c_road7, cities7));
    }
    
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (cities.length == 0) return n * c_lib;
        HashMap<Integer, HashSet<Integer>> nodes = new HashMap<Integer, HashSet<Integer>>();
        for (int[] i : cities) {
            nodes.putIfAbsent(i[0], new HashSet<Integer>()); // Create a node in the HashMap for a city
            nodes.putIfAbsent(i[1], new HashSet<Integer>());
            
            nodes.get(i[0]).add(i[1]); // Add the connection to the cities list of connections
            nodes.get(i[1]).add(i[0]);
        }
        
        if (c_lib <= c_road) return c_lib * n;
        
        AtomicLong total_cost = new AtomicLong();
        boolean[] visited = new boolean[n + 1];
        
        nodes.forEach((i, v) -> {
            if (visited[i]) return;
            HashSet<Integer> connected_cities = new HashSet<Integer>();
            get_connected_cities(i, nodes, visited, connected_cities);
            total_cost.addAndGet((long) c_lib + (long) c_road * (connected_cities.size() - 1));
        });
        
        long total_connected_cities = n;
        for (boolean b : visited) {
            if (!b) total_connected_cities--;
        }
        
        return total_cost.longValue() + c_lib * (n - total_connected_cities - 1);
    }
    
    /**
     * @param x: The resulting connected city map WILL contain this city
     *        map: The entire map with all connections.
     * @return A set of connected cities
     */
    private static void get_connected_cities(int x, HashMap<Integer, HashSet<Integer>> map, boolean[] visited, HashSet<Integer> connected_cities) {
        for (Integer i : map.get(x)) { // Iterate through every connected city
            if (visited[i]) continue;
            visited[i] = true;
            connected_cities.add(i);
            get_connected_cities(i, map, visited, connected_cities);
        }
    }
}
