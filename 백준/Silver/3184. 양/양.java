import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = { 0, 0, 1, -1 };
    static int[] dx = { 1, -1, 0, 0 };
    static class Coor {
        int y, x;
        Coor(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sero = Integer.parseInt(st.nextToken());
        int garo = Integer.parseInt(st.nextToken());
        String[] arr = new String[sero];
        for (int i = 0; i < sero; i++) {
            arr[i] =  br.readLine();
        }
        Queue<Coor> q = new LinkedList<>();
        boolean[][] vis = new boolean[sero][garo];
        int survivedSheep = 0, survivedWolf = 0;
        for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
                if (arr[i].charAt(j) == '#' || vis[i][j]) continue;
                q.clear();
                q.add(new Coor(i, j));
                vis[i][j] = true;
                int sheep = arr[i].charAt(j) == 'o' ? 1 : 0, wolf = arr[i].charAt(j) == 'v' ? 1 : 0;
                while (!q.isEmpty()) {
                    Coor c = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int ny = c.y + dy[k], nx = c.x + dx[k];
                        if (0 > ny || ny >= sero || 0 > nx || nx >= garo || arr[ny].charAt(nx) == '#' || vis[ny][nx]) continue;
                        vis[ny][nx] = true;
                        q.add(new Coor(ny, nx));
                        if (arr[ny].charAt(nx) == 'o') sheep++;
                        else if (arr[ny].charAt(nx) == 'v') wolf++;
                    }
                }
                if (sheep > wolf)
                    survivedSheep += sheep;
                else
                    survivedWolf += wolf;
            }
        }
        System.out.print(survivedSheep + " " + survivedWolf);
    }
}