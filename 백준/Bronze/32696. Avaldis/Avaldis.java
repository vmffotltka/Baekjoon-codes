import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        if (Math.abs(a) == 1) sb.append(a == 1 ? "x" : "-x");
        else if (a != 0) sb.append(a).append("x");
        if (b < 0) sb.append(b);
        else if (b > 0) {
            if (!sb.isEmpty()) sb.append("+");
            sb.append(b);
        }
        if (sb.isEmpty()) sb.append("0");
        System.out.print(sb);
    }
}