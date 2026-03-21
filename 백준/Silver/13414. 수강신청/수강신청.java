import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            set.remove(s);
            set.add(s);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        for (int i = 0; i < k; i++) {
            if (!it.hasNext()) break;
            sb.append(it.next()).append('\n');
        }
        System.out.print(sb);
    }
}