import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    static char[][] explode(char[][] grid) {
        char[][] ret = new char[R][C];
        boolean[][] toExplode = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 'O') {
                    toExplode[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dy[d];
                        int nj = j + dx[d];
                        if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                            toExplode[ni][nj] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (toExplode[i][j]) {
                    ret[i][j] = '.';
                } else {
                    ret[i][j] = 'O';
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        int t = n / 2;
        while (t-- > 0)
            grid = explode(grid);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (n % 2 == 0) sb.append('O');
                else sb.append(grid[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}