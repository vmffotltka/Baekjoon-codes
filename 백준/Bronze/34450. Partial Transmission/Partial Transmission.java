import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cnt = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int num = Integer.parseInt(st.nextToken()) - p;
            cnt[num]++;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                ans = i + p;
                break;
            }
        }
        System.out.print(ans);
    }
}