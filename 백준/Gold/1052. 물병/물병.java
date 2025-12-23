import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int bits = 0;
        for (int i = 0; (1 << i) <= n; i++) {
            if (((1 << i) & n) > 0) bits++;
        }
        if (bits <= k) {
            System.out.print(0);
            return;
        }
        int dif = bits - k, ans = 0;
        for (int i = 0; (1 << i) <= n; i++) {
            if (((1 << i) & n) > 0) {
                if (dif-- > 0)
                    ans -= (1 << i);
                else {
                    ans += (1 << i);
                    break;
                }
            }
        }
        System.out.print(ans);
    }
}