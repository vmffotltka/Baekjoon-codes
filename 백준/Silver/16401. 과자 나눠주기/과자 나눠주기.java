import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int s = 1, e = 0, ans = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            e = Math.max(e, arr[i]);
        }

        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += arr[i] / mid;
            }
            if (cnt >= m) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.print(ans == -1 ? 0 : ans);
    }
}