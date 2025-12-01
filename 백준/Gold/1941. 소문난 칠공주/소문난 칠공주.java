import java.io.*;
import java.util.*;

public class Main {

    static String[] arr = new String[5];
    static int[] bits = new int[5];
    static int[] dy = { 0, 0, 1, -1 };
    static int[] dx = { 1, -1, 0, 0 };
    static int ans = 0;

    static class Coor {
        int y, x;
        public Coor(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static boolean isConnected(int idx) {
        int[][] target = new int[idx][5];
        int y = -1, x = -1;
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < 5; j++) {
                target[i][j] = (bits[i] & (1 << j)) > 0 ? 1 : 0;
                if (target[i][j] == 1 && y == -1) {
                    y = i;
                    x = j;
                }
            }
        }
        if (y == -1) return false;

        Queue<Coor> q = new LinkedList<>();
        q.offer(new Coor(y, x));
        target[y][x] = 0;
        int cnt = 1;
        while (!q.isEmpty()) {
            Coor c = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = c.y + dy[i], nx = c.x + dx[i];
                if (0 > ny || ny >= idx || 0 > nx || nx >= 5 || target[ny][nx] == 0) continue;
                target[ny][nx] = 0;
                cnt++;
                q.offer(new Coor(ny, nx));
            }
        }
        return cnt == 7;
    }

    static void dfs(int idx, int cnt) {
        if (cnt == 7 || idx == 5) {
            if (!isConnected(idx)) return;

            int dasomCnt = 0;
            for (int i = 0; i < idx; i++) {
                for (int j = 0; j < 5; j++) {
                    if (((bits[i] & (1 << j)) > 0) && arr[i].charAt(j) == 'S')
                        dasomCnt++;
                }
            }
            if (dasomCnt >= 4)
                ans++;
            return;
        }
        for (int i = 0; i < (1 << 5); i++) {
            int bitCnt = 0;
            for (int j = 0; j < 5; j++) {
                if ((i & (1 << j)) > 0) bitCnt++;
            }
            if (bitCnt + cnt <= 7) {
                bits[idx] = i;
                dfs(idx + 1, cnt + bitCnt);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++)
            arr[i] = br.readLine();

        dfs(0, 0);
        System.out.print(ans);
    }
}