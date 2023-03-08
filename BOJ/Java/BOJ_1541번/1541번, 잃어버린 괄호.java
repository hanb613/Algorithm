import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split("-"); // - 기준으로 분리
		
		int result = 0;
		for(int i=0; i<s.length; i++) {
			int sum = 0;
			String[] str = s[i].split("\\+"); // +기준으로 다시 분리
			
			for(int j=0; j<str.length; j++) {
				sum += Integer.parseInt(str[j]);
			}
			
			if(i==0) { // 처음엔 -가 붙어있지 않아 더하기
				result += sum;
			} else {
				result -= sum;
			}
		}

		System.out.println(result);
	}
}
