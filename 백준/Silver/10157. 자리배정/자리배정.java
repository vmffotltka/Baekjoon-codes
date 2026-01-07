import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int garo = Integer.parseInt(st.nextToken());
        int sero = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        if (k > garo * sero) {
            System.out.print(0);
            return;
        }

        int[][] board = new int[sero][garo];
        int num = 1;
        int y = 0, x = 0, dir = 0;
        while (k-- > 0) {
            board[y][x] = num++;
            if (k == 0) break;
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny < 0 || ny >= sero || nx < 0 || nx >= garo || board[ny][nx] != 0) {
                dir = (dir + 1) % 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            y = ny;
            x = nx;
        }
        System.out.print((x + 1) + " " + (y + 1));
    }
}