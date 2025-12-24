import java.io.*;
import java.util.*;

public class Main {

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            if (i != 0) cnt++;
            long bunja = (i != 0 ? arr[i] - arr[i - 1] : 0), bunmo = 1;
            for (int j = i - 2; j >= 0; j--) {
                long x = i - j, y = arr[i] - arr[j];
                long g = gcd(Math.abs(x), Math.abs(y));
                x /= g;
                y /= g;
                if (bunja * x > bunmo * y) {
                    cnt++;
                    bunja = y;
                    bunmo = x;
                }
            }
            if (i != n - 1) cnt++;
            bunja = (i != n - 1 ? arr[i + 1] - arr[i] : 0); bunmo = 1;
            for (int j = i + 2; j < n; j++) {
                long x = j - i, y = arr[j] - arr[i];
                long g = gcd(Math.abs(x), Math.abs(y));
                x /= g;
                y /= g;
                if (bunja * x < bunmo * y) {
                    cnt++;
                    bunja = y;
                    bunmo = x;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}