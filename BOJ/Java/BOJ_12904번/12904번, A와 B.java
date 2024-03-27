import java.io.*;
import java.util.*;

public class Main {
	
	static String S, T;
	static StringBuilder t;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		T = br.readLine();
		
        t = new StringBuilder(T);

        // T -> S : S와 t의 길이가 같아질 때까지 반복
        for (int i=t.length()-1; i > S.length()-1; i--) {
            if (t.charAt(i) == 'B') { // 맨 뒤의 문자열이 B일 경우, B를 제거하고 문자열을 뒤집음
                t.deleteCharAt(i);
                t.reverse();
            } else { // 맨 뒤의 문자열이 A일 경우, A 제거
                t.deleteCharAt(i);
            }
        }

        if (S.equals(t.toString())) {
            System.out.println(1);
        } else System.out.println(0);
		
	}
}