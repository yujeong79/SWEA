import java.io.*;
import java.util.*;

/**
 * 1 ~ 18 까지의 수가 적힌 18장의 카드
 * 아홉 라운드에 걸쳐 게임을 진행
 * 한 라운드에는 두 사람이 낸 카드에 적힌 수를 비교해서 점수를 계산
 * 	높은 수의 카드를 낸 사람은 두 카드의 합만큼 점수를 획득
 * 	낮은 수의 카드를 낸 사람은 점수 없음
 * 
 * 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구해보자
 */

public class Solution_SWEA_6808_규영이와인영이의카드게임_D3_김유정 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static boolean[] cards;
	
	static int[] Gyu;
	static int[] In;
	
	static boolean[] isSelected;
	static int[] result;
	
	static int gScore;
	static int iScore;
	
	static int winCnt;
	static int loseCnt;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			
			cards = new boolean[19]; // true면 규영이의 카드, false면 인영이의 카드
			
			Gyu = new int[9]; // 규영이의 9장의 카드를 저장할 배열
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 9; i++) {
				Gyu[i] = Integer.parseInt(st.nextToken());
				cards[Gyu[i]] = true; // 규영이가 받은 카드는 true로 바꿔주기
			}
			
			// 인영이의 카드 받기
			In = new int[9];
			int idx = 0;
			
			for(int i = 1; i <= 18; i++) {
				if(cards[i] == false)
					In[idx++] = i;
			}
			
			// 가능한 인영이의 카드 순서 순열을 다 구해
			winCnt = 0;
			loseCnt = 0;
			
			isSelected = new boolean[9];
			result = new int[9];
			perm(0);
			
			sb.append("#" + testCase + " " + winCnt + " " + loseCnt + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
	
	static void perm(int cnt) {
		if(cnt == 9) { // 새롭게 카드 정렬을 마쳤으면
			round(result); // 한 라운드 시작			
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(!isSelected[i]) {
				result[cnt] = In[i];
				isSelected[i] = true;
				perm(cnt+1);
				isSelected[i] = false;
			}
		}
	}
	
	static void round(int[] result) {
		
		gScore = 0; // 각자의 점수를 초기화 하고
		iScore = 0;
		
		for(int i = 0; i < 9; i++) {
			if(Gyu[i] > result[i]) gScore += Gyu[i] + result[i];
			else if(Gyu[i] < result[i]) iScore += Gyu[i] + result[i];
		}
		
		if(gScore > iScore) winCnt++;
		else if (iScore > gScore) loseCnt++;
	}
	
} // end of class
