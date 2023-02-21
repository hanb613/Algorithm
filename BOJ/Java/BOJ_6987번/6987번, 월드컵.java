import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w, d, l, num, ret;
	static int[] win, draw, lose;
	static boolean ans;
	static int[] you = {0,0,0,0,0, 1,1,1,1, 2,2,2, 3,3 ,4};
    static int[] me = {1,2,3,4,5, 2,3,4,5, 3,4,5, 4,5, 5};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st; 
    	StringBuilder sb = new StringBuilder();
    	
    	for(int t=0; t<4; t++) {
    		st = new StringTokenizer(br.readLine());
    		win = new int[6];
            draw = new int[6];
            lose = new int[6];
    		w=d=l=0; ans = false;
    		
    		for(int i = 0; i < 6; i++) {
    			win[i] = Integer.parseInt(st.nextToken());
    			draw[i] = Integer.parseInt(st.nextToken());
    			lose[i] = Integer.parseInt(st.nextToken());
                w += win[i];
                d += draw[i];
                l += lose[i];
            }
            
            
            if(w + d + l == 30) go(0);
            
            if(ans) sb.append("1 ");
            else sb.append("0 ");
    	}
        System.out.println(sb.toString());
    }
    
    private static void go(int game) {
        if(game == 15) {
             ans = true;
             return;
        }
        
        int t1 = me[game];
        int t2 = you[game];
        
        if(win[t1] > 0 && lose[t2] > 0) {
            win[t1]--; lose[t2]--;
            go(game+1);
            win[t1]++; lose[t2]++;
        }
        
        if(lose[t1] > 0 && win[t2] > 0) {
            lose[t1]--; win[t2]--;
            go(game+1);
            lose[t1]++; win[t2]++;
        }
        
        if(draw[t1] > 0 && draw[t2] > 0) {
            draw[t1]--; draw[t2]--;
            go(game+1);
            draw[t1]++; draw[t2]++;
        }
    }
}