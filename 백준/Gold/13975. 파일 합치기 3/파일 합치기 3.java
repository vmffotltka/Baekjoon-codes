import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long ans = 0;
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                pq.offer(Long.parseLong(st.nextToken()));

            for (int i = 0; i < n - 1; i++) {
                long a = pq.poll(), b = pq.poll();
                ans += a + b;
                pq.offer(a + b);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}