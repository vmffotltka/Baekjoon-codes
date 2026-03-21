import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> order = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            order.put(s, i);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(order.entrySet());
        list.sort(Map.Entry.comparingByValue());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(k, list.size()); i++) {
            sb.append(list.get(i).getKey()).append('\n');
        }
        System.out.print(sb);
    }
}