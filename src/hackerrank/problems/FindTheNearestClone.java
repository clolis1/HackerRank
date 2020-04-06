package hackerrank.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindTheNearestClone implements Problem {
    public FindTheNearestClone() {
        super();
    }

    public void execute() {
        int graphNodes1 = 4, val1 = 1, 
            graphNodes2 = 4, val2 = 2,
            graphNodes3 = 5, val3 = 2;
        int[] from1 = {1, 1, 4}, to1 = {2, 3, 2},
            from2 = {1, 1, 4}, to2 = {2, 3, 2},
            from3 = {1, 1, 2, 3}, to3 = {2, 3, 4, 5};
        long[] ids1 = {1, 2, 1, 1}, ids2 = {1, 2, 3, 4}, ids3 = {1, 2, 3, 3, 2};
        
        System.out.println(findShortest(graphNodes1, from1, to1, ids1, val1) + " " + findShortest(graphNodes2, from2, to2, ids2, val2) + " " + 
                           findShortest(graphNodes3, from3, to3, ids3, val3));
    }
    /**
     * @param graphNodes: Number of nodes in the graph
     * @param graphFrom: Origin of all edges in graph
     * @param graphTo: End-node of all edges in graph
     * @param ids: color id for all nodes in graph
     * @param val: target color
     * @return shortest distance between two target colored nodes, or -1 if there is no path
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < graphFrom.length; i++) {
            map.putIfAbsent(graphFrom[i], new HashSet<Integer>()); // Create a new node in the HashMap
            map.putIfAbsent(graphTo[i], new HashSet<Integer>());
            
            map.get(graphFrom[i]).add(graphTo[i]); // Add the connection to the cities list of connections
            map.get(graphTo[i]).add(graphFrom[i]);
        }
        
        // Breadth First Search on all nodes at once
        long[] distances = new long[graphNodes + 1];
        Arrays.fill(distances, -1L);
        int[] points_of_origin = new int[graphNodes + 1];
        
        // Set distance to 0 if number is already correct color.
        // Set point of origin to itself if it is the target color.
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] != val) continue;
            distances[i + 1] = 0L;
            points_of_origin[i + 1] = i + 1;
        }
        
        // Go through every node starting at distance = 0, checking connections between nodes
        boolean new_connection_found = true;
        int distance_from_origin_node = 0;
        while (new_connection_found) {
            new_connection_found = false;
            for (int i = 1; i < distances.length; i++) { // i : iterator to query every node
                if (distances[i] != distance_from_origin_node || !map.containsKey(i)) continue; // Skip unless node is of certain distance away
                for (Integer j : map.get(i)) {                                                  // Found a node of the current deepest depth, check all of its connections
                    if (distances[j] == -1L) {                                                  // Node is a new connection, so it is added to web of "visited" node
                        distances[j] = distance_from_origin_node + 1;
                        points_of_origin[j] = points_of_origin[i];                              // The node's point of origin is marked
                        new_connection_found = true;
                    }
                    else if (points_of_origin[i] != points_of_origin[j]){                       // Connection between two points of origin found
                        return distance_from_origin_node + (int) distances[j] + 1;              // Return distance between both extremity nodes
                    }
                }
            }
            distance_from_origin_node++;
        }
        return -1; // No connection between nodes of target color found.
    }
}
