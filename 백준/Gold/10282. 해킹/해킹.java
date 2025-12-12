import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int num, weight;
        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
    static int N, D, C;
    static int[] dist;
    static List<List<Node>> adj;
    static int[] dijk(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.add(new Node(start, 0));
        int cnt = 0, mxTime = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int n = node.num, w = node.weight;
            if (dist[n] < w) continue;
            for (Node next : adj.get(n)) {
                int nextN = next.num, nextW = next.weight + w;
                if (dist[nextN] <= nextW) continue;
                dist[nextN] = nextW;
                pq.add(new Node(nextN, nextW));
            }
        }
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) continue;
            cnt++;
            mxTime = Math.max(mxTime, dist[i]);
        }
        return new int[]{ cnt, mxTime };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            adj = new ArrayList<>();
            for (int i = 0; i <= N; i++)
                adj.add(new ArrayList<>());

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                adj.get(u).add(new Node(v, w));
            }
            int[] ans = dijk(C);
            sb.append(ans[0]).append(' ').append(ans[1]).append('\n');
        }
        System.out.print(sb);
    }
}