import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            int[] scores = new int[3];
            for (int i = 0; i < 3; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            if (level > 2 || scores[2] < 50) {
                sb.append("NO\n");
                continue;
            }

            int condition1 = 0, condition2 = 0, least = level == 1 ? 100 : 90;
            for (int i = 0; i < 2; i++) {
                if (scores[i] * 3 < least) condition1++;
                if (scores[i] <= 21) condition2++;
            }
            if (condition1 == 2 || condition2 >= 1)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.print(sb);
    }
}