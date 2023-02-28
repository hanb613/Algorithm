import java.io.*;
import java.util.*;
 
public class Solution {
   static int n, res, start;
   static int[][] graph;
   static int[] visit;
 
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
 
      for(int tc=1; tc<=10; tc++){
         st = new StringTokenizer(in.readLine());
         n = Integer.parseInt(st.nextToken());
         start = Integer.parseInt(st.nextToken());
 
         graph = new int[101][101];
         visit = new int[101];
 
         st = new StringTokenizer(in.readLine());
 
         int from, to;
         for(int i=0; i<n/2; i++){
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
 
            graph[from][to] = 1;
         }
         
         res = bfs(start);
         
         System.out.println(String.format("#%d %d", tc, res)); 
      }
   }
 
   private static int bfs(int k) {
      Queue<Integer> q = new LinkedList<Integer>();
      q.offer(k);
 
      int depth = 1;
      visit[k] = depth;
 
      while(!q.isEmpty()){
         k = q.poll();
 
         for(int i=0; i<=100; i++){
            if(graph[k][i]==1 && visit[i]==0){
               q.offer(i);
               visit[i]=visit[k]+1;
            }
         }
 
         depth = Math.max(depth, visit[k]);
      }
 
      for(int i=100; i>=0; i--){
         if(visit[i]==depth){
            return i;
         }
      }
 
      return 0;
   }
}