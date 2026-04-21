import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] cnt = new int[n];
        int cur = 0, ans = 0;
        cnt[0] = 1;
        while (true) {
            if (cnt[cur] == m) break;
            if (cnt[cur] % 2 == 1)
                cur = (cur + l) % n;
            else
                cur = (cur + n - l) % n;
            cnt[cur]++;
            ans++;
        }
        System.out.print(ans);
    }
}