import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


/* 
 * 예외 tc
 * 	3 1
	30 30 20
	
	3 1
	18 19 20
 * */

public class Main {
	
	static int n, k, result;
	static Integer[] arr;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new Integer[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1%10 == o2%10) {
					return o1-o2;
				}
				return o1%10 - o2%10;
			}
		});
		
		// 20 -> 1번 자름 (조각 +2)
		// 23 -> 3번 자름 (조각 +2)
		//System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<n; i++) {
			if(arr[i]<0) continue; // 10보다 작으면 X
			
			if(arr[i]==10) result++; // 10이면 컷팅 X
			else {
				if(k>0) { // 남은 컷팅 횟수가 있으면
					if(arr[i]%10 != 0) { // 10의 배수가 아닌거
						if(k<arr[i]/10) {  // 남은 컷팅 횟수 < 길이 10씩 만들기 위한 컷팅 횟수
							result += k;
							break;
						} else k-=(arr[i]/10);
						
					} else { // 10의 배수
						if(k<(arr[i]/10)-1) {
							result += k;
							break;
						} else k-=((arr[i]/10)-1);
					}

					result+=arr[i]/10;
				}
			}
		}
		
		System.out.println(result);
	}
}
