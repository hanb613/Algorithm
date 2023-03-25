import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, result;
	static List<Integer>[] student;
	static int arr[][];

	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, -1, 0, 1};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        student = new ArrayList[(n*n)+1];
        
        for(int i=0; i<=n*n; i++) {
        	student[i] = new ArrayList<Integer>();
        }

        int stdN;
        for (int i=0; i<n*n; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	stdN=Integer.parseInt(st.nextToken());
        	for(int j=0; j<4; j++) {
            	student[stdN].add(Integer.parseInt(st.nextToken()));        		
        	}
        	
        	Data d = choice(stdN); // 자리 정하기
        	arr[d.x][d.y]=stdN; // 자리 고정
		}

        // 인접한 자리에 있는 좋아하는 학생 수 체크 및 점수 계산
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		int cnt=0;
        		for(int d=0; d<4; d++) { 
        			int nx = i+dx[d];
    				int ny = j+dy[d];
    				
    				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
    				
    				if(student[arr[i][j]].contains(arr[nx][ny])) cnt++; 
        		}
        		
        		if(cnt==1) result+=1;
        		else if(cnt==2) result+=10;
        		else if(cnt==3) result+=100;
        		else if(cnt==4) result+=1000;
        	}
        }
        
        System.out.println(result);
    }
    
    private static Data choice(int num) {
    	List<Data> ret = new ArrayList<Data>();
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(arr[i][j]==0) { // 선택된 자리가 아닐때, 조건 따지기
    				int nx=0, ny=0, cntL=0, cntB=0;
        			for(int d=0; d<4; d++) {
        				nx = i+dx[d];
        				ny = j+dy[d];
        				
        				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
        				
        				if(arr[nx][ny]==0) cntB++; // 인접한 자리가 빈자리라면 cntB++
        				else if(student[num].contains(arr[nx][ny])) cntL++; // 인접한 자리에 좋아하는 학생이 있으면 cntA++
        			}
        			
        			ret.add(new Data(i, j, cntL, cntB)); // 리스트에 해당 자리 정보 넣기
    			}
    		}
    	}
    	
    	Collections.sort(ret); // 조건에 맞게 정렬
    	
    	return ret.get(0);
    }
    
    private static class Data implements Comparable<Data> {
    	int x, y, likeCnt, blankCnt;

		public Data(int x, int y, int likeCnt, int blankCnt) {
			this.x = x;
			this.y = y;
			this.likeCnt = likeCnt;
			this.blankCnt = blankCnt;
		}
		
		@Override
		public int compareTo(Data o) {
			if(this.likeCnt==o.likeCnt) {
				if(this.blankCnt==o.blankCnt) {
					if(this.x==o.x) {
						return this.y-o.y;
					}
					return this.x-o.x;
				}
				return o.blankCnt-this.blankCnt;
			}
			return o.likeCnt-this.likeCnt;
		}
    }
}