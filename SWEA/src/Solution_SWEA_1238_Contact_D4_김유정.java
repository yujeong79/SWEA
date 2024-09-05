import java.io.*;
import java.util.*;

public class Solution_SWEA_1238_Contact_D4_김유정 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	private static List<Integer>[] adjList;
	private static int[] rank; // 인덱스가 몇 번째에 전화를 받았는지 저장
	private static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		int testCase = 0;
		while(++testCase <= 10) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken()); // 입력 받는 데이터의 길이
			int start = Integer.parseInt(st.nextToken()); // 시작점
			
			adjList = new ArrayList[101]; // 연락 인원은 1명 ~ 100명
			for(int i = 1; i <= 100; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
			}
			
			for(int i = 1; i <= 100; i++) {
				Set<Integer> set = new HashSet<>(adjList[i]);
				adjList[i] = new ArrayList<>(set);
			}
			
			rank = new int[101];
			isVisited = new boolean[101];
			Contact(start, 1);
			
			int max = 0;
			int answer = 0;
			for(int i = 1; i <= 100; i++) {
				if(rank[i] >= max) {
					max = rank[i];
					answer = i;
				}
			}
			
			sb.append("#" + testCase + " " + answer + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void Contact(int v, int r) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {v, r});
		isVisited[v] = true;
		rank[v] = r;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for(int w : adjList[curr[0]]) {
				if(!isVisited[w]) {
					queue.add(new int[] {w, curr[1]+1});
					isVisited[w] = true;
					rank[w] = curr[1]+1;
				}
			}
		}
		
	}
} // end of class
