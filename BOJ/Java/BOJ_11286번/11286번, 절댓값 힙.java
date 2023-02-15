import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		PriorityQueue<Integer> pqA = new PriorityQueue<>(); // 양수 저장
		PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder()); // 음수 저장
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num!=0) {
				if(num<0) pqB.add(num);		
				else pqA.add(num);
			} else {
				if(pqB.isEmpty() && pqA.isEmpty()) System.out.println(0); // 둘 다 비어 있는 경우 
				else if(!pqB.isEmpty()) { // 가장 작은 수 => 음수를 먼저 출력
					if(!pqA.isEmpty() && Math.abs(pqB.peek()) > pqA.peek()) { // A의 top과 B의 top => 절대값 비교
						System.out.println(pqA.poll());
					}
					else System.out.println(pqB.poll());
				}
				else System.out.println(pqA.poll()); // 음수가 없는 경우, 양수 출력
			}
		}
	}

}