import java.io.*;
import java.util.*;

public class Main {

    static int sero, garo, k, ans = 0;
    static String[] map;
    static boolean[][] visited;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static void dfs(int y, int x, int depth) {
        if (depth == k) {
            if (y == 0 && x == garo - 1)
                ans++;
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny < 0 || ny >= sero || nx < 0 || nx >= garo)
                continue;
            if (map[ny].charAt(nx) == 'T' || visited[ny][nx])
                continue;
            visited[ny][nx] = true;
            dfs(ny, nx, depth + 1);
            visited[ny][nx] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        sero = Integer.parseInt(st.nextToken());
        garo = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new String[sero];
        visited = new boolean[sero][garo];
        for (int i = 0; i < sero; i++) {
            map[i] = br.readLine();
        }
        visited[sero - 1][0] = true;
        dfs(sero - 1, 0, 1);
        System.out.print(ans);
    }
}