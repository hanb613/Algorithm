import java.util.*;
import java.io.*;

class Solution {

    private int n, m;
    private static int[][] result;
    
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        result = new int[n][m];
        
        BFS(maps, n, m);

        if(result[n-1][m-1]==0) 
            return -1;
        else
            return result[n-1][m-1];
    }
    
    private static void BFS(int[][] maps, int n, int m){
        Queue<Info> q = new LinkedList<Info>();
        q.offer(new Info(0, 0));
        result[0][0]=1;
        
        while(!q.isEmpty()){
            Info p = q.poll();
            
            if(p.x==n-1 && p.y==m-1) return;
            
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                
                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(maps[nx][ny]==0 || result[nx][ny]!=0) continue;
                
                result[nx][ny] = result[p.x][p.y]+1;
                q.offer(new Info(nx, ny));
            }
        }
        return;
    }
    
    private static class Info{
        int x, y;
        
        public Info(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}