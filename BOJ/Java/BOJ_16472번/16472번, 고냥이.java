import java.util.*;
import java.io.*;

public class Main {

    static int n, result;
    static HashMap<Character, Integer> map;
    static char[] str;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        str = br.readLine().toCharArray();
        map = new HashMap<>();

        int left=0, right=0, preLeft=0;
        while(right<str.length && left<=right){
        	
        	if(preLeft==left){
                if(map.size()==0 || !map.containsKey(str[right])) {
                	map.put(str[right], 1);
                }
                else {
            		map.replace(str[right], map.get(str[right])+1);
            	}
            }
        	
            if(map.size()<=n){
                result = Math.max(result, right-left+1);
                preLeft=left;
                right++;
            } else {
            	int num = map.get(str[left])-1;
                if(num==0){
                    map.remove(str[left]);
                } else {
                    map.replace(str[left], num);
                }
                left++;
            }
        }

        System.out.println(result);
    }
}