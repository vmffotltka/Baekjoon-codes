import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        double curX = 0;
        for (int i = 0; i < n; i++) {
            sb.append(curX).append(' ').append("0 0 ").append(curX + x / (double)n).append(' ').append(y).append(' ').append(z).append('\n');
            curX += x / (double)n;
        }
        System.out.print(sb);
    }
}