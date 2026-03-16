import java.io.*;
import java.util.*;

public class Main {

    static int[] days = { 31, 61, 92, 122, 153, 184, 214, 245 };
    static int MAX = 276;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX];

        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            if (m2 < 3 || m1 > 11) continue;

            int start = (m1 < 3 ? 1 : (m1 == 3 ? 0 : days[m1 - 4]) + d1);
            int end = (m2 > 11 ? MAX : (m2 == 3 ? 0 : days[m2 - 4]) + d2);

            arr.add(new int[] { start, end });
        }
        arr.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int[] a : arr) {
            int s = a[0], e = a[1];
            for (int j = s; j < e; j++) {
                if (dp[j] == 0)
                    dp[j] = dp[s - 1] + 1;
            }
        }
        boolean flag = true;
        for (int i = 1; i < MAX; i++) {
            if (dp[i] == 0) {
                flag = false;
                break;
            }
        }
        System.out.print(flag ? dp[MAX - 1] : 0);
    }
}