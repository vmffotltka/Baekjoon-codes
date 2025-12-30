import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cnt = new int[100001];
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int left = 0, ans = 0;
        for (int right = 0; right < n; right++) {
            arr[right] = Integer.parseInt(st.nextToken());
            while (cnt[arr[right]] + 1 > k) {
                cnt[arr[left]]--;
                left++;
            }
            cnt[arr[right]]++;
            ans = Math.max(ans, right - left + 1);
        }
        System.out.print(ans);
    }
}