import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000009;
	static final int MAX = 100001;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[][] dp = new long[MAX][3];
        dp[1][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        
        for (int i = 4; i < MAX; i++) {
        	dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % MOD;
        	dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % MOD;
        	dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % MOD;
        }
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
        	int n = Integer.parseInt(br.readLine());
        	sb.append(String.valueOf((dp[n][0] + dp[n][1] + dp[n][2]) % MOD) + "\n");
        }
        System.out.print(sb.toString());
        //bw.flush();
    }
}