import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            char prev = st.nextToken().charAt(0);
            int ans = prev == '!' ? 10 : prev - '0';
            for (int i = 0; i < n; i++) {
                char c = st.nextToken().charAt(0);
                char x = st.nextToken().charAt(0);
                int num = (x == '!' ? 10 : x - '0');
                ans += num;
            }
            if (ans > 9)
                sb.append("!\n");
            else
                sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}