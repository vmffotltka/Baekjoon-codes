import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;
    static int[][] ice;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    static void rotate(int x) {
        int[][] temp = new int[(1 << N)][(1 << N)];
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < (1 << N); j++) {
                temp[i][j] = ice[i][j];
            }
        }
        for (int i = 0; i < (1 << N); i += (1 << x)) {
            for (int j = 0; j < (1 << N); j += (1 << x)) {
                for (int k = 0; k < (1 << x); k++) {
                    for (int l = 0; l < (1 << x); l++) {
                        ice[i + l][j + (1 << x) - 1 - k] = temp[i + k][j + l];
                    }
                }
            }
        }
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < (1 << N); j++) {
                if (ice[i][j] == 0) continue;
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k], nx = j + dx[k];
                    if (0 > ny || ny >= (1 << N) || 0 > nx || nx >= (1 << N) || ice[ny][nx] == 0) continue;
                    cnt++;
                }
                if (cnt < 3)
                    temp[i][j] = -1;
            }
        }
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < (1 << N); j++) {
                if (temp[i][j] == -1)
                    ice[i][j]--;
            }
        }
    }

    static int[] bfs(int y, int x) {
        int squares = 1, sum = ice[y][x];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        ice[y][x] = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cy = curr[0], cx = curr[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i], nx = cx + dx[i];
                if (0 > ny || ny >= (1 << N) || 0 > nx || nx >= (1 << N) || ice[ny][nx] == 0) continue;
                squares++;
                sum += ice[ny][nx];
                ice[ny][nx] = 0;
                q.add(new int[] {ny, nx});
            }
        }
        return new int[] { squares, sum };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        ice = new int[(1 << N)][(1 << N)];
        for (int i = 0; i < (1 << N); i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < (1 << N); j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int x = Integer.parseInt(st.nextToken());
            rotate(x);
        }
        int sum = 0, mx = 0;
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < (1 << N); j++) {
                if (ice[i][j] == 0) continue;
                int[] res = bfs(i, j);
                int squares = res[0], sz = res[1];
                sum += sz;
                mx = Math.max(mx, squares);
            }
        }
        System.out.println(sum);
        System.out.print(mx);
    }
}