import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 201;
            int b = Integer.parseInt(st.nextToken()) - 201;
            int inner = (b + 43 - a) % 43;
            int outer = (a + 43 - b) % 43;
            if (inner == outer) sb.append("Same\n");
            else if (inner < outer) sb.append("Inner circle line\n");
            else sb.append("Outer circle line\n");
        }
        System.out.print(sb);
    }
}