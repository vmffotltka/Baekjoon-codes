import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static int N, M;
    static int MAX = 100;

    static void cmd1(int[][] arr) {
        for (int i = 0; i < N / 2; i++) {
            int[] tmp = arr[i];
            arr[i] = arr[N - i - 1];
            arr[N - i - 1] = tmp;
        }
    }
    static void cmd2(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[i][M - j - 1];
                arr[i][M - j - 1] = tmp;
            }
        }
    }
    static void cmd3(int[][] arr) {
        int[][] tmp = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[j][N - i - 1] = arr[i][j];
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
        int t = N;
        N = M;
        M = t;
    }
    static void cmd4(int[][] arr) {
        int[][] tmp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = arr[j][M - i - 1];
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
        int t = N;
        N = M;
        M = t;
    }
    static void cmd5(int[][] arr) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                tmp[i][j] = arr[i + N / 2][j];
            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                tmp[i][j] = arr[i][j - M / 2];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                tmp[i][j] = arr[i][j + M / 2];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                tmp[i][j] = arr[i - N / 2][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
    }
    static void cmd6(int[][] arr) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                tmp[i][j] = arr[i][j + M / 2];
            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                tmp[i][j] = arr[i + N / 2][j];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                tmp[i][j] = arr[i - N / 2][j];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                tmp[i][j] = arr[i][j - M / 2];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[MAX][MAX];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) cmd1(arr);
            else if (cmd == 2) cmd2(arr);
            else if (cmd == 3) cmd3(arr);
            else if (cmd == 4) cmd4(arr);
            else if (cmd == 5) cmd5(arr);
            else if (cmd == 6) cmd6(arr);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}