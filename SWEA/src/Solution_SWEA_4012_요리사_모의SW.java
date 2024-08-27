import java.io.*;
import java.util.*;

public class Solution_SWEA_4012_요리사_모의SW {
	static int N;
	static int R;
	
	static int[][] synergy;
	static int[] ingredient;
	static int[] result;
	
	static List<String> combList;
	
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
				makeFood(combList.get(i), combList.get(combList.size()-1-i));
			}
			
			sb.append("#").append(testCase).append(" ").append(min).append("\n");

		} // end of testCase
		System.out.println(sb);
	} // end of main
	
	static void comb(int cnt, int start) { // 식재료의 조합을 구해보자
		if(cnt == R) {
			String str = ""; // 왜.. String으로 했더라..? 기억이 안남... 아 생각남 list에 모든 조합의 결과인 배열을 저장해서 배열을 하나씩 가져오려고 했는데 왜 그렇게 못했지?
			for(int n : result) str += n+" ";
			combList.add(str); // 일단 모든 조합을 다 담아
			return;
		}
		
		for(int i = start; i < N; i++) {
			result[cnt] = ingredient[i];
			comb(cnt+1, i+1);
		}
	}
	
	static void makeFood(String A, String B) {
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(A, " ");
		while(st.hasMoreTokens()) listA.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(B, " ");
		while(st.hasMoreTokens()) listB.add(Integer.parseInt(st.nextToken()));
		
		int foodA = 0;
		int foodB = 0;
		
		for(int i = 0; i < listA.size(); i++) { // foodA 시너지
			for(int j = 0; j < listA.size(); j++) {
				if(listA.get(i) != listA.get(j)) { // 서로 다른 식재료인 경우에 식재료의 시너지 구하기
					int i1 = listA.get(i);
					int i2 = listA.get(j);
					
					foodA += synergy[i1][i2];
				}
			}
		}
		
		for(int i = 0; i < listB.size(); i++) { // foodB 시너지
			for(int j = 0; j < listB.size(); j++) {
				if(listB.get(i) != listB.get(j)) { // 서로 다른 식재료인 경우에 식재료의 시너지 구하기
					int i1 = listB.get(i);
					int i2 = listB.get(j);
					
					foodB += synergy[i1][i2];
				}
			}
		}
		
		min = Math.min(min, Math.abs(foodA - foodB));
	}
	
} // end of class
