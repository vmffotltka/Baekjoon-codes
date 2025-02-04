import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int dp[] = new int[1500001];
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
        	String input[] = br.readLine().split(" ");
        	int t = Integer.parseInt(input[0]), p = Integer.parseInt(input[1]);
        	if (i != 0) dp[i] = Math.max(dp[i], dp[i - 1]);
        	if (i + t <= n) dp[i + t] = Math.max(dp[i + t], dp[i] + p);
        }
        bw.write(Math.max(dp[n - 1], dp[n]) + "");
        bw.flush();
        bw.close(); br.close();
	}
}