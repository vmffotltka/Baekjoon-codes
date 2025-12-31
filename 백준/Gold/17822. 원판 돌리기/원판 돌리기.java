import java.io.*;
import java.util.*;

public class Main {

    static int N, M, T;
    static int[][] arr;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };
    static void rotate(int x, int d, int k) {
        for (int i = x - 1; i < N; i += x) {
            for (int j = 0; j < k; j++) {
                if (d == 0) {
                    int temp = arr[i][M - 1];
                    for (int m = M - 1; m > 0; m--) {
                        arr[i][m] = arr[i][m - 1];
                    }
                    arr[i][0] = temp;
                } else {
                    int temp = arr[i][0];
                    for (int m = 0; m < M - 1; m++) {
                        arr[i][m] = arr[i][m + 1];
                    }
                    arr[i][M - 1] = temp;
                }
            }
        }
    }
    static boolean removeAdjacent() {
        boolean[][] toRemove = new boolean[N][M];
        boolean hasRemoved = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) continue;
                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d], nj = (j + dy[d] + M) % M;
                    if (ni < 0 || ni >= N) continue;
                    if (arr[i][j] == arr[ni][nj]) {
                        toRemove[i][j] = true;
                        toRemove[ni][nj] = true;
                        hasRemoved = true;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (toRemove[i][j]) {
                    arr[i][j] = 0;
                }
            }
        }

        return hasRemoved;
    }
    static void adjustNumbers() {
        int sum = 0, count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0) {
                    sum += arr[i][j];
                    count++;
                }
            }
        }
        if (count == 0) return;
        double avg = (double) sum / count;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) continue;
                if (arr[i][j] > avg) {
                    arr[i][j]--;
                } else if (arr[i][j] < avg) {
                    arr[i][j]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            rotate(x, d, k);
            if (!removeAdjacent()) {
                adjustNumbers();
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result += arr[i][j];
            }
        }
        System.out.print(result);
    }
}