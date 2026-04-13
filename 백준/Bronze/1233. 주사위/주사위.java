import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] cnt = new int[a + b + c + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    cnt[i + j + k]++;
                }
            }
        }
        int mx = 0, ans = 0;
        for (int i = 1; i <= a + b + c; i++) {
            if (cnt[i] > mx) {
                mx = cnt[i];
                ans = i;
            }
        }
        System.out.print(ans);
    }
}