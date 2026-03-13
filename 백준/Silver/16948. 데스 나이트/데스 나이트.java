import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = { -2, -2, 0, 2, 2, 0 };
    static int[] dx = { -1, 1, 2, 1, -1, -2 };
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = -1;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());

        dist[startY][startX] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startY, startX});
        int d = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = queue.poll();
                int y = cur[0], x = cur[1];
                for (int j = 0; j < 6; j++) {
                    int ny = y + dy[j], nx = x + dx[j];
                    if (0 > ny || ny >= n || 0 > nx || nx >= n || dist[ny][nx] != -1)
                        continue;
                    dist[ny][nx] = d + 1;
                    queue.add(new int[] {ny, nx});
                }
            }
            d++;
        }
        System.out.print(dist[endY][endX]);
    }
}