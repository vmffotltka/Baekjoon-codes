import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] time = new int[10001];
        int t = 0, sheet = 1;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            for (int j = t; j < t + x; j++) {
                time[j] = sheet;
            }
            t += x;
            sheet++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(time[x]).append('\n');
        }
        System.out.print(sb);
    }
}