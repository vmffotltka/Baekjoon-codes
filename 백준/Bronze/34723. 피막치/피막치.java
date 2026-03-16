import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine()), mn = Integer.MAX_VALUE;
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= c; k++) {
                    mn = Math.min(mn, Math.abs((i + j) * (j + k) - x));
                }
            }
        }
        System.out.print(mn);
    }
}