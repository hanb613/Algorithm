import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0, idx=0;
        Arrays.sort(people);
        
         for (int i=people.length-1; i>=idx; i--) {
            if (people[i] + people[idx] <= limit) {
                idx++;
                answer++;
            }
            else {
                answer++;
            }
        }
        return answer;
    }
}