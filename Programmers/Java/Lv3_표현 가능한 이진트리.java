import java.util.*;

class Solution {
    
    static int result;
    static int[] answer;
    static boolean[] binaryArr;
    
    public int[] solution(long[] numbers) {
        
        answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);

            int tree = 0, h = 1;
            while (tree < binary.length()){
                tree = (int) Math.pow(2, h++) - 1;
            }

            binaryArr = new boolean[tree];
            
            int idx = tree - binary.length();
            for(int j=0; j<binary.length(); j++) {
                if(binary.charAt(j) == '1') {
                    binaryArr[idx++] = true;
                } else{
                    binaryArr[idx++] = false;
                }
            }

            result = 1;
            isPossible(0, tree-1, binaryArr[(tree-1)/2]);
            answer[i] = result;
        }
        
        return answer;

    }

    public static void isPossible(int left, int right, boolean rootCheck) {
        if(result == 0) return;
        
        int mid = (left+right)/2;
        
        if(!rootCheck && binaryArr[mid]) { // 루트는 0인데, 자식이 1 ? X
            result = 0;
            return;
        }

        if(left != right) {
            isPossible(left, mid-1, binaryArr[mid]); // 왼쪽
            isPossible(mid+1, right, binaryArr[mid]); // 오른쪽
        }
    }
}