import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<n; i++) {
			list.add(br.readLine());
		}
		
		int size = list.get(0).length();
		
		for(int i = 0; i < size; i++) {
			List<String> sub = new ArrayList<>();

			for(int j=0; j<n; j++) {
				String tmp = list.get(j);
				tmp = tmp.substring(size-i-1, size);

				if(!sub.contains(tmp)) {
					sub.add(tmp);
				} else break;	
			}
			
			if(n == sub.size()) {
				System.out.println(i+1);
				break;
			}
		}
	}
}