import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper = new int[10][10];
    static int[] confetti = {0, 5, 5, 5, 5, 5}; 
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalOnes = 0;
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 1) {
                    totalOnes++;
                }
            }
        }
        
        if (totalOnes == 0) {
            System.out.println(0);
            return;
        }

        dfs(0, 0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void dfs(int y, int x, int count) {
        if (count >= ans) {
            return;
        }

        if (y >= 10) {
            ans = Math.min(ans, count);
            return;
        }

        if (x >= 10) {
            dfs(y + 1, 0, count);
            return;
        }

        if (paper[y][x] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (confetti[size] > 0 && canAttach(y, x, size)) {
                    attach(y, x, size, 0); 
                    confetti[size]--;

                    dfs(y, x + 1, count + 1);

                    attach(y, x, size, 1);
                    confetti[size]++;
                }
            }
        } else {
            dfs(y, x + 1, count);
        }
    }

    static boolean canAttach(int y, int x, int size) {
        if (y + size > 10 || x + size > 10) {
            return false;
        }

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (paper[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void attach(int y, int x, int size, int val) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                paper[i][j] = val;
            }
        }
    }
}