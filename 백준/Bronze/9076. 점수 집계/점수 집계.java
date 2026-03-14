import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 5; i++)
                list.add(Integer.parseInt(st.nextToken()));

            Collections.sort(list);
            if (list.get(3) - list.get(1) >= 4)
                sb.append("KIN\n");
            else
                sb.append(list.get(1) + list.get(2) + list.get(3)).append('\n');
        }
        System.out.print(sb);
    }
}