import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a = 4 * n - 3, b = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n * 2 - 1; i++) {
            if (i % 2 == 0) {
                sb.append("* ".repeat(b));
                sb.append("*".repeat(a));
                sb.append(" *".repeat(b));
                a -= 4;
                b++;
            }
            else {
                sb.append("* ".repeat(b));
                sb.append(" ".repeat(a));
                sb.append(" *".repeat(b));
            }
            sb.append('\n');
        }
        a += 4; b--;
        for (int i = 0; i < n * 2 - 2; i++) {
            if (i % 2 == 0) {
                sb.append("* ".repeat(b));
                sb.append(" ".repeat(a));
                sb.append(" *".repeat(b));
                b--;
                a += 4;
            }
            else {
                sb.append("* ".repeat(b));
                sb.append("*".repeat(a));
                sb.append(" *".repeat(b));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}