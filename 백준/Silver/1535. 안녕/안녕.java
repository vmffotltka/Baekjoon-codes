import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] loss = new int[n], gain = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) loss[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) gain[i] = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 1; i < (1 << n); i++) {
            int l = 0, g = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    l += loss[j];
                    g += gain[j];
                }
            }
            if (l >= 100) continue;
            ans = Math.max(ans, g);
        }
        System.out.print(ans);
    }
}