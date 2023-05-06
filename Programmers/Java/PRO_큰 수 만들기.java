class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int len = number.length() - k; // k개 제거하고 만들 수 있는 수
        int start = 0;
        
        for(int i=0; i<len; i++) {
            int max=0;
            for (int j=start; j<=i+k; j++) {
                if (max<number.charAt(j)-'0') {
                    max=number.charAt(j)-'0';
                    start=j+1;
                }
            }
            answer.append(Integer.toString(max));
        }
        
        return answer.toString();
    }
}