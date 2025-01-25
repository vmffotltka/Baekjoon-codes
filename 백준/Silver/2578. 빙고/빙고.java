import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr = new int[5][5];
    static int[] Y = new int[25];
    static int[] X = new int[25];

    public static int bingoCount() {
        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            boolean bingo = true;

            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != 0) bingo = false;
            }
            if (bingo) cnt++;

            bingo = true;

            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != 0) bingo = false;
            }
            if (bingo) cnt++;
        }

        boolean bingo = true;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] != 0) bingo = false;
        }
        if (bingo) cnt++;

        bingo = true;
        for (int i = 0; i < 5; i++) {
            if (arr[i][4 - i] != 0) bingo = false;
        }
        if (bingo) cnt++;

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int value = Integer.parseInt(st.nextToken()) - 1;
                arr[i][j] = value;
                Y[value] = i;
                X[value] = j;
            }
        }

        List<Integer> calls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                calls.add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        for (int i = 0; i < calls.size(); i++) {
            int p = calls.get(i);
            arr[Y[p]][X[p]] = 0;

            int cnt = bingoCount();
            if (cnt >= 3) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
