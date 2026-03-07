import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for (char c : s.toCharArray()) {
                sb.append((c - '0' + k) % 10);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}