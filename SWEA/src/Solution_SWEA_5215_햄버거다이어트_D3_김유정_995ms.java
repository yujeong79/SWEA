import java.io.*;
import java.util.*;
  
public class Solution_SWEA_5215_햄버거다이어트_D3_김유정_995ms {
      
    static int[][] map;
    static int[] nums;
    static int maxScore;
  
    static int N;
    static int L;
      
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
          
        int T = Integer.parseInt(br.readLine());
        int testCase = 0;
        while(++testCase <= T) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
              
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리
              
            // 0 : 칼로리, 1 : 맛에 대한 점수
            map = new int[N][2]; 
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                map[i][1] = Integer.parseInt(st.nextToken()); // score
                map[i][0] = Integer.parseInt(st.nextToken()); // calorie
            }
              
            maxScore = 0;
              
            for(int i = 1; i <= N; i++) {
                nums = new int[i];
                comb(0, 0, i);      
            }
              
            sb.append("#").append(testCase).append(" ").append(maxScore).append("\n");
              
              
        } // end of testCase
        System.out.println(sb.toString());
    } // end of main
      
    static void comb(int cnt, int start, int r) {
        if(cnt == r) { 
            if(sum(nums) <= L) {
                calScore(nums);
                return;
            }
            return;
        }
        for(int i = start; i < N; i++) {
            nums[cnt] = i;
            comb(cnt+1, i+1, r);
        }
    }
      
    static int sum(int[] list) { // nums 안의 칼로리의 총합을 구해주는 메소드
        if(list == null) return 0;
          
        int total = 0;
        for(int i : list) {
            total += map[i][0];
        }
        return total;
    }
      
    static void calScore(int[] list) { // 조합을 넘겨주면 맛의 합산을 구해주는 메소드
        int total = 0;
          
        for(int i : list) { // 칼로리를 받아서 맛 점수를 더해주기
            total += map[i][1];
        }
        maxScore = Math.max(maxScore, total);
    }
      
} // end of class