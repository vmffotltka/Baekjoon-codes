import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] inning;
    static boolean[] vis = new boolean[9];
    static int[] order = new int[9];
    static int dfs(int depth) {
        if (depth == 3)
            return dfs(depth + 1);
        if (depth == 9) {
            int idx = 0, score = 0;
            for (int i = 0; i < N; i++) {
                int out = 0;
                boolean base1 = false, base2 = false, base3 = false;
                while (out < 3) {
                    int taja = inning[i][order[idx]];
                    if (taja == 0)
                        out++;
                    else if (taja == 1) {
                        if (base3) score++;
                        base3 = base2;
                        base2 = base1;
                        base1 = true;
                    }
                    else if (taja == 2) {
                        if (base3) score++;
                        if (base2) score++;
                        base3 = base1;
                        base1 = false;
                        base2 = true;
                    }
                    else if (taja == 3) {
                        if (base3) score++;
                        if (base2) score++;
                        if (base1) score++;
                        base3 = true;
                        base1 = false;
                        base2 = false;
                    }
                    else {
                        if (base3) score++;
                        if (base2) score++;
                        if (base1) score++;
                        score++;
                        base3 = false;
                        base2 = false;
                        base1 = false;
                    }
                    idx = (idx + 1) % 9;
                }
            }
            return score;
        }
        int mx = 0;
        for (int i = 1; i < 9; i++) {
            if (vis[i]) continue;
            order[depth] = i;
            vis[i] = true;
            mx = Math.max(mx, dfs(depth + 1));
            vis[i] = false;
            order[depth] = 0;
        }
        return mx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inning = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                inning[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(dfs(0));
    }
}