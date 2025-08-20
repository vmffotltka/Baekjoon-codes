import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(arr[i]);
        	dp[i] = Math.min(dp[i], p);
        	for (int j = i; j < n; j++) {
        		if (j - i - 1 >= 0)
        			dp[j] = Math.min(dp[j], dp[j - i - 1] + p);
        	}
        }
        bw.write(String.valueOf(dp[n - 1]));
        bw.flush();
    }
}