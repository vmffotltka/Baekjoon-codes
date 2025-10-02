import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static int MAX = 10001;
	static long[][] dp = new long[MAX][3];
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        
        for (int i = 4; i < MAX; i++) {
        	dp[i][0] = dp[i - 1][0];
        	dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
        	dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2];
        }
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(br.readLine());
        	sb.append(dp[p][0] + dp[p][1] + dp[p][2]).append('\n');
        }
        System.out.print(sb.toString());
	}
}