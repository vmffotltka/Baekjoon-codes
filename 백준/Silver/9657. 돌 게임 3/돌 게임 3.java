import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 5];
        dp[1] = 1;
        dp[3] = 1;
        dp[4] = 1;
        String index = "134";
        for (int i = 5; i <= n; i++) {
            for (char c : index.toCharArray()) {
                if (dp[i - (c - '0')] == 0)
                    dp[i] = 1;
            }
        }
        System.out.print(dp[n] == 1 ? "SK" : "CY");
    }
}