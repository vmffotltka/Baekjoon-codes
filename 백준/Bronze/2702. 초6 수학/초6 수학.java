import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int A = a, B = b;
            while (true) {
                int C = A % B;
                if (C == 0) break;
                A = B;
                B = C;
            }
            sb.append(Math.max(a, b) * (Math.min(a, b) / B)).append(' ').append(B).append('\n');
        }
        System.out.print(sb);
    }
}