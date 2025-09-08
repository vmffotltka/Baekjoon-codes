import java.io.*;
import java.util.*;

public class Main {
	
	static int MAX = 2001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX];
        
        for (int i = 1; i < MAX; i++) dp[i] = i;
        dp[1] = 0;

        for (int i = 2; i < MAX; i++) {
        	int pre = dp[i] + 2;
        	for (int j = i * 2; j < MAX; j += i) {
        		for (int k = 0; k < i; k++) {
        			dp[j - k] = Math.min(dp[j - k], pre + k);
        		}
        		pre++;
        	}
        }
        
        System.out.print(dp[s]);
    }
}