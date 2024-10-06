import java.io.*;
import java.util.*;

/**
 * 1. 부분집합을 사용해서 벨 수 있는 나무의 부분집합을 구하기
 * 2. 나무를 베고 BFS를 사용해서 Y까지 이동하는 동시에 리모콘 조작 횟수도 세기
 */

public class Solution_22683_나무베기 {
    static class Point {
        int r, c, controller;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Point(int r, int c, int controller) {
            this.r = r;
            this.c = c;
            this.controller = controller;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    ", controller=" + controller +
                    '}';
        }
    }

    static class Car {
        int r, c, d;

        public Car(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, K, tCnt, answer;
    static Car car;
    static char[][] map;
    static List<Point> treeList; // 트리의 위치를 저장할 리스트
    static boolean[][] isSelected;

    static void init() {
        map = new char[N][N];
        treeList = new ArrayList<>();
        isSelected = new boolean[N][N];
        answer = Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int testCase = 0;
        while(++testCase <= T) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // map 사이즈
            K = Integer.parseInt(st.nextToken()); // 최대 나무의 수

            init();

            for(int i = 0; i < N; i++) {
                String str = br.readLine();
                for(int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == 'T') {
                        treeList.add(new Point(i, j)); // 트리의 위치를 treeList에 저장
                    } else if(map[i][j] == 'X') {
                        car = new Car(i, j, 0);
                    }
                }
            }

            tCnt = treeList.size();

            powerset(0, 0);

            answer = answer == Integer.MAX_VALUE ? -1 : answer;
            sb.append("#" + testCase + " " + answer + "\n");
        } // end of testCase
        System.out.println(sb);
    } // end of main

    private static void powerset(int idx, int selectedCnt) {
        if(selectedCnt > K) {
            return;
        }

        if(idx >= tCnt) {
            DFS(selectedCnt);
            return;
        }

        Point tree = treeList.get(idx);

        isSelected[tree.r][tree.c] = false; // 안잘린 나무는 false
        powerset(idx+1, selectedCnt);

        isSelected[tree.r][tree.c] = true; // 잘린 나무는 true
        powerset(idx+1, selectedCnt+1);
    }

    // 상 : 0, 좌 : 1, 하 : 2, 우 : 3
    static final int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static void DFS(int selectedCnt) {

    }
} // end of class
