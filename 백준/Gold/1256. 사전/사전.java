import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 0; i <= m; i++) dp[0][i] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.min(k, dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        if (dp[n][m] < k) {
            System.out.print(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int y = n, x = m, idx = 0;
        while (idx++ < n + m) {
            if (x == 0 || (y > 0 && dp[y - 1][x] >= k)) {
                sb.append('a');
                y--;
            }
            else {
                sb.append('z');
                k -= y > 0 ? dp[y - 1][x] : 0;
                x--;
            }
        }
        System.out.print(sb);
    }
}