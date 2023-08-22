import java.io.*;
import java.util.*;

class Solution {
    
    static ArrayList<String> result;
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        
        result = new ArrayList<>();
        visited = new boolean[tickets.length];

        DFS(0, "ICN", "ICN", tickets);

        Collections.sort(result);

        return result.get(0).split(" ");
    }

    static void DFS(int k, String now, String path, String[][] tickets){
        if (k == tickets.length) {
            result.add(path);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                DFS(k+1, tickets[i][1], path + " " +tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
    
}