import java.io.*;
import java.util.*;

class Edge {
	int node1, node2;

	public Edge(int node1, int node2) {
		this.node1 = node1;
		this.node2 = node2;
	}

	@Override
	public String toString() {
		return "Edge [node1=" + node1 + ", node2=" + node2 + "]";
	}
}
public class Solution_SWEA_7465_창용마을무리의개수_D4_김유정_141ms {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	private static int N;
	private static int M;
	private static Edge[] edges;
	private static int[] p;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 창용 마을에 사는 사람의 수, 정점의 수
			M = Integer.parseInt(st.nextToken()); // 서로를 알고 있는 사람의 관계 수, 간선의 수
			
			p = new int[N+1];
			edges = new Edge[M]; 
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(node1, node2);
			}
			
			// make-set
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				int node1 = findSet(edges[i].node1);
				int node2 = findSet(edges[i].node2);
				union(node1, node2);
			}
			
			Set<Integer> set = new HashSet<>();
			for(int i = 1; i <= N; i++) {
				set.add(findSet(i));
			}
			
			sb.append("#" + testCase + " " + set.size() + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static int findSet(int n) {
		if(n != p[n])  // 자신이 대표자가 아니면
			p[n] = findSet(p[n]);
		return p[n];
	}
	
	private static void union(int x, int y) {
		p[y] = x;
	}
} // end of class
