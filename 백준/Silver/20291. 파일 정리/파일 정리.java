import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> m = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            String s = st.nextToken();
            s = st.nextToken();
            m.put(s, m.getOrDefault(s, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        m.forEach((k,v) -> sb.append(k).append(' ').append(v).append('\n'));
        System.out.print(sb);
    }
}