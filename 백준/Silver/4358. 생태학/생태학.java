import java.io.*;
import java.util.*;

public class Main {

    static class Program {
        String name;
        int count;
        Program(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        Map<String, Integer> m = new HashMap<>();
        int n = 0;
        while ((s = br.readLine()) != null) {
            m.put(s, m.getOrDefault(s, 0) + 1);
            n++;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Program> arr = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            arr.add(new Program(entry.getKey(), entry.getValue()));
        }
        arr.sort((p1, p2) -> p1.name.compareTo(p2.name));
        for (Program p : arr) {
            sb.append(p.name).append(' ').append(String.format("%.4f", 100.0 * p.count / n)).append('\n');
        }
        System.out.println(sb);
    }
}