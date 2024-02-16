import java.util.*;

class Solution {
    
    static int row, col, count, idx = 1;
    static int[][] arr;
    static boolean[][] visited;
    
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
    
    static HashMap<Integer, Integer> map = new HashMap<>();
    static HashSet<Integer> type = new HashSet<>();
    static LinkedList<Info> q = new LinkedList<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        
        row = land.length;
        col = land[0].length;

        arr = new int[row][col];
        visited = new boolean[row][col];
        
        // 영역별 총 석유량 구하기
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(visited[i][j] || land[i][j] == 0) continue;
                
                BFS(i, j, land);
            }
        }
        
        for(int j=0; j<col; j++) {
            int maxRet = 0;
            type.clear();
            
            // 해당 열이 지나는 영역 구하기
            for(int i=0; i<row; i++) {
                if(arr[i][j] > 0) type.add(arr[i][j]);
            }
            
            for(Integer s : type){
                maxRet+=map.get(s);
            }
            
            answer = Math.max(answer, maxRet);
        }
        
        return answer;
    }
    
    private static void BFS(int x, int y, int[][] land){
        q.clear();
        
        count = 0;
        arr[x][y] = idx;
        visited[x][y] = true;
        q.add(new Info(x, y));
        
        while(!q.isEmpty()){
            Info p = q.poll();
            count++;
            
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                
                if(nx<0 || ny<0 || nx>=row || ny>=col) continue;
                if(visited[nx][ny] || land[nx][ny] == 0) continue;

                q.add(new Info(nx, ny));
                visited[nx][ny] = true;
                arr[nx][ny] = idx;
            }
        }
        
        map.put(idx++, count); // 해당 영역의 크기
    }
    
    private static class Info{
        int x, y;
        
        public Info(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}