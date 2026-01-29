import java.io.*;
import java.util.*;

public class Main {

    static HashSet<Integer> visited = new HashSet<>();
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int [] D = {
            100000000,
            10000000,
            1000000,
            100000,
            10000,
            1000,
            100,
            10,
            1
    };

    static int bfs(int start) {
        if (start == 123456789)
            return 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        int move = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            move++;
            for (int s = 0; s < size; s++) {
                int cur = q.poll();

                int ninePos = -1;
                int temp = cur;
                for (int i = 0; i < 9; i++) {
                    if ((cur / D[i]) % 10 == 9) {
                        ninePos = i;
                        break;
                    }
                }
                int x = ninePos / 3;
                int y = ninePos % 3;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3)
                        continue;

                    int targetPos = nx * 3 + ny;
                    int targetDigit = (cur / D[targetPos]) % 10;
                    int next = cur;
                    next -= 9 * D[ninePos];
                    next -= targetDigit * D[targetPos];
                    next += targetDigit * D[ninePos];
                    next += 9 * D[targetPos];

                    if (next == 123456789) return move;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.add(next);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int p = Integer.parseInt(st.nextToken());
                if (p == 0)
                    p = 9;
                start = start * 10 + p;
            }
        }
        System.out.print(bfs(start));
    }
}