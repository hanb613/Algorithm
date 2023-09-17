class Solution {
    
    public int solution(int n) {
        int answer = 0;
        int retCnt = Integer.bitCount(n);
        int numCnt = 0;
        
        while(true){
            
            numCnt = Integer.bitCount(++n);
            
            if(retCnt == numCnt){
                return n;
            }            
        }
    }
}