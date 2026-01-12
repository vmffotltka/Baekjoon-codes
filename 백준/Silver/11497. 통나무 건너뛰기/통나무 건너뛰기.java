import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            int mx = -1;
            for (int i = 2; i < n; i += 2) {
                int gap = list.get(i) - list.get(i - 2);
                mx = Math.max(mx, gap);
            }
            for (int i = (n % 2 == 0 ? n - 1 : n - 2); i > 2; i -= 2) {
                int gap = list.get(i) - list.get(i - 2);
                mx = Math.max(mx, gap);
            }
            sb.append(mx).append('\n');
        }
        System.out.print(sb);
    }
}