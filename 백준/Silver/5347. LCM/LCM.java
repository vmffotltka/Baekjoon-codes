import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long A = a, B = b;
            while (true) {
                long C = A % B;
                if (C == 0) break;
                A = B;
                B = C;
            }
            sb.append((a / B) * b).append('\n');
        }
        System.out.print(sb);
    }
}