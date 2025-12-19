import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static int[] dy = { -1, 1, -2, 2, 0, -1, 1, -1, 1 };
    static int[] dx = { 1, 1, 0, 0, -2, 0, 0, -1, -1 };
    static int[] percentage = { 1, 1, 2, 2, 5, 7, 7, 10, 10 };

    static int tornadoMove(int curY, int curX, int dir) {
        int targetY = curY, targetX = curX;
        if (dir == 0) targetX--;
        else if (dir == 1) targetY++;
        else if (dir == 2) targetX++;
        else targetY--;

        int kickedSand = 0, curSand = arr[targetY][targetX];
        for (int i = 0; i < 9; i++) {
            int DY = dy[i], DX = dx[i];
            for (int j = 0; j < dir; j++) {
                int tmp = DY;
                DY = -DX;
                DX = tmp;
            }
            int ny = targetY + DY, nx = targetX + DX;
            int movingSand = curSand * percentage[i] / 100;
            if (ny < 0 || ny >= N || nx < 0 || nx >= N)
                kickedSand += movingSand;
            else
                arr[ny][nx] += movingSand;

            arr[targetY][targetX] -= movingSand;
        }

        int finalX = targetX, finalY = targetY;
        if (dir == 0) finalX--;
        else if (dir == 1) finalY++;
        else if (dir == 2) finalX++;
        else finalY--;
        if (finalY < 0 || finalY >= N || finalX < 0 || finalX >= N)
            kickedSand += arr[targetY][targetX];
        else
            arr[finalY][finalX] += arr[targetY][targetX];

        arr[targetY][targetX] = 0;

        return kickedSand;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int flag = 2, len = 1, t = 1, y = N / 2, x = N / 2, dir = 0, ans = 0;
        while (true) {
            ans += tornadoMove(y, x, dir);
            if (dir == 0) x--;
            else if (dir == 1) y++;
            else if (dir == 2) x++;
            else if (dir == 3) y--;

            if (x == 0 && y == 0) break;

            t--;
            if (t == 0) {
                flag--;
                dir = (dir + 1) % 4;
                if (flag == 0) {
                    flag = 2;
                    len++;
                }
                t = len;
            }
        }
        System.out.print(ans);
    }
}