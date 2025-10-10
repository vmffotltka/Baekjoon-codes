import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 41; i++)
        	dp[i] = dp[i - 2] + dp[i - 1];
	
        int ans = 1, pre = 1;
        for (int i = 0; i < m; i++) {
        	int cur = Integer.parseInt(br.readLine());
        	ans *= dp[cur - pre];
        	pre = cur + 1;
        }
        ans *= dp[n + 1 - pre];
        System.out.print(ans);
	}
}