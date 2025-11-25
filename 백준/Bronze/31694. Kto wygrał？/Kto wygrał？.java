import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] cnt = new int[2][11];
        int[] score = new int[2];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 18; j++) {
                int p = Integer.parseInt(st.nextToken());
                score[i] += p;
                cnt[i][p]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        String player1 = "Algosia", player2 = "Bajtek";
        if (score[0] > score[1]) sb.append(player1);
        else if (score[0] < score[1]) sb.append(player2);
        else {
            for (int i = 10; i >= 0; i--) {
                if (cnt[0][i] > cnt[1][i]) {
                    sb.append(player1);
                    break;
                }
                else if (cnt[0][i] < cnt[1][i]) {
                    sb.append(player2);
                    break;
                }
            }
        }
        System.out.print(sb.isEmpty() ? "remis" : sb);
    }
}