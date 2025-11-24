import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static class Fireball {
        int y, x, m, v, d;
        Fireball(int y, int x, int m, int v, int d) {
            this.y = y;
            this.x = x;
            this.m = m;
            this.v = v;
            this.d = d;
        }
    }

    static List<List<Queue<Fireball>>> fireballs;
    static int[][] sizes;

    static void move() {
        sizes = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sizes[i][j] = fireballs.get(i).get(j).size();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sizes[i][j] == 0) continue;
                for (int k = 0; k < sizes[i][j]; k++) {
                    Fireball cur = fireballs.get(i).get(j).poll();
                    int ny = (cur.y + N + dy[cur.d] * (cur.v % N)) % N;
                    int nx = (cur.x + N + dx[cur.d] * (cur.v % N)) % N;

                    Fireball next = new Fireball(ny, nx, cur.m, cur.v, cur.d);
                    fireballs.get(ny).get(nx).add(next);
                }
            }
        }
    }

    static void merge() {
        int[][] sizes = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sizes[i][j] = fireballs.get(i).get(j).size();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sizes[i][j] < 2) continue;
                int odd = 0, mass = 0, vel = 0;
                for (int k = 0; k < sizes[i][j]; k++) {
                    Fireball cur = fireballs.get(i).get(j).poll();
                    if (cur.d % 2 == 1) odd++;
                    mass += cur.m;
                    vel += cur.v;
                }
                if (mass < 5) continue;
                String dir = odd == sizes[i][j] || odd == 0 ? "0246" : "1357";
                for (int k = 0; k < 4; k++) {
                    fireballs.get(i).get(j).add(new Fireball(i, j, mass / 5, vel / sizes[i][j], dir.charAt(k) - '0'));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        fireballs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            fireballs.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                fireballs.get(i).add(new LinkedList<>());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int mass = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireballs.get(r).get(c).add(new Fireball(r, c, mass, s, d));
        }

        for (int i = 0; i < K; i++) {
            move();
            merge();
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Fireball cur : fireballs.get(i).get(j)) {
                    ans += cur.m;
                }
            }
        }
        System.out.print(ans);
    }
}