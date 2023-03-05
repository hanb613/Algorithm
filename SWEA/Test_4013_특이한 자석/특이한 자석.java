import java.io.*;
import java.util.*;

public class Solution {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int T=1; T<=tc; T++) {
			int result=0;
			
			int num = Integer.parseInt(br.readLine());
			
			String[] arr = new String[5];
			for(int i=1; i<=4; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i]="";
				for(int j=0; j<8; j++) {
					arr[i]+=st.nextToken();
				}
			}
			
			for(int i=0; i<num; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				// 1번 회전 => 2->3->4순 비교 후 회전
				if(n==1) {
					if(arr[1].charAt(2) != arr[2].charAt(6)) { // 1 2번 극이 다르면 => 2번, 3번 비교 후 회전
						if(arr[2].charAt(2) != arr[3].charAt(6)) { // 2 3번 비교
							if(arr[3].charAt(2) != arr[4].charAt(6)) { // 3 4 번 비교
								arr[4] = Rotation(arr[4], -dir); // 3번이 회전함으로써, 3번과 반대 방향
							}
							arr[3] = Rotation(arr[3], dir); // 2번이 회전함으로써, 2번과 반대 방향으로
						}
						arr[2] = Rotation(arr[2], -dir); // 1번과 반대 방향으로
					}
					arr[1] = Rotation(arr[1], dir);
				}
				
				// 2번 회전 => 1번은 따로 + 3->4순 비교 후 회전
				else if(n==2) {
					if(arr[1].charAt(2) != arr[2].charAt(6)) { // 2 1 비교
						arr[1] = Rotation(arr[1], -dir);
					}
					
					if(arr[2].charAt(2) != arr[3].charAt(6)) { // 2 3 비교
						if(arr[3].charAt(2) != arr[4].charAt(6)) { // 3 4 비교
							arr[4] = Rotation(arr[4], dir);
						} 
						arr[3] = Rotation(arr[3], -dir); 
					}
					
					arr[2] = Rotation(arr[2], dir);
				}
				
				// 3번 회전 => 4번은 따로 + 2->1순 비교 후 회전
				else if(n==3) {
					
					if(arr[3].charAt(2) != arr[4].charAt(6)) { // 3 4 비교
						arr[4] = Rotation(arr[4], -dir); 
					}
					
					if(arr[2].charAt(2) != arr[3].charAt(6)) { // 2 3 비교
						if(arr[1].charAt(2) != arr[2].charAt(6)) { // 2 1 비교
							arr[1] = Rotation(arr[1], dir);
						}
						arr[2] = Rotation(arr[2], -dir); 
					}
					
					arr[3] = Rotation(arr[3], dir);
				}
				
				// 4번 회전 => 3->2->1순 비교 후 회전
				else {
					if(arr[3].charAt(2) != arr[4].charAt(6)) { // 3 4 비교
						if(arr[2].charAt(2) != arr[3].charAt(6)) { // 2 3 비교
							if(arr[1].charAt(2) != arr[2].charAt(6)) {  // 1 2 비교
								arr[1] = Rotation(arr[1], -dir); 
							}
						arr[2] = Rotation(arr[2], dir);
						}
						arr[3] = Rotation(arr[3], -dir); 					
					}
					arr[4] = Rotation(arr[4], dir); 
				}	
			}
			
			if(arr[1].charAt(0) == '1') result +=1;
			if(arr[2].charAt(0) == '1') result +=2;
			if(arr[3].charAt(0) == '1') result +=4;
			if(arr[4].charAt(0) == '1') result +=8;
			
			System.out.println("#"+T+" "+ result);
		}
		
	}
	
	public static String Rotation(String str, int dir) {
		String ret="";
		
		if(dir>0) { // 시계 방향
			for(int i=0; i<8; i++) {
				ret += str.charAt((i+7)%8);
			}
		}
		else { // 반시계 방향
			for(int i=0; i<8; i++) {
				ret += str.charAt((i+1)%8);
			}
		}
		
		return ret;
	}
}

