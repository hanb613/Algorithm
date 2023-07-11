import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, w, t, k, result;
	static int[] arr;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
		arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Solution(1, w);

		System.out.println(result);
	}

	public static void Solution(int time, int idx) {

		int[] fireArr = new int[n];

		// 인접한 모닥불 개수 세기 
		for (int i = 0; i < n; i++) {
			if (time > 1 && i==idx) {  // 이전에 장작 넣은 부분
				fireArr[i] = 3;
				continue;
			}

			// 왼쪽 오른쪽 확인
			fireArr[i] = count(i);
		}

		// 화력감소
		for (int i=0; i<n; i++) {
        	if(fireArr[i]==0)
        		arr[i]-=3;
        	else if(fireArr[i]==1)
        		arr[i]-=2;
        	else if(fireArr[i]==2)
        		arr[i]-=1;
		}

		// 종료 - 안꺼진 모닥불 세기
		if (time>=t) {
			int cnt=0;
			for (int i=0; i<n; i++) {
				if (arr[i]>0) cnt++;
			}

			if (cnt>=k) result++;

            // 화력감소 - 되돌리기
			for (int i=0; i<n; i++) {
	        	if(fireArr[i]==0)
	        		arr[i]+=3;
	        	else if(fireArr[i]==1)
	        		arr[i]+=2;
	        	else if(fireArr[i]==2)
	        		arr[i]+=1;	
			}
			
			return;
		}
		
		if (idx-1>=0) { // 내 왼쪽
			Solution(time+1, idx-1);			
		}
		
		Solution(time+1, idx); // 현재 위치
		
		if (idx+1<n) { // 내 오른쪽
			Solution(time+1, idx+1);			
		}

        // 화력감소 - 되돌리기
		for (int i=0; i<n; i++) {
        	if(fireArr[i]==0)
        		arr[i]+=3;
        	else if(fireArr[i]==1)
        		arr[i]+=2;
        	else if(fireArr[i]==2)
        		arr[i]+=1;		
		}
	}

	public static int count(int idx) {
		int cnt = 0;
		
		if (idx-1>=0 && arr[idx-1]>0) cnt++;
		if (idx+1<n && arr[idx+1]>0) cnt++;
		
		return cnt;
	}
}