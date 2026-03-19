import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 1010;
    static long[] dp = new long[MAX];
    static long solve(int a, int b) {
        if (dp[a * 30 + b] != 0) return dp[a * 30 + b];
        if (a == 0) return 1;
        long ret = solve(a - 1, b + 1);
        if (b != 0) ret += solve(a, b - 1);
        dp[a * 30 + b] = ret;
        return dp[a * 30 + b];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            sb.append(solve(n, 0)).append('\n');
        }
        System.out.print(sb);
    }
}