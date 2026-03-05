import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            double mn = Double.MAX_VALUE;
            int ans = -1;
            for (int j = 0; j < n; j++) {
                int speed = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                double time = dist / (double) speed;
                if (mn > time) {
                    mn = time;
                    ans = j + 1;
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}