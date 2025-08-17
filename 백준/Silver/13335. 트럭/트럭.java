import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);
        
        Queue<Integer> waitingTrucks = new LinkedList<>();
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            waitingTrucks.offer(Integer.parseInt(input[i]));
        }
        
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        while (!bridge.isEmpty()) {
            time++;
            currentWeight -= bridge.poll();
            
            if (!waitingTrucks.isEmpty()) {
                int nextTruckWeight = waitingTrucks.peek();
                
                if (currentWeight + nextTruckWeight <= L) {
                    currentWeight += waitingTrucks.poll();
                    bridge.add(nextTruckWeight);
                }
                else {
                    bridge.add(0);
                }
            }
        }
        
        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
        br.close();
    }
}
