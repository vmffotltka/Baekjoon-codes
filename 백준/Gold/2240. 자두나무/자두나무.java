import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][m + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = -1;

        int ans = 1;
        for (int i = 0; i < n; i++) {
            int pos = Integer.parseInt(br.readLine()) - 1;
            if (i == 0) {
                dp[i][pos] = 1;
                dp[i][pos ^ 1] = 0;
            }
            else {
                dp[i][0] = dp[i - 1][0] + (pos == 0 ? 1 : 0);
                ans = Math.max(ans, dp[i][0]);
                for (int j = 1; j <= Math.min(m, i + 1); j++) {
                    int a = dp[i - 1][j - 1], b = dp[i - 1][j];
                    if (a == -1 && b == -1) continue;

                    dp[i][j] = Math.max(a, b) + (j % 2 == pos ? 1 : 0);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.print(ans);
    }
}