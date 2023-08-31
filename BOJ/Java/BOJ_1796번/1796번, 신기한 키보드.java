import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int n, result;
	static int[] start, end, dp;
	static int[][] indexList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		start = new int[26];
		end = new int[26];
        indexList = new int[26][2];
		
		for (int i = 0; i < 26; i++) {
            start[i] = end[i] = -1;
        }
		
		// 각 알파벳의 시작과 끝 위치 저장
		int size = 0;
        for (char c : s.toCharArray()) {
            int i = c-'a';
            if (start[i] == -1) {
                start[i] = end[i] = size;
            } else {
                end[i] = size;
            }

            size++;
        }
        
        
        result = Integer.MAX_VALUE;
        solution(0, 0, 0);
        
        System.out.println(result+size);
    }

	private static void solution(int k, int pre, int cnt) {
		
		if (cnt > result) return; // 지금 result보다 크면 X
        if (k == 26) { // a~z까지 탐색 완료
        	result = Math.min(result, cnt);
            return;
        }
        
        int maxIndex = indexList[k][0]; // 제일 오른쪽에 있는 idx
        int minIndex = indexList[k][1]; // 제일 왼쪽에 있는 idx
        
        if (minIndex != -1 && maxIndex == minIndex) { // 문자 1개 
        	solution(k + 1, maxIndex, cnt + Math.abs(pre - minIndex) + Math.abs(maxIndex - minIndex));
        } else if (maxIndex != -1 && maxIndex != minIndex) { // 문자 2개 이상
        	solution(k + 1, maxIndex, cnt + Math.abs(pre - minIndex) + Math.abs(maxIndex - minIndex));
        	solution(k + 1, minIndex, cnt + Math.abs(pre - maxIndex) + Math.abs(maxIndex - minIndex));
        } else { // 문자 0개
        	solution(k + 1, pre, cnt);
        }
	}
}