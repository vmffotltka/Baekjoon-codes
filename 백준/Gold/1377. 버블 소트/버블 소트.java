import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int num, idx;
        Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            nodes.add(new Node(num, i));
        }
        nodes.sort(Comparator.comparingInt(a -> a.num));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, nodes.get(i).idx - i + 1);
        }
        System.out.print(ans);
    }
}