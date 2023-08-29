import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        
        left[0] = a[0];
        for(int i=1; i<n; i++) {
            left[i] = Math.min(left[i-1], a[i]);
        }
        
        right[n-1] = a[n-1];
        for(int i=n-2; i>=0; i--) {
            right[i] = Math.min(right[i+1], a[i]);
        }
        
        // 나보다 작은 수가 2번 이상 다가오면 X
        for(int i=0; i<n; i++){
            int cnt=0;
            if(a[i] != left[i]) cnt++;
            if(a[i] != right[i]) cnt++;
            if(cnt>=2) answer++;
        }
        
        return n - answer;
    }
}