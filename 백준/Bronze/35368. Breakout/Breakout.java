import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] crates = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            crates[num]++;
        }
        int cur = 1, clock = 0;
        while (true) {
            if (cur == x) break;
            clock += crates[cur];
            cur = cur == n ? 1 : cur + 1;
        }
        cur = 1;
        int anti = 0;
        while (true) {
            int next = cur == 1 ? n : cur - 1;
            anti += crates[next];
            cur = next;
            if (next == x) break;
        }
        System.out.print(Math.min(clock, anti));
    }
}