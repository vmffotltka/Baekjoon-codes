import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new  StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[][] cnt = new int[m]['Z' - 'A' + 1];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++)
                cnt[j][s.charAt(j) - 'A']++;
        }

        int hamming = 0;
        for (int i = 0; i < m; i++) {
            int mx = 0, mxChar = 0;
            for (int j = 0; j < 'Z' - 'A' + 1; j++) {
                if (cnt[i][j] > mx) {
                    mx = cnt[i][j];
                    mxChar = j;
                }
            }
            hamming += n - mx;
            sb.append((char)(mxChar + 'A'));
        }
        sb.append('\n').append(hamming);
        System.out.print(sb);
    }
}