import java.io.*;
import java.util.*;

public class Solution_SWEA_1267_작업순서_D6_김유정_139ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int testCase = 0;
		while(++testCase <= 10) {
			sb.append("#" + testCase + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken()); // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수
			
			int[] degree = new int[V+1]; // 진입 차수를 저장할 배열
			
			List<Integer>[] adjList = new ArrayList[V+1];
			for(int i = 1; i <= V; i++) {
				adjList[i] = new ArrayList<>();	
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from].add(to);
				degree[to]++;
			}
			
			// 위상정렬 큐로 구현하기
			// 1. 큐에 진입차수가 0인 노드 다 넣기
			// 2. 하나씩 빼면서 현재 노드에서 진출할 수 있는 노드들의 진입 차수를 하나씩 제거, 간선도 제거 => 큐가 공백이 될 때까지 반복
			// 	- 진입차수가 0이 된 노드를 다시 큐에 넣기
			
			Queue<Integer> queue = new LinkedList<>();
			for(int i = 1; i <= V; i++) {
				if(degree[i] == 0) {
					queue.add(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				sb.append(curr + " ");
				
				for(int v : adjList[curr]) {
					degree[v]--; // 진입 차수 1 감소
					
					if(degree[v] <= 0) 
						queue.add(v);
				}
			}
			
			sb.append("\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class
