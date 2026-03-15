import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[6];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            cnt[num]++;
        }
        int flag = 0;
        for (int i = 1; i <= 5; i++) {
            if (cnt[i] == 0) {
                flag = 1;
                break;
            }
        }
        System.out.print(flag > 0 ? "YES" : "NO");
    }
}