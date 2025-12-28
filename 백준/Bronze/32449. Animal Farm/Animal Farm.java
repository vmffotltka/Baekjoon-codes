import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int mx = 0, idx = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String animal = st.nextToken();
            int influence = Integer.parseInt(st.nextToken());
            if (animal.equals("pig"))
                mx = Math.max(mx, influence);
            else
                arr[idx++] = influence;
        }
        long ans = mx;
        for (int i = 0; i < idx; i++) {
            if (arr[i] < mx)
                ans += arr[i];
        }
        System.out.print(ans);
    }
}