import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            list.add(new ArrayList<>());
        for (char c : s.toCharArray()) {
            int idx = 0;
            if (c == 'r') idx = 1;
            else if (c == 'p') idx = 2;
            while (list.get(idx).size() >= k)
                idx = (idx + 1) % 3;
            list.get(idx).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> l : list) {
            for (char c : l)
                sb.append(c);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}