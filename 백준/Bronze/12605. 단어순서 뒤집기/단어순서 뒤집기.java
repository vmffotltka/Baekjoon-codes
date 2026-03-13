import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            sb.append("Case #" + i + ": ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<String> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
            for (int j = list.size() - 1; j >= 0; j--) {
                sb.append(list.get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}