import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] cnt = new int[5];
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                cnt[num]++;
            }

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int[] cnt2 = new int[5];
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                cnt2[num]++;
            }
            int flag = 0;
            for (int i = 4; i > 0; i--) {
                if (cnt[i] != cnt2[i]) {
                    if (cnt[i] > cnt2[i]) flag = 1;
                    else flag = 2;
                    break;
                }
            }
            sb.append(flag == 1 ? "A\n" : (flag == 2 ? "B\n" : "D\n"));
        }
        System.out.print(sb);
    }
}