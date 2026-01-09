import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int[] cnt = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++) {
            int num = Integer.parseInt(st.nextToken());
            cnt[num]++;
        }
        int n = Integer.parseInt(br.readLine());
        if (cnt[n] > 0) {
            System.out.print(0);
            return;
        }
        int left = 0, right = 0;
        for (int i = n - 1; i >= 1 && cnt[i] == 0; i--) {
            left++;
        }
        for (int i = n + 1; i <= 1000 && cnt[i] == 0; i++) {
            right++;
        }
        System.out.print(left * right + left + right);
    }
}