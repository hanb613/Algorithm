import java.util.*;
import java.io.*;

public class Main {

    static int tc;
    static String str;
    static boolean check;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        tc = Integer.parseInt(br.readLine());

        for(int T=0; T<tc; T++){
            str = br.readLine();
            check = false;

            Solution(str);

            if(check) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb.toString());

    }

    private static void Solution(String s){

        int left = 0, count=0;
        for(int right=0; right<s.length(); right++){
            if(check) return; // 이미 true 됐으면 더이상 X

            if(s.charAt(left) != s.charAt(right)) { // 문자열 다르면 조건 확인
                if(count>=2){
                    String newStr = s.substring(0, left) + s.substring(right); // 새 문자열 = 남은 왼쪽 + 오른쪽
                    Solution(newStr);
                }
                left = right; count=1;
            } else count++; // 문자열 같으면 count++
        }

        // 마지막에 남은 문자열이 제거할 수 있으면
        if(count==s.length() && s.length()>=2) {
            check=true;
        }
    }

}
