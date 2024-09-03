import java.io.*;
import java.util.*;

/**
 * 하루에 한 나무에만 물을 줄 수 있다.
 * 홀수 날은 1씩 자라고 짝수 날은 2씩 자란다.
 * 모든 나무의 키가 처음에 가장 키가 컸던 나무와 같아지도록 할 수 있는 최소 날짜 수
 * 
 * 예시
 * 1
20
26 19 23 2 24 2 17 15 1 27 6 29 18 23 27 13 26 21 9 1
[28, 28, 27, 27, 23, 20, 16, 14, 12, 11, 10, 8, 6, 6, 5, 3, 3, 2, 2, 0]
 */
public class Solution_SWEA14510_나무높이_D2_김유정 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	private static int N;
	private static int[] trees;
	private static int maxTree;
	private static int day;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine()); // 나무의 개수
			
			trees = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(trees);
			maxTree = trees[N-1]; // 가장 큰 나무 높이 저장
			for(int i = 0; i < N; i++) {
				trees[i] = maxTree - trees[i];
			}
			
			//System.out.println(Arrays.toString(trees));
			
			day = 0;
			
			waterTree(0);
			
			sb.append("#" + testCase + " " + day + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
	
	private static void waterTree(int t) {
		if(t >= N-1) return;
		
		while(trees[t] > 0) {
			//System.out.println(day + ", " + Arrays.toString(trees));
			day++;
			int growth = day%2!=0? 1 : 2;
			
			if(trees[t] == 2 && growth == 1) {
				int next = 0;
				for(int i = N-2; i >= t+1; i--) {
					if(trees[i] > 0) {
						if(trees[i] == 1 && growth != 1)
							continue;
						next = i;
						break;
					}
				}
				if(next != 0 && trees[next] > 0) {
					trees[next] -= growth;
				} 
				
			} else if(trees[t] == 1 && growth == 2) {
				int next = 0;
				for(int i = N-2; i >= t+1; i--) {
					if(trees[i] > 0) {
						if(trees[i] == 1 && growth != 1)
							continue;
						next = i;
						break;
					}
				}
				if(next != 0 && trees[next] > 0) {
					trees[next] -= growth;
				}
			}
			else trees[t] -= growth;
		}
		
		waterTree(t+1);
	}
} // end of class
