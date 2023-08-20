class Solution {
    
    static int[][] arr;
    static int n, m, arrLength;
    
    public boolean solution(int[][] key, int[][] lock) {
        
        n = lock.length; // N
        m = key.length; // M
        arrLength = n+(2*(m-1));
        
        arr = new int[arrLength][arrLength]; // �迭 Ȯ��
        
        // Ȯ���Ų �迭 �߾ӿ� key 
        arr = copyArr(key, lock, arr);
        
        for(int i=0; i<=arrLength-m; i++){
            for(int j=0; j<=arrLength-m; j++){
                for(int t=0; t<4; t++){
 
                    // key�� �� �� �ִ��� ?
                    if(isOpen(i, j, key, arr)) return true;
                    
                    // key - 90�� ȸ��
                    key = rotateArr(key);

                    // arr �迭 �ʱ�ȭ
                    arr = copyArr(key, lock, arr);
                }
            }
        }
        
        return false;
    }
    
    private static int[][] copyArr(int[][] key, int[][] lock, int[][] arr){
        int[][] tmpArr = new int[arrLength][arrLength];
        
        for(int i=m-1; i<=m+n-2; i++){
            for(int j=m-1; j<=m+n-2; j++){
                tmpArr[i][j] = lock[i-(m-1)][j-(m-1)];
            }
        }
        
        return tmpArr;
    }
    
    private static boolean isOpen(int x, int y, int[][] key, int[][] arr){
        
        int keyX=0;
        for(int i=x; i<x+m; i++){
            int keyY=0;
            for(int j=y; j<y+m; j++){
            	arr[i][j] += key[keyX][keyY++];  
            }
            keyX++;
        }
        
        for(int i=m-1; i<=m+n-2; i++){
            for(int j=m-1; j<=m+n-2; j++){
                if(arr[i][j]!=1) return false;
            }
        }
        
        return true;
    }
    
    private static int[][] rotateArr(int[][] key){
	    int[][] rotated = new int[m][m];

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < m; j++) {
	            rotated[i][j] = key[m-1-j][i];
	        }
	    }
	    
	    return rotated;
    }
}