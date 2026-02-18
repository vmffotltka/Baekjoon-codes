import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int dist = Integer.MAX_VALUE, ansY = -1, ansX = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    continue;
                int d = (i + 1) + Math.abs((m + 1) / 2 - (j + 1));
                if (d < dist) {
                    dist = d;
                    ansY = i + 1;
                    ansX = j + 1;
                }
            }
        }
        if (ansY == -1)
            System.out.println(-1);
        else
            System.out.println(ansY + " " + ansX);
    }
}