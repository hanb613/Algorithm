import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 앞에 문자를 하나씩 잘라 문자열이 팰린드롬인지 찾기
 * if) 팰린드롬일 경우, 그 문자열 왼쪽에 있는 길이만큼 오른쪽에 붙이면 팰린드롬이 된다.
 
 * aabb => aabbaa (6)
 * _ _ bb => _ _ bb _ _
 
 * */

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int result = s.length();
        
        for(int i=0; i<s.length(); i++) {
        	if(solve(s.substring(i))) break;
        	result++;
        }
        System.out.println(result);
    }
    
    private static boolean solve(String str) {
    	int start = 0;
    	int end = str.length()-1;
    	while(start<=end) {
    		if(str.charAt(start)!=str.charAt(end)) return false;
    		start++;
    		end--;
    	}
    	return true;
    }
}
