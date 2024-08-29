import java.io.*;
import java.util.*;
 
class Button{
    int priority;
    int distance;
     
    public Button(int priority, int distance) {
        this.priority = priority;
        this.distance = distance;
    }
 
    @Override
    public String toString() {
        return "Button [priority=" + priority + ", distance=" + distance + "]";
    }
}
 
public class Solution_SWEA_10761_신뢰_D3_김유정_139ms { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
         
        int TC = Integer.parseInt(br.readLine());
        int testCase = 0;
        while(++testCase <= TC) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int theNumberOfButton = Integer.parseInt(st.nextToken());
             
            // 각 큐의 button 나눠 담기(우선순위와 거리를 함께 저장)   
            Queue<Button> B_button = new LinkedList<>();
            Queue<Button> O_button = new LinkedList<>();
             
            for(int i = 1; i <= theNumberOfButton; i++) {
                if(st.nextToken().equals("B")) {
                    int priority = i;
                    int distance = Integer.parseInt(st.nextToken());
                    B_button.add(new Button(priority, distance));
                } else {
                    int priority = i;
                    int distance = Integer.parseInt(st.nextToken());
                    O_button.add(new Button(priority, distance));
                }
            }
             
            int second = 0;
             
             
            int B_location = 1; int O_location = 1; 
            int currentPriority = 1;
             
            while(!B_button.isEmpty() || !O_button.isEmpty()) {
                second++;
                 
                Button B = B_button.peek();
                Button O = O_button.peek();
                 
                boolean isPressed = false;
                 
                if(B != null) {
                    if(B_location != B.distance) {
                        B_location += B.distance > B_location ? 1 : -1;
                    } else if(B_location == B.distance && currentPriority == B.priority && !isPressed){
                        isPressed = true;
                        B_button.poll();
                        currentPriority++;
                    }
                }
                 
                if(O != null) {
                    if(O_location != O.distance) {
                        O_location += O.distance > O_location ? 1 : -1;
                    } else if(O_location == O.distance && currentPriority == O.priority && !isPressed){
                        isPressed = true;
                        O_button.poll();
                        currentPriority++;
                    }
                }
            }
             
            sb.append("#").append(testCase).append(" ").append(second).append("\n");
             
        } // end of testCase
         
        System.out.println(sb);
         
    } // end of main
} // end of class