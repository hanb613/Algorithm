import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, total, result = Integer.MAX_VALUE;
	static int[] num;
	static ArrayList<Integer>[] graph;
	static ArrayList<Integer> groupA;
	static ArrayList<Integer> groupB;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st;
	     
	     n=Integer.parseInt(br.readLine()); // 구역수
	     num= new int[n+1];
	     groupA= new ArrayList<Integer>();
	     groupB= new ArrayList<Integer>();
	     visit = new boolean[n+1];
	     graph = new ArrayList[n+1];
	     graph[0] = new ArrayList<Integer>();
	     
	     st = new StringTokenizer(br.readLine());
	     for(int i=1; i<=n; i++) {
	    	 num[i]=Integer.parseInt(st.nextToken()); // 인구 수
	    	 total+=num[i];
	     }
	     
	     int m;
	     for(int i=1; i<=n; i++) { // 인접 구역 정보
	    	 graph[i] = new ArrayList<Integer>();
	    	 
	    	 st = new StringTokenizer(br.readLine());
	    	 m = Integer.parseInt(st.nextToken());
		     for(int j=1; j<=m; j++) {
		    	 graph[i].add(Integer.parseInt(st.nextToken()));
		     }
	     }
	     
	     Solution(1, 0);
	     
	     if(result!=Integer.MAX_VALUE) {
		     System.out.println(result);	    	 
	     } else {
	    	 System.out.println(-1);
	     }
	}
	
	private static void Solution(int k, int cnt) {
		if(cnt>0 && cnt<n) { // 각 그룹에 적어도 하나의 구역을 포함하도록
			for(int i=1; i<=n; i++) { // groupA에 없으면 groupB
				if(!groupA.contains(i)) groupB.add(i);
			}
			
			if(BFS(groupA) && BFS(groupB)) { // groupA, groupB 둘 다 이어져있는지
				// 인구 차이 최솟값 계산
				int sum=0;
				for(int i=0; i<groupA.size(); i++) {
					sum+=num[groupA.get(i)];
				}
				result = Math.min(result, Math.abs(2*sum-total));
			}
			groupB.clear();
		}
		
		for(int i=k; i<=n; i++) {
			if(visit[i]) continue;
			
			visit[i]=true;
			groupA.add(i);
			Solution(i, cnt+1);
			groupA.remove(groupA.size()-1);
			visit[i]=false;
		}
	}
	
	private static boolean BFS(ArrayList<Integer> group) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visitQ = new boolean[n+1];
		
		q.offer(group.get(0));
		visitQ[group.get(0)]=true;
		int cntCheck=1; // 이어진 개수 확인
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i<graph[now].size(); i++) {
				int tmp = graph[now].get(i);
				if(visitQ[tmp]) continue;
				if(group.contains(tmp)) { // 해당 구역이랑 이어져있으면 ? 
					visitQ[tmp]=true; // 방문체크
					q.offer(tmp); // 큐에 넣기
					cntCheck++; // 이어진 개수 +1
				}
			}
		}

		if(cntCheck==group.size()) return true; // 모두 이어져있으면 true
		else return false; 
		
	}
}
