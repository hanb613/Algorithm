import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        
        int answer = 1;
        
        int size = scores.length;
        int wonhoX = scores[0][0];
        int wonhoY = scores[0][1];
        
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1]; // 동료 점수 - 오름차순 
            }
            return o2[0] - o1[0]; // 근무 태도 - 내림차순
        });

        int maxScore = scores[0][1];
        
        for(int i = 1; i<size; i++) {
           if (scores[i][1] < maxScore) { // 인센티브 X
               if (scores[i][0] == wonhoX && scores[i][1] == wonhoY){
                   return -1;
               }
               
               scores[i][0] = scores[i][1] = 0;
           } else {
                maxScore = scores[i][1];
           }
        }
        
        // 점수 합으로 정렬
        Arrays.sort(scores, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        
        for(int i=0; i<size; i++) {
            if (scores[i][0] + scores[i][1] <= wonhoX + wonhoY) break;
            answer++;
        }
        
        return answer;
    }
}