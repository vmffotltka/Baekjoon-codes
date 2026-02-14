import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ans = m - l;
            for (int i = 0; i < n; i++) {
                int time = Integer.parseInt(st.nextToken());
                if (time == -1) continue;
                ans = Math.min(ans, time);
            }
            sb.append(String.format("The scoreboard has been frozen with %d %s remaining.\n", m - ans, (m - ans == 1 ? "minute" : "minutes")));
        }
        System.out.print(sb);
    }
}