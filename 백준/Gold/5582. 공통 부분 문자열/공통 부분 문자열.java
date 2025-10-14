import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int[][] dp = new int[a.length()][b.length()];
        int mx = -1;
        for (int i = 0; i < a.length(); i++) {
        	for (int j = 0; j < b.length(); j++) {
        		if (a.charAt(i) == b.charAt(j)) {
        			if (i != 0 && j != 0) dp[i][j] = dp[i - 1][j - 1] + 1;
        			else dp[i][j] = 1;
        		}
        		mx = Math.max(mx, dp[i][j]);
        	}
        }
        System.out.print(mx);
	}
}