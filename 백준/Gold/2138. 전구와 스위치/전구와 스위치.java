import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    static int count(String target) {
        int[] clone = new int[N];
        for (int i = 0; i < N; i++) {
            clone[i] = arr[i];
        }

        int ret = 0;
        for (int i = 1; i < N; i++) {
            if (clone[i - 1] != target.charAt(i - 1) - '0') {
                ret++;
                clone[i - 1] = 1 - clone[i - 1];
                clone[i] = 1 - clone[i];
                if (i + 1 < N) {
                    clone[i + 1] = 1 - clone[i + 1];
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            if (clone[i] != target.charAt(i) - '0') {
                flag = false;
                break;
            }
        }
        return flag ? ret : Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        String target = br.readLine();
        StringBuilder sb = new StringBuilder(target);
        sb.setCharAt(0, (char)(1 - (target.charAt(0) - '0') + '0'));
        sb.setCharAt(1, (char)(1 - (target.charAt(1) - '0') + '0'));

        int ans = count(target);
        int temp = count(sb.toString());
        if (temp != Integer.MAX_VALUE) {
            ans = Math.min(ans, temp + 1);
        }

        sb = new StringBuilder(target);
        sb.setCharAt(N - 1, (char)(1 - (target.charAt(N - 1) - '0') + '0'));
        sb.setCharAt(N - 2, (char)(1 - (target.charAt(N - 2) - '0') + '0'));
        temp = count(sb.toString());
        if (temp != Integer.MAX_VALUE) {
            ans = Math.min(ans, temp + 1);
        }

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}