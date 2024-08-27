import java.io.*;
import java.util.*;

public class Solution_SWEA_10726_이진수표현_D3_김유정_161ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
     
        int TC = Integer.parseInt(br.readLine());
        int testCase = 0;
        while(++testCase <= TC) {
             
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 마지막 N개의 비트
            int M = Integer.parseInt(st.nextToken()); // M의 2진수 표현
             
            List<Integer> list = new ArrayList<>();
             
            while(M >= 1) {
                list.add(M%2);
                M /= 2;
            }
             
            boolean isOn = true;
             
            for(int i = 0; isOn && i < N; i++) {
                if(i >= list.size() || list.get(i) != 1) 
                    isOn = false;
            }
            sb.append("#").append(testCase).append(" ").append(isOn ? "ON" : "OFF").append("\n");
             
        } // end of testCase
        System.out.println(sb);
    } // end of main

}
