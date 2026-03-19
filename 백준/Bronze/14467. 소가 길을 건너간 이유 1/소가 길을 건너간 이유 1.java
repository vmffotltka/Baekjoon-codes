import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int[] pos = new int[11];
        for (int i = 0; i <= 10; i++)
            pos[i] = -1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if (pos[num] == -1)
                pos[num] = p;
            else if (pos[num] != p) {
                ans++;
                pos[num] = p;
            }
        }
        System.out.print(ans);
    }
}