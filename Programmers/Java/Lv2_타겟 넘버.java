import java.util.*;
import java.io.*;

class Solution {
    private static int result;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        solve(0, 0, numbers, target);
        
        answer = result;
        return answer;
    }
    
    private static void solve(int k, int sum, int[] numbers, int target){
        if(k==numbers.length){
            if(sum==target) result++;        
            return;
        }
        
        solve(k+1, sum+numbers[k], numbers, target);
        solve(k+1, sum-numbers[k], numbers, target);
    }
}