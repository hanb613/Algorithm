import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
	static String[] dirsStr = {"d" , "l", "r", "u"};
	
    static StringBuilder answer = new StringBuilder();
    static String result = "";
	
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        // k로 갈 수 있는지 ?
        int distance = distance(x, y, r, c);
        if (distance > k || (k - distance) % 2 == 1) return "impossible";
		
        dfs(n, m, x, y, r, c, k, 0);

        return result == "" ? "impossible" : result;
    }

    static void dfs(int n, int m, int x, int y, int r, int c, int k, int depth) {
        if (result != "") return;
        if (depth + distance(x, y, r, c) > k) return;
        if (k == depth) {
            if (x == r && y == c) {
                result = answer.toString();
            }
            return;
        }
		
        for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
            
            if(nx<=0 || ny<=0 || nx>n || ny>m) continue;
            
            answer.append(dirsStr[i]);
            dfs(n, m, nx, ny, r, c, k, depth + 1);
            answer.delete(depth, depth + 1);
        }
    }

    static int distance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
}