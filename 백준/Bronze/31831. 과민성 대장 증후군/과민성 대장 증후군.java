import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int stress = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            stress = Math.max(0, stress + p);
            if (stress >= m) ans++;
        }
        System.out.print(ans);
    }
}