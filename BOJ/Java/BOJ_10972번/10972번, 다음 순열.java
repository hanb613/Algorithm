import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static Integer[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new Integer[n];
        
        StringTokenizer	st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(!Solution()) System.out.println(-1);
        else {
        	for(int i : arr) {
        		System.out.print(i + " ");
        	}
        }
    }
    
    private static boolean Solution() {
    	int idx = n-1;
    	
    	while(idx>0 && arr[idx-1] >= arr[idx]){ 
    		idx--;
        }
    	
    	if(idx<=0) return false;
    	
    	int j = arr.length-1;
        while(arr[idx-1] >= arr[j]){
            j--;
        }
        
        swap(idx-1, j);
        
        Arrays.sort(arr, idx, arr.length);

        return true;
    }
    
    static Integer[] swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }
}