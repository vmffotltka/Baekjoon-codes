import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        int mx = -1, streak = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                streak++;
            }
            else {
                mx = Math.max(mx, streak);
                streak = 0;
            }
        }
        mx = Math.max(mx, streak);
        System.out.print(mx < k ? 1 : 0);
    }
}