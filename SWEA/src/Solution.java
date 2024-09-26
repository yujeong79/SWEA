import java.io.*;
import java.util.*;

public class Solution {
	static class Edge implements Comparable<Edge>{
		int node1;
		int node2;
		int weight;
		
		public Edge(int node1, int node2, int weight) {
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int V, E;
	static int[] parent; // 대표자를 저장하는 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt(); // 정점의 수
		E = sc.nextInt(); // 간선의 수
	
		Edge[] edges = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			int weight = sc.nextInt();
			
			edges[i] = new Edge(node1, node2, weight);
		}
		
		Arrays.sort(edges); // 가중치를 기준으로 오름차순 정렬
		
		parent = new int[V]; // 정점의 수 만큼 배열 크기 지정
		for(int i = 0; i < V; i++) {
			parent[i] = i;
		}
		
		int minWeight = 0; // 최소 가중치를 구할 변수
		int numberOfSelectedEdge = 0; // 선택된 간선의 수
		
		for(int i = 0; i < E; i++) {
			if(numberOfSelectedEdge == V-1) break; // 선택된 간선의 수가 V-1이 되면 종료
			
			int px = findSet(edges[i].node1);
			int py = findSet(edges[i].node2);
			
			if(px != py) {
				union(px, py);
				minWeight += edges[i].weight;
				numberOfSelectedEdge++;
			}
		}
		
	} // end of main
	
	
	private static void union(int px, int py) {
		parent[py] = px;
	}


	private static int findSet(int n) {
		if(n != parent[n])
			return parent[n] = findSet(parent[n]);
		return n;
	}


	static String input = "7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n"
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51";
} // end of class
