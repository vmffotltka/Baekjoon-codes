import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int mx = -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int a = n, b = i;
            List<Integer> tmp = new ArrayList<>();
            tmp.add(a); tmp.add(b);
            while (true) {
                int c = a - b;
                if (c < 0) break;
                tmp.add(c);
                a = b; b = c;
            }
            if (mx < tmp.size()) {
                list = tmp;
                mx = tmp.size();
            }
        }
        StringBuilder sb = new StringBuilder().append(mx).append("\n");
        for (int i = 0; i < mx; i++) {
            sb.append(list.get(i)).append(' ');
        }
        System.out.print(sb);
    }
}