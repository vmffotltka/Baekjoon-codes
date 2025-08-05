import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        int mx = -1;
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	dp[i] = 1;
        	for (int j = 0; j < i; j++) {
        		if (arr[j] < arr[i]) 
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        	}
        	mx = Math.max(mx, dp[i]);
        }
        bw.write((n - mx) + "");
        bw.flush();
	}
}