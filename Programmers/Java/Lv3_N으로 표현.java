class Solution {
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int N, int number) {
        DFS(0, N, number, 0);
        
        if (answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
    
    public void DFS(int depth, int k, int num, int calc) {
        if (depth > 8) return;
        
        if (num == calc) {
            answer = Math.min(depth, answer);
            return;
        }
        
        int tmp = 0;
        for (int i=0; i<8; i++) {
            if (depth+i < 8) {
                tmp = tmp*10 + k;
                DFS(depth+i+1, k, num, calc + tmp);
                DFS(depth+i+1, k, num, calc - tmp);
                DFS(depth+i+1, k, num, calc / tmp);
                DFS(depth+i+1, k, num, calc * tmp);     
            }      
        }
    }
}