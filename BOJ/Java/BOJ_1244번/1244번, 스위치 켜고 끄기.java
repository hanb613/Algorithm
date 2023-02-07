import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            if(sex==1) {
                for(int j=cnt; j<=n; j+=cnt) { // 해당 숫자의 배수 위치 스위치 상태 바꿈
                    if(arr[j]==0) arr[j]=1;
                    else arr[j]=0;
                }


            }
            else {
                if(arr[cnt]==0) arr[cnt]=1; // 여학생이 받은 스위치 상태 바꿈
                else arr[cnt]=0;

                for(int j=1; j<=n/2; j++) {
                    int left = cnt-j;
                    int right = cnt+j;
                    if(left<1 || right>n) break; // 범위 벗어나면 X
                    if(arr[left] != arr[right]) break; // 양 쪽 값이 다르면 X
                    
                    if(arr[left]==0) { // 상태 바꿈
                        arr[right] = arr[left]=1;
                    }
                    else {
                        arr[right] = arr[left]=0;
                    }
                    
                }
            }
        }
        for(int i=1; i<=n; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0) {
				System.out.println();				
			}
		}

    }
}