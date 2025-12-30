import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static String[] map;
    static boolean[][][] visited;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    static int bfs(int startY, int startX) {
        int ret = -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ startY, startX, 0, 0 });
        visited[startY][startX][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0], x = curr[1], keys = curr[2], steps = curr[3];
            if (map[y].charAt(x) == '1') {
                ret = steps;
                break;
            }
            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir], nx = x + dx[dir];
                int nkeys = keys;
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                char cell = map[ny].charAt(nx);
                if (cell == '#') continue;

                if (cell >= 'a' && cell <= 'f') {
                    nkeys |= (1 << (cell - 'a'));
                }
                if (cell >= 'A' && cell <= 'F') {
                    if ((nkeys & (1 << (cell - 'A'))) == 0) continue;
                }
                if (!visited[ny][nx][nkeys]) {
                    visited[ny][nx][nkeys] = true;
                    q.add(new int[]{ ny, nx, nkeys, steps + 1 });
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N];
        visited = new boolean[N][M][1 << 6];
        int startY = 0, startX = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                if (map[i].charAt(j) == '0') {
                    startY = i;
                    startX = j;
                }
            }
        }
        System.out.print(bfs(startY, startX));
    }
}