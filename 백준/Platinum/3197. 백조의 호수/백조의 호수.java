import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static String[] grid;
    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };
    static int[][] dist;

    static int dijk(int startY, int startX, int endY, int endX) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{ startY, startX, 0 });
        boolean[][] visited = new boolean[R][C];
        visited[startY][startX] = true;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == endY && cur[1] == endX) {
                return cur[2];
            }
            for (int dir = 0; dir < 4; dir++) {
                int ny = cur[0] + dy[dir], nx = cur[1] + dx[dir];
                if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                pq.offer(new int[]{ ny, nx, Math.max(cur[2], dist[ny][nx]) });
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new String[R];
        dist = new int[R][C];
        Queue<int[]> q = new LinkedList<>();
        int startY = -1, startX = -1, endY = -1, endX = -1;
        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine();
            for (int j = 0; j < C; j++) {
                if (grid[i].charAt(j) != 'X') {
                    q.offer(new int[]{ i, j });
                    if (grid[i].charAt(j) == 'L') {
                        if (startY == -1) {
                            startY = i;
                            startX = j;
                        } else {
                            endY = i;
                            endX = j;
                        }
                    }
                }
                else
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int ny = cur[0] + dy[dir], nx = cur[1] + dx[dir];
                if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
                if (dist[ny][nx] != Integer.MAX_VALUE) continue;
                dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{ ny, nx });
            }
        }
        System.out.print(dijk(startY, startX, endY, endX));
    }
}