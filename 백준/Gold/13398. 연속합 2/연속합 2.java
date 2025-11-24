import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int ans = Integer.parseInt(st.nextToken());
        dp[0][1] = ans;
        for (int i = 1; i < n; i++) {
        	int p = Integer.parseInt(st.nextToken());
        	dp[i][0] = Math.max(dp[i - 1][0] + p, dp[i - 1][1]);
        	dp[i][1] = Math.max(dp[i - 1][1] + p, p);
        	ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.print(ans);
    }
}