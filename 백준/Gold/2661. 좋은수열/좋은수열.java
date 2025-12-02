import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static StringBuilder[] good;
    static boolean dfs(int depth, int limit, StringBuilder sb) {
        if (depth == limit) {
            for (int i = 1; i <= (limit + 1) / 2; i++) {
                for (int j = i; j <= limit - i + 1; j++) {
                    if (sb.substring(j - i, j).equals(sb.substring(j, j + i)))
                        return false;
                }
            }
            good[limit] = sb;
            return true;
        }
        for (int i = 1; i <= 3; i++) {
            sb.append(i);
            if (dfs(depth + 1, limit, sb))
                return true;
            sb.deleteCharAt(sb.length() - 1);
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        good = new StringBuilder[N + 1];
        good[0] = new StringBuilder().append("1");
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                StringBuilder sb = new StringBuilder().append(good[j]);
                dfs(j, i, sb);
                if (good[i] != null) break;
            }
        }
        System.out.print(good[N - 1]);
    }
}