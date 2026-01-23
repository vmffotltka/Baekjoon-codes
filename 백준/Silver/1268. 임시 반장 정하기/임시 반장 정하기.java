import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 1, mx = 0;
        for (int i = 0; i < n; i++) {
            int matched = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int cnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) cnt++;
                }
                if (cnt > 0) matched++;
            }
            if (matched > mx) {
                mx = matched;
                ans = i + 1;
            }
        }
        System.out.print(ans);
    }
}