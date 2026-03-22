import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            sb.append("Distances: ");
            for (int i = 0; i < a.length(); i++) {
                char c1 = a.charAt(i), c2 = b.charAt(i);
                if (c1 <= c2)
                    sb.append(c2 - c1);
                else
                    sb.append(c2 + 26 - c1);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}