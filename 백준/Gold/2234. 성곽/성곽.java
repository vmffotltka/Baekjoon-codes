import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dy = { 0, -1, 0, 1 };
    static int[] dx = { -1, 0, 1, 0 };
    static int[][] room;
    static HashMap<Integer, Integer> roomSize = new HashMap<>();
    static int roomNum = 0;

    static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        int size = 1;
        room[y][x] = roomNum;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curY = cur[0], curX = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i], nx = curX + dx[i];
                if (0 > ny || ny >= N || 0 > nx || nx >= M || room[ny][nx] != 0) continue;
                if (((1 << i) & map[curY][curX]) > 0) continue;
                room[ny][nx] = roomNum;
                size++;
                q.offer(new int[] { ny, nx });
            }
        }
        roomSize.put(roomNum, size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int size = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] != 0) continue;
                roomNum++;
                bfs(i, j);
                size = Math.max(size, roomSize.get(roomNum));
            }
        }
        int mx = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k], nx = j + dx[k];
                    if (0 > ny || ny >= N || 0 > nx || nx >= M || room[ny][nx] == room[i][j]) continue;
                    mx = Math.max(mx, roomSize.get(room[ny][nx]) + roomSize.get(room[i][j]));
                }
            }
        }
        System.out.println(roomNum);
        System.out.println(size);
        System.out.print(mx);
    }
}