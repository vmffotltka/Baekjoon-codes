import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0 || j == n - 1 || (i <= n / 2 && (j == i || j == n - i - 1))) sb.append('#');
                    else sb.append('.');
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}