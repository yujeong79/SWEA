import java.io.*;
import java.util.*;
  
public class Solution_SWEA_5215_햄버거다이어트_D3_백트래킹 {
	static int N, L; // N : 재료의 개수, L : 제한 칼로리
	static int[] cals;
	static int[] scores;
	static int ans; // 정답
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
          
        int T = Integer.parseInt(br.readLine()); // 전체 테스트 케이스
        int testCase = 0;
        while(++testCase <= T) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
              
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리

            cals = new int[N];
            scores = new int[N];
            
            for(int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine(), " ");
            	int score  = Integer.parseInt(st.nextToken());
            	int cal  = Integer.parseInt(st.nextToken());
            	scores[i] = score;
            	cals[i] = cal;
            }
            
            ans = 0;
            
            // 1. 비트마스킹으로 풀 수 있다. => 이 재료를 고려하겠다~ 말겠다~를 비트로 저장
            makeBurger(0, 0, 0);  
            sb.append("#").append(testCase).append(" ").append(false).append("\n");
              
        } // end of testCase
        System.out.println(sb.toString());
    } // end of main  
    
    /**
     * 다 햄버거를 만들고 판단했는데 왜 백트래킹?
     * 왜냐면 제한 칼로리를 이미 넘어버리면 고려하지 않고 잘라버리니까!
     */
    
    // 중간 결과를 들고 다니겠다! (누적된 점수와 칼로리)
    static void makeBurger(int idx, int sumScore, int sumCal) {
    	if(sumCal > L) { // idx-1번째까지 고려했는데 이미 제한칼로리를 벗어나면 고려하지 말자
    		return;
    	}
    	if(idx == N) { // 모든 재료를 전부 고려했어!
    		// 베스트인지 아닌지 판단하자!
    		if(ans < sumScore) // 누적 칼로리가 제한 칼로리 이하이고 
    			ans = sumScore; // 기존의 정답보다 이번 누적점수가 더 높으면 ans을 갱신
    		return;
    	}

    	// 이번에 idx 재료 사용했다!
    	makeBurger(idx+1, sumScore+scores[idx], sumCal+cals[idx]); // 다음 재료를 선택, 기존의 누적 점수에 현재 idx의 점수를 누적하고, 기존의 누적 칼로리에 현재 idx의 칼로리를 누적
    	// 이번에 재료를 사용하지 않았다!
    	makeBurger(idx+1, sumScore, sumCal); // 다음 재료를 선택, 기존의 누적 점수에 현재 idx의 점수를 누적하고, 기존의 누적 칼로리에 현재 idx의 칼로리를 누적
    }
    
} // end of class