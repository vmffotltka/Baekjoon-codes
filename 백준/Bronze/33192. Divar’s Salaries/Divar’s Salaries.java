import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int work = k - h;
            int ans = h * x * 2;
            if (work > 140)
                ans += 140 * x + (work - 140) * x * 3 / 2;
            else
                ans += work * x;
            sb.append(String.format("%,d\n", ans));
        }
        System.out.print(sb);
    }
}