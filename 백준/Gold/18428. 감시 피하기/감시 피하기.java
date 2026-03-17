import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] map;

    static boolean solve(int idx, int depth) {
        if (depth == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 'T') continue;
                    int right = j + 1, left = j - 1, up = i - 1, down = i + 1;
                    while (right < N && map[i][right] != 'S' && map[i][right] != 'O') right++;
                    while (left >= 0 && map[i][left] != 'S' && map[i][left] != 'O') left--;
                    while (up >= 0 && map[up][j] != 'S' && map[up][j] != 'O') up--;
                    while (down < N && map[down][j] != 'S' && map[down][j] != 'O') down++;

                    if (right < N && map[i][right] == 'S') return false;
                    if (left >= 0 && map[i][left] == 'S') return false;
                    if (up >= 0 && map[up][j] == 'S') return false;
                    if (down < N && map[down][j] == 'S') return false;
                }
            }
            return true;
        }
        for (int i = idx; i < N * N; i++) {
            int curY = i / N, curX = i % N;
            if (map[curY][curX] != 'X') continue;
            map[curY][curX] = 'O';
            if (solve(i + 1, depth + 1)) return true;
            map[curY][curX] = 'X';
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        System.out.print(solve(0, 0) ? "YES" : "NO");
    }
}