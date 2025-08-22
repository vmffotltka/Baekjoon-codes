import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        
        long[][] dp = new long[n - 1][21];
        dp[0][Integer.parseInt(arr[n - 1])] = 1;
        
        for (int i = 1; i < n - 1; i++) {
        	int p = Integer.parseInt(arr[n - i - 1]);
        	for (int j = 0; j <= 20; j++) {
        		if (j >= p)
        			dp[i][j] += dp[i - 1][j - p];
        		if (j + p <= 20)
        			dp[i][j] += dp[i - 1][j + p];
        	}
        }
        bw.write(String.valueOf(dp[n - 2][Integer.parseInt(arr[0])]));
        bw.flush();
    }
}