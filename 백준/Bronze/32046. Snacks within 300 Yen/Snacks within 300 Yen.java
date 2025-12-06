import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int cost = Integer.parseInt(st.nextToken());
                if (sum + cost > 300) continue;
                sum += cost;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}