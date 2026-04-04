import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] to = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            to[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            boolean flag = false;
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken()) - 1;
                if (to[num] > 0) {
                    flag = true;
                    to[num]--;
                    sb.append(num + 1).append(" ");
                    break;
                }
            }
            if (!flag) {
                sb.append("-1 ");
            }
        }
        System.out.print(sb);
    }
}