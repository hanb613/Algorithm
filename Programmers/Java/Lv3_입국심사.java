import java.util.*;

class Solution {
    
    static long sum, left, right, mid;
    
    public long solution(int n, int[] times) {
        
        long answer = 0;
        
        Arrays.sort(times);
        
        left = 0;
        right = (long)n * times[times.length-1];
        
        while(left<=right){
            sum = 0;
            mid = (left+right)/2;
            
            for(long t : times){
                sum+=(mid/t); // mid 값으로 각 심사관이 심사 할 수 있는 사람 수 
            }
            
            if(sum < n){ // mid 값으로 모든 사람을 심사 할 수 없음
                left = mid + 1;
            } else { // mid 값으로 모두 검사 할 수 있지만, 최소값 가능성 O
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}