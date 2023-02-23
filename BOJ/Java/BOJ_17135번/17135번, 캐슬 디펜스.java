import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n, m, d, ret, count;
    static int[][] arr, OriginalArr;
    static int[] archer; // 궁수 담는 배열
    static boolean[] archerVisit;  // 궁수 선택 여부 
    static List<Data>[] enemy; // 적의 데이터 담는 리스트
    static Set<Data> result; // 제거된 적의 데이터 담는 Set -> 중복 제거를 위해
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); 
        d = Integer.parseInt(st.nextToken());
        
        OriginalArr = new int[n][m];
        arr = new int[n][m];
        archer = new int[m];        
        archerVisit = new boolean[m];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		OriginalArr[i][j]= Integer.parseInt(st.nextToken());
        	}
        }
        
        SelectArcher(0, 0);
        
        System.out.println(ret);
    }
    
    private static void SelectArcher(int k, int cnt) { // m개의 자리 중 자리  3개 선택
        if(cnt==3) { // 자리 3개가 선택 됐다면 ?
        	
        	// 배열 복사
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<m; j++) {
        			arr[i][j] = OriginalArr[i][j];
        		}
        	}
        	
            count=0;
        	startGame();
        	ret = Math.max(ret, count); // 제거할 수 있는 적의 수 갱신
        	return;
        }
        
        for(int i=k; i<m; i++) {
        	if(!archerVisit[i]) {
        		archerVisit[i]=true;
        		archer[cnt]=i;
        		SelectArcher(i+1, cnt+1);
        		archerVisit[i]=false;
        	}
        }
    }
 
    private static boolean checkZero() { // 모든 적이 격자판에서 제외되었는지 확인
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(arr[i][j]!=0) return true;
    		}
    	}
    	return false;
    }
    
    private static void startGame() { // 거리 계산 + 궁수 공격 + 적 이동
    	
    	enemy = new ArrayList[3];
    	result = new HashSet<Data>();
    	for(int i=0; i<3; i++) {
        	enemy[i] = new ArrayList<Data>();
    	}
    	
    	while(checkZero()) { // 제거할 적이 있다면 ?
        	// 거리 계산해서 공격할 수 있는 적 넣기 
            for(int i=0; i<n; i++) {
            	for(int j=0; j<m; j++) {
            		if(arr[i][j]==1) { // 적이면 거리 계산
            			int diff=0;
            			for(int k=0; k<3; k++) {
            				diff = Math.abs(n-i) + Math.abs(archer[k]-j); // 거리 계산
            				
            				if(diff<=d) { // 궁수가 공격할 수 있는 범위라면 ? 해당 궁수 배열에 적 데이터 넣기
            					enemy[k].add(new Data(i, j, diff));
            				}
            			}
            		}
            	}
            }
            
            // 공격하기
            for(int i=0; i<3; i++) {
            	if(enemy[i].size()!=0) {
                	Collections.sort(enemy[i]); // d이하 중 가장 가까운 적이고, 가장 왼쪽에 있는 적 -> 정렬
  
                	Data d = enemy[i].get(0);
                	arr[d.x][d.y]=0; // 해당 자리의 수 0으로 
                	result.add(new Data(d.x, d.y)); // 적의 데이터 넣기     		
            	}
            }
            count+=result.size(); // 각 궁수가 공격한 적의 수 더하기 (똑같은 적은 중복 제거 된 상태)
        	
            // 적 이동 -> 배열 옮기기
            for(int i=n-1; i>=0; i--) {
            	for(int j=0; j<m; j++) {
            		if(i==0) arr[i][j]=0;
            		else arr[i][j] = arr[i-1][j];
            	}
            }
            
            result.clear();
            for(int i=0; i<3; i++) {
            	enemy[i].clear();
        	}
    	}
    }
    
    private static class Data implements Comparable<Data>{
    	int x, y, dist;
    	public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
    	
		public Data(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Data o) { // d이하 중 가장 가까운 적이고, 가장 왼쪽에 있는 적
			if(this.dist==o.dist) {
				return this.y-o.y;
			}
			return this.dist-o.dist;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Data) {
				Data pair = (Data) obj;
				return pair.x==this.x && pair.y == this.y;
			}else {
				return false;
			}
		}
		
		@Override
		public int hashCode() {
			return String.valueOf(this.x).hashCode() + String.valueOf(this.y).hashCode();
		} 
    }
}