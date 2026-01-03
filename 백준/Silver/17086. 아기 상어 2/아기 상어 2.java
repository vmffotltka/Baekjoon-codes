import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] grid;
    static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static int[] dy = { 1, 1, 1, 0, -1, -1, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    q.add(new int[]{ i, j, 0 });
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1], day = cur[2];
            for (int dir = 0; dir < 8; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (grid[ny][nx] == 0) {
                    grid[ny][nx] = day + 1;
                    ans = Math.max(ans, day + 1);
                    q.add(new int[]{ ny, nx, day + 1 });
                }
            }
        }
        System.out.print(ans);
    }
}