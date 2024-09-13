import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 그래프탐색01_DFS_Stack {
	static int V, E; // 정점의 개수와 간선의 개수
	static List<Integer>[] adj; // 인접행렬, 2차원 배열로 각 노드가 자신을 제외한 다른 모든 노드들과 인접해있는지 체크(1)
	static boolean[] visited; // 방문 체크
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		visited = new boolean[V+1];
		adj = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) { // 간선의 수만큼 반복
			int from = sc.nextInt(); // 시작 노드
			int to = sc.nextInt(); // 끝 노드
			adj[from].add(to); // 방향이 없는 그래프
			adj[to].add(from);
		}
		
		dfs(1);
		
		
	} // end of main
	
	/**
	 * @param v : 현재 내가 있는 정점
	 */
	static void dfs(int v) {
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		//System.out.println(v);
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			if(!visited[curr]) {
				visited[curr] = true;
				System.out.println(curr);				
			}
			
			for(int n : adj[curr]) {
				if(!visited[n]) {
					stack.push(n);
				}
			}
			
		}
	}
	
	static String input = "7 9\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "1 6\r\n"
			+ "2 4\r\n"
			+ "2 7\r\n"
			+ "3 4\r\n"
			+ "4 7\r\n"
			+ "5 6\r\n"
			+ "5 7";
	
} // end of class
