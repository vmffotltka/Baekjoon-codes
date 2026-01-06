import java.io.*;
import java.util.*;

public class Main {

    static int MAX = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int s = 1, e = MAX, ans = MAX;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            s = Math.max(s, arr[i]);
        }

        while (s <= e) {
            int mid = (s + e) / 2, count = 0, money = 0;
            for (int i = 0; i < n; i++) {
                if (money < arr[i]) {
                    money = mid;
                    count++;
                }
                money -= arr[i];
            }
            if (count <= m) {
                ans = Math.min(ans, mid);
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        System.out.print(ans);
    }
}