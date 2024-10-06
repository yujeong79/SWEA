import java.io.*;
import java.util.*;

public class Solution_22654_차윤이의RC카 {
    static class Car {
        int r, c, d;

        public Car(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, Q, C, startR, startC;
    static char[][] map;
    static Car car;
    static Queue<Character> commands;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int testCase = 0;
        while(++testCase <= T) {
            sb.append("#" + testCase + " ");

            N = Integer.parseInt(br.readLine()); // (2 <= N <= 5)

            map = new char[N][N];
            for(int i = 0; i < N; i++) {
                String str = br.readLine();
                for(int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == 'X') {
                        startR = i;
                        startC = j;
                    }
                }
            }

            Q = Integer.parseInt(br.readLine()); // (1 <= Q <= 5)
            for(int i = 0; i < Q; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                C = Integer.parseInt(st.nextToken());

                commands = new LinkedList<>();
                String command = st.nextToken();
                for(int j = 0; j < C; j++) {
                    commands.offer(command.charAt(j));
                }

                car = new Car(startR, startC, 0);
                Move();

                if(map[car.r][car.c] == 'Y') sb.append("1 ");
                else sb.append("0 ");
            }
            sb.append("\n");
        } // end of testCase
        System.out.println(sb);
    } // end of main

    // 상:0, 우:1, 하:2, 좌:3 => d+1%4
    // R +1, L -1
    static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static void Move() {
        while(!commands.isEmpty()) {
            char command = commands.poll(); // 현재 명령어

            if(command == 'A') { // 명령어가 직진이면 car의 방향대로 직진
                int nr = car.r + dir[car.d][0];
                int nc = car.c + dir[car.d][1];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 'T') {
                    car.r = nr;
                    car.c = nc;
                }
            } else if(command == 'R') { // 우로 방향 전환
                car.d = (car.d+1)%4;
            } else if(command == 'L') { // 좌로 방향 전환
                if(car.d == 0) car.d = 4;
                car.d -= 1;
            }
        }

    } // end of Move()

} // end of main
