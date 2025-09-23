import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
        	int cur = Integer.parseInt(st.nextToken());
        	
        	if (dp[i] == Integer.MAX_VALUE) break;
        	for (int j = i + 1; j <= Math.min(n - 1, i + cur); j++) {
        		dp[j] = Math.min(dp[i] + 1, dp[j]);
        	}
        }
        System.out.print(dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1]);
	}
}