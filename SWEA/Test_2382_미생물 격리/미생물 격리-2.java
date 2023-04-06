import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int tc, n, m, k, result;
    static List<Info> list;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        tc = Integer.parseInt(br.readLine());
         
        for(int T=1; T<=tc; T++) {
            st = new StringTokenizer(br.readLine());
             
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
             
            list = new ArrayList<Info>();
             
            result=0;
            int a, b, c, d;
            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken()); 
                b = Integer.parseInt(st.nextToken()); 
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                 
                list.add(new Info(a, b, c, d));
            }
             
            solve();
             
            // m시간 후 남은 미생물
            for(int i=0; i<list.size(); i++) {
                result+=list.get(i).cnt;
            }
             
            System.out.println(String.format("#%d %d", T, result));
        }
    }
     
    private static void solve() {
         
        for(int i=0; i<m; i++) { // m시간동안
            // 미생물 이동
            for(int j=0; j<list.size(); j++) {
                int dir = list.get(j).dir;
                switch(dir) {
                    case 1: // 상
                        list.get(j).x-=1;
                         
                        if(list.get(j).x==0) { // 가장자리
                            list.get(j).cnt/=2; // 절반 죽임
                            list.get(j).dir=2; // 방향 전환
                            if(list.get(j).cnt==0) { // 0이면 리스트에서 삭제
                                 list.remove(j);
                                 j--;
                            }
                        }
                        break;
                         
                    case 2: // 하
                        list.get(j).x+=1;
                         
                        if(list.get(j).x==n-1) {
                            list.get(j).cnt/=2;
                            list.get(j).dir=1;
                            if(list.get(j).cnt==0) {
                                 list.remove(j);
                                 j--;
                            }
                        }
                        break;
                         
                    case 3: // 좌
                        list.get(j).y-=1;
                         
                        if(list.get(j).y==0) {
                            list.get(j).cnt/=2;
                            list.get(j).dir=4;
                            if(list.get(j).cnt==0) {
                                 list.remove(j);
                                 j--;
                            }
                        }
                        break;
                         
                    case 4: // 우
                        list.get(j).y+=1;
                         
                        if(list.get(j).y==n-1) { 
                            list.get(j).cnt/=2;
                            list.get(j).dir=3;
                            if(list.get(j).cnt==0) {
                                 list.remove(j);
                                 j--;
                            }
                        }
                        break;
                }
            }
             
            Collections.sort(list);
             
            // 셀 확인
            for(int j=0; j<list.size()-1; j++) {
                int x = list.get(j).x;
                int y = list.get(j).y;
                 
                if(x==list.get(j+1).x && y==list.get(j+1).y) {
                    list.get(j).cnt+=list.get(j+1).cnt;
                    list.remove(j+1);
                    j--;
                }
            }
        }
    }
 
    private static class Info implements Comparable<Info> {
        int x, y, cnt, dir;
 
        public Info(int x, int y, int cnt, int dir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
 
        @Override
        public int compareTo(Info o) {
            if(this.x==o.x) {
                if(this.y==o.y) {
                    return o.cnt-this.cnt;
                }
                return this.y-o.y;
            }
            return this.x-o.x;
        }
    }
}
 
 
/*
 * 가장자리 이동시 미생물/2, 방향 반대
 * 이동 후, 미생물 여러개 -> 합쳐짐 (방향은 미생물 수가 많은 집단껄로)
 * M 시간 후 남아 있는 미생물 총합
 * 
 */