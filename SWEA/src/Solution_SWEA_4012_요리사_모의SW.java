import java.io.*;
import java.util.*;

/**
 * N개의 식재료를 절반씩 나누어 A와 B 두 개의 요리를 하려고 한다.
 * A음식과 B음식의 맛의 차이가 최소가 되도록 재료를 배분해야 한다.
 * 
 * 식재료1과 식재료2 => A음식, 식재료3과 식재료4 => B음식 : 차이 3
 * 식재료2와 식재료4 => A음식, 식재료1과 식재료3 => B음식 : 차이 2
 * 
 * 정답 : 2
 * 
 */

public class Solution_SWEA_4012_요리사_모의SW {
	static int N;
	static int R;
	
	static int[][] synergy;
	static int[] ingredient;
	static int[] result;
	
	static List<int[]> combList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine());
			R = N/2;
			
			ingredient = new int[N];
			result = new int[R];
			
			synergy = new int[N][N];
			for(int i = 0; i < N; i++) {
				ingredient[i] = i; // 식재료 배열에 식재료 넣어주기
				
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combList = new ArrayList<>(); // 식재료 조합을 저장하는 리스트
			comb(0, 0);
			
			
			
		} // end of testCase
	} // end of main
	
	static void comb(int cnt, int start) { // 식재료의 조합을 구해보자
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			combList.add(result);
			return;
		}
		
		for(int i = start; i < N; i++) {
			result[cnt] = ingredient[i];
			comb(cnt+1, i+1);
		}
	}
	
	static void makeFood(int[] arr) {
		
	}
	
} // end of class
