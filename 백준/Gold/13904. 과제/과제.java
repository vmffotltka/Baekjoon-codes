import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> homeworks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            homeworks.add(new int[]{deadline, score});
        }
        homeworks.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] hw : homeworks) {
            pq.offer(hw[1]);
            if (pq.size() > hw[0]) {
                pq.poll();
            }
        }
        int totalScore = 0;
        while (!pq.isEmpty()) {
            totalScore += pq.poll();
        }
        System.out.print(totalScore);
    }
}