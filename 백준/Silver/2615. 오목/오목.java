import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb =  new StringBuilder();
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (arr[i][j] == 0) continue;
                int stone = arr[i][j], cnt = 0;
                boolean flag = false;

                if (i == 0 || j == 0 || arr[i - 1][j - 1] != stone) {
                    for (int k = 1; k < 19; k++) {
                        if (i + k >= 19 || j + k >= 19 || arr[i + k][j + k] != stone) break;
                        cnt++;
                    }
                    if (cnt == 4)
                        flag = true;
                }

                if (j == 0 || arr[i][j - 1] != stone) {
                    cnt = 0;
                    for (int k = 1; k < 19; k++) {
                        if (j + k >= 19 || arr[i][j + k] != stone) break;
                        cnt++;
                    }
                    if (cnt == 4)
                        flag = true;
                }

                if (i == 0 || arr[i - 1][j] != stone) {
                    cnt = 0;
                    for (int k = 1; k < 19; k++) {
                        if (i + k >= 19 || arr[i + k][j] != stone) break;
                        cnt++;
                    }
                    if (cnt == 4)
                        flag = true;
                }

                if (i == 18 || j == 0 || arr[i + 1][j - 1] != stone) {
                    cnt = 0;
                    for (int k = 1; k < 19; k++) {
                        if (i - k < 0 || j + k >= 19 || arr[i - k][j + k] != stone) break;
                        cnt++;
                    }
                    if (cnt == 4)
                        flag = true;
                }

                if (flag) {
                    sb.append(stone).append('\n').append(i + 1).append(' ').append(j + 1);
                    System.out.print(sb);
                    return;
                }
            }
        }
        System.out.print(0);
    }
}