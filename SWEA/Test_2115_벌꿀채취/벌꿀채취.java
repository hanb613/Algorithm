import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int tc, n, m, c, tmpMax, result;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        tc = Integer.parseInt(br.readLine());
        for (int T = 1; T <= tc; T++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 벌통 크기
            m = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수
            c = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양
            arr = new int[n][n]; // 꿀의 양
            result=0;
            
            // 꿀의 양 입력 받기
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j <n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            Solve();
            
            System.out.println("#" + T + " " + result);
        }
    }
    
    private static void Solve() {
		int max1, max2;

		for(int i=0; i<n; i++) {
			for(int j=0; j<=n-m; j++) {
				// 일꾼1 벌통 선택
				tmpMax=0;
				
				Subset(i, j, 0, 0, 0);
				max1=tmpMax; // j열에서 벌통을 선택했을 때, 일꾼1이 얻은 최대 이익
				
				// 일꾼2 벌통 선택
				tmpMax=0; max2=0;
				for (int c=j+m; c<=n-m; c++) { // 일꾼1의 다음 열에서 선택
					Subset(i, c, 0, 0, 0);
					max2 = Math.max(max2, tmpMax);
				}

				for (int r=i+1; r<n; r++) { // 일꾼1의 다음 행에서 선택
					for (int c=0; c<=n-m; c++) {
						Subset(r, c, 0, 0, 0);
						max2 = Math.max(max2, tmpMax);
					}
				}
				
				result = Math.max(result, max1+max2); // 최대값 갱신
			}
		}
	}
 
    private static void Subset(int x, int y, int cnt, int sum, int total) {
        if(sum>c) return; // 채취할 수 있는 최대 양이 넘어서면 리턴
       
        if(cnt==m) { // 선택할 수 있는 벌통의 개수를 채웠다면 ? 최대값 갱신 후 리턴
            tmpMax = Math.max(tmpMax, total);
            return;
        }
 
        Subset(x, y+1, cnt+1, sum+arr[x][y], total+(arr[x][y]*arr[x][y])); // 채취 O
        Subset(x, y+1, cnt+1, sum, total); // 채취 X
    }
}