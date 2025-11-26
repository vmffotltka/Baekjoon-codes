import java.io.*;
import java.util.*;

public class Main {

    static class Coor {
        int y, x, num;
        public Coor(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }
    }

    static int N, K, S;
    static int[][] arr;
    static int[] dy = { 0, 0, 1, -1 };
    static int[] dx = { 1, -1, 0, 0 };
    static Queue<Coor> q = new LinkedList<>();

    static void bfs() {
        int time = 0;
        while (time < S) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Coor c = q.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = c.y + dy[j], nx = c.x + dx[j];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N || arr[ny][nx] != 0) continue;
                    arr[ny][nx] = c.num;
                    q.add(new Coor(ny, nx, c.num));
                }
            }
            time++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        ArrayList<Coor> a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0) {
                    a.add(new Coor(i, j, arr[i][j]));
                }
            }
        }
        a.sort(Comparator.comparingInt(o -> o.num));
        q.addAll(a);
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;
        bfs();
        System.out.print(arr[y][x]);
    }
}