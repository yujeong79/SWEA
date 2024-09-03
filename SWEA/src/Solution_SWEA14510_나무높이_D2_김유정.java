import java.io.*;
import java.util.*;

/**
 * 그리디
 * 
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
			System.out.println(day + ", " + Arrays.toString(trees));
			day++;
			System.out.println(day + ", " + Arrays.toString(trees));
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
