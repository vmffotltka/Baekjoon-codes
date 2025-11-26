import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int apple = Integer.parseInt(br.readLine());

        int l = 0, r = m - 1, ans = 0;
        for (int i = 0; i < apple; i++) {
            int drop = Integer.parseInt(br.readLine()) - 1;
            if (r < drop) {
                ans += drop - r;
                l += drop - r;
                r = drop;
            }
            else if (drop < l) {
                ans += l - drop;
                r -= l - drop;
                l = drop;
            }
        }
        System.out.print(ans);
    }
}