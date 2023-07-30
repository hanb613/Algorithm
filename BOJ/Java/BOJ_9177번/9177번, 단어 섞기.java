import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int tc;
    static boolean[][] visited;
    static char[] a, b, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tc = Integer.parseInt(br.readLine());

        for(int T=1; T<=tc; T++){
            st = new StringTokenizer(br.readLine());

            a = st.nextToken().toCharArray();
            b = st.nextToken().toCharArray();
            c = st.nextToken().toCharArray();

            visited = new boolean[201][201];

            sb.append("Data set ").append(T).append(": ").append(Solution()).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static String Solution(){
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Info p = q.poll();

            if(p.x+p.y == c.length){ // 조건에 맞게 섞임
                return "yes";
            }

            if(p.x < a.length && !visited[p.x+1][p.y] && c[p.x+p.y] == a[p.x]){
                visited[p.x+1][p.y] = true;
                q.offer(new Info(p.x+1, p.y));
            }
            if(p.y < b.length && !visited[p.x][p.y+1] && c[p.x+p.y] == b[p.y]){
                visited[p.x][p.y+1] = true;
                q.offer(new Info(p.x, p.y+1));
            }
        }

        return "no";
    }

    private static class Info{
        int x, y;

        public Info(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}