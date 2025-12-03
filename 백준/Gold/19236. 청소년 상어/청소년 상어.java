import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static class Fish {
        int num, dir;
        public Fish(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }

    static void fishMove(Fish[][] fish, int sharkY, int sharkX) {
        for (int num = 1; num <= 16; num++) {
            for (int i = 0; i < 4; i++) {
                boolean moved = false;
                for (int j = 0; j < 4; j++) {
                    if ((sharkY == i && sharkX == j) || fish[i][j] == null || (fish[i][j] != null && fish[i][j].num != num)) continue;
                    moved = true;
                    for (int k = fish[i][j].dir, t = 0; t < 8; k = (k + 1) % 8, t++) {
                        int ny = i + dy[k], nx = j + dx[k];
                        if (0 > ny || ny >= 4 || 0 > nx || nx >= 4 || (sharkY == ny && sharkX == nx)) continue;
                        fish[i][j].dir = k;
                        if (fish[ny][nx] != null) {
                            Fish tmp = fish[ny][nx];
                            fish[ny][nx] = fish[i][j];
                            fish[i][j] = tmp;
                        }
                        else {
                            fish[ny][nx] = fish[i][j];
                            fish[i][j] = null;
                        }
                        break;
                    }
                    break;
                }
                if (moved) break;
            }
        }
    }

    static int ans = 0;
    static void dfs(Fish[][] fish, int sharkY, int sharkX, int sharkDir, int currentScore) {
        fishMove(fish, sharkY, sharkX);
        boolean moved = false;
        for (int i = 1; i < 4; i++) {
            int ny = sharkY + dy[sharkDir] * i, nx = sharkX + dx[sharkDir] * i;
            if (0 > ny || ny >= 4 || 0 > nx || nx >= 4) break;

            Fish[][] clone = new Fish[4][4];
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    if (fish[a][b] == null) continue;
                    clone[a][b] = new Fish(fish[a][b].num, fish[a][b].dir);
                }
            }

            Fish next = clone[ny][nx];
            if (next == null) continue;

            int num = next.num, dir = next.dir;
            moved = true;
            clone[ny][nx] = null;
            dfs(clone, ny, nx, dir, currentScore + num);
            clone[ny][nx] = next;
        }
        if (!moved)
            ans = Math.max(ans, currentScore);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Fish[][] fish = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                fish[i][j] = new Fish(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1);
            }
        }

        int sharkY = 0, sharkX = 0, sharkDir = fish[0][0].dir;
        ans = fish[0][0].num;
        fish[0][0] = null;
        dfs(fish, sharkY, sharkX, sharkDir, ans);
        System.out.print(ans);
    }
}