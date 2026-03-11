import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int cnt = n == 0 ? 1 : 0;
            for (int i = n; i <= m; i++) {
                int num = i;
                while (num > 0) {
                    if (num % 10 == 0) {
                        cnt++;
                    }
                    num /= 10;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}