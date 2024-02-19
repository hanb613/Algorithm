import java.util.*;

class Solution {
    
    static int[][] arr;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        arr = new int[rows][columns];
        
        // 배열 초기화
        int val = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j] = val++;        
            }
        }
        
        // 배열 회전
        int idx = 0;
        for(int j=0; j<queries.length; j++){
            
            int x1 = queries[j][0]-1;
            int y1 = queries[j][1]-1;
            int x2 = queries[j][2]-1;
            int y2 = queries[j][3]-1;
            
            int tmp = arr[x1][y2]; // overwrite 되는 부분
            int minNum = tmp;
            
            // 위쪽 (왼->오 / 오른쪽으로 이동)
            for(int i=y2; i>y1; i--){
                arr[x1][i] = arr[x1][i-1];
                minNum = Math.min(minNum, arr[x1][i]);
            }
            
            // 왼쪽 (아래->위 / 위쪽으로 이동)
            for(int i=x1; i<x2; i++){
                arr[i][y1] = arr[i+1][y1];
                minNum = Math.min(minNum, arr[i][y1]);
            }
            
            // 아래쪽 (오->왼 / 왼쪽으로 이동)
            for(int i=y1; i<y2; i++){
                arr[x2][i] = arr[x2][i+1];
                minNum = Math.min(minNum, arr[x2][i]);
            }
            
            // 오른쪽 (위->아래 / 아래쪽으로 이동)
            for(int i=x2; i>x1; i--){
                arr[i][y2] = arr[i-1][y2];
                minNum = Math.min(minNum, arr[i][y2]);
            }
            
            arr[x1+1][y2] = tmp;
            
            // 이동한 숫자 중 최솟값
            answer[idx++] = minNum;
        }
        
        return answer;
    }
}