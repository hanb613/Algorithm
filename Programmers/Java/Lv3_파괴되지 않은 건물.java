class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int R = board.length;
        int C = board[0].length;
        int[][] arr = new int[R+1][C+1];
        
        for(int[] s : skill){
            if(s[0]==1){ // ���� ���� 
                arr[s[1]][s[2]] -= s[5];
                arr[s[1]][s[4]+1] += s[5];
                arr[s[3]+1][s[2]] += s[5];
                arr[s[3]+1][s[4]+1] -= s[5];
            } else { // �Ʊ��� ȸ��
                arr[s[1]][s[2]] += s[5];
                arr[s[1]][s[4]+1] -= s[5];
                arr[s[3]+1][s[2]] -= s[5];
                arr[s[3]+1][s[4]+1] += s[5];
            }
        }
        
        // ���� ������
        for(int r=0; r<R+1; r++){
            for(int c=0; c<C; c++){
                arr[r][c+1] += arr[r][c];
            }
        } 
        
        for(int c=0; c<C+1; c++){
            for(int r=0; r<R; r++){
                arr[r+1][c] += arr[r][c];
            }
        }
        
        // �ı����� ���� �ǹ� ã��
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(arr[r][c] + board[r][c] > 0) answer++;
            }
        }
        
        return answer;
    }
}
}