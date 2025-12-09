import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a += Integer.parseInt(st.nextToken());
            b += Integer.parseInt(st.nextToken());
            sb.append(a - b).append('\n');
        }
        System.out.print(sb);
    }
}