import java.io.*;
import java.util.*;

public class Solution_SWEA_4012_요리사_test {
	static int N;
	static int R;
	
	static int[][] synergy;
	static int[] ingredient;
	static int[] result;
	
	static List<int[]> combList;
	
	static int min;
	
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
			
			combList = new ArrayList<>(); // 식재료 조합을 공백을 기준으로 분리하여 저장하는 리스트
			comb(0, 0);
			
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < combList.size()/2; i++) { // 그리고 인덱스가 반대되는 요소끼리 짝이니까 그렇게 A와 B로 보내버려
				System.out.println(Arrays.toString(combList.get(i)));
				System.out.println(Arrays.toString(combList.get(combList.size()-1-i)));
				makeFood(combList.get(i), combList.get(combList.size()-1-i));
			}
			
			for(int[] a : combList) {
				System.out.println(Arrays.toString(a));
			}
			
			sb.append("#").append(testCase).append(" ").append(min).append("\n");

			System.out.println(sb);
		} // end of testCase
	} // end of main
	
	static void comb(int cnt, int start) { // 식재료의 조합을 구해보자
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			combList.add(result); // 일단 모든 조합을 다 담아, 깊은 복사를 해서 저장해야 한다는데
			return;
		}
		
		for(int i = start; i < N; i++) {
			result[cnt] = ingredient[i];
			comb(cnt+1, i+1);
		}
	}
	
	static void makeFood(int[] A, int[] B) {
//		List<Integer> listA = new ArrayList<>();
//		List<Integer> listB = new ArrayList<>();
//		
//		StringTokenizer st = new StringTokenizer(A, " ");
//		while(st.hasMoreTokens()) listA.add(Integer.parseInt(st.nextToken()));
//		
//		st = new StringTokenizer(B, " ");
//		while(st.hasMoreTokens()) listB.add(Integer.parseInt(st.nextToken()));
		
		int foodA = 0;
		int foodB = 0;
		
//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(B));
		
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < N/2; j++) {
				if(A[i] != A[j]) { // 서로 다른 식재료인 경우에 식재료의 시너지 구하기
					int i1 = A[i];
					int i2 = A[j];
					
					foodA += synergy[i1][i2];
				}
				
				if(B[i] != B[j]) { // 서로 다른 식재료인 경우에 식재료의 시너지 구하기
					int i1 = B[i];
					int i2 = B[j];
					
					foodB += synergy[i1][i2];
				}
			}
		}
		
		min = Math.min(min, Math.abs(foodA - foodB));
	}
	
} // end of class
