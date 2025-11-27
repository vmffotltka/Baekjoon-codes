import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[] arr;
    static int[] dy = { 0, 0, 1, -1 };
    static int[] dx = { 1, -1, 0, 0 };
    static int[][][] dist;

    static class Coor {
        int y, x, wall;
        Coor(int y, int x, int wall) {
            this.y = y;
            this.x = x;
            this.wall = wall;
        }
    }

    static int bfs() {
        Queue<Coor> q = new LinkedList<>();
        q.add(new Coor(0, 0, 0));
        dist[0][0][0] = 0;
        int ret = N == 1 ? 0 : Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Coor c = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = c.y + dy[i], nx = c.x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || c.wall >= ret) continue;
                if (ny == N - 1 && nx == N - 1)
                    ret = Math.min(ret, c.wall);
                if (arr[ny].charAt(nx) == '1' && dist[ny][nx][c.wall] > dist[c.y][c.x][c.wall] + 1) {
                    dist[ny][nx][c.wall] = dist[c.y][c.x][c.wall] + 1;
                    q.add(new Coor(ny, nx, c.wall));
                }
                else if (arr[ny].charAt(nx) == '0' && dist[ny][nx][c.wall + 1] > dist[c.y][c.x][c.wall] + 1) {
                    dist[ny][nx][c.wall + 1] = dist[c.y][c.x][c.wall] + 1;
                    q.add(new Coor(ny, nx, c.wall + 1));
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        dist = new int[N][N][N * N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N * N; k++) {
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        System.out.print(bfs());
    }
}