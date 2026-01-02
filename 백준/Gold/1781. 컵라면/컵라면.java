import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new int[]{x, y});
        }
        arr.sort((a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for (int[] point : arr) {
            int deadline = point[0], val = point[1];
            while (!pq.isEmpty() && pq.size() >= deadline) {
                pq.poll();
            }
            pq.add(val);
        }
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.print(ans);
    }
}