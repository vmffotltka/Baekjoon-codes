import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[51];
        for (int i = 0; i < t * 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cnt[Integer.parseInt(st.nextToken())]++;
            }
        }
        for (int i = 1; i <= 50; i++) {
            if (cnt[i] > 2 * t)
                sb.append(i).append(' ');
        }
        System.out.print(sb.isEmpty() ? -1 : sb);
    }
}