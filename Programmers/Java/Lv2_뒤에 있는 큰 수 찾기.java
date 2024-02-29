class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        int n = numbers.length;
        
        answer[n-1] = -1;
        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(numbers[i] < numbers[j]) {
                    answer[i] = numbers[j]; break;
                } else {
                    if(numbers[i] < answer[j]){
                        answer[i] = answer[j]; break;
                    } else if(answer[j] == -1) {
                        answer[i] = -1; break;
                    }
                }
            }
        }
        
        return answer;
    }
}