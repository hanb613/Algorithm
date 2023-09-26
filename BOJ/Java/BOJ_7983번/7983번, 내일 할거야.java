import java.util.*;
import java.io.*;

public class Main {

    static int n, result;
    static Info[] arr;
    

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        arr = new Info[n];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int d = Integer.parseInt(st.nextToken());
        	int t = Integer.parseInt(st.nextToken());
        	
        	arr[i] = new Info(d, t);
        	
        }
        
        Arrays.sort(arr);
        
        result = arr[0].t;
        
        for(int i=0; i<n; i++) {
        	if(result>=arr[i].t) result=arr[i].t-arr[i].d; // 마지막에 끝난날이 마감일 보다 뒤에 있음
        	else result-=arr[i].d;
        }
        
        System.out.println(result);
    }
    
    private static class Info implements Comparable<Info> {
    	int d, t;
    	
    	public Info(int d, int t) {
    		this.d=d;
    		this.t=t;
    	}

		@Override
		public int compareTo(Info o) {
			if(this.t==o.t) {
				return o.d-this.d;
			}
			return o.t-this.t;
		}
    }
}