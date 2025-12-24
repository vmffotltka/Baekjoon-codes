import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int pw = 1;
        int[] arr = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long num = 0;
        for (int i = 0; i < m; i++) {
            num += (long) arr[i] * pw;
            pw *= a;
        }
        ArrayList<Long> ans = new ArrayList<>();
        while (num > 0) {
            ans.add(num % b);
            num /= b;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i)).append(" ");
        }
        System.out.print(sb);
    }
}