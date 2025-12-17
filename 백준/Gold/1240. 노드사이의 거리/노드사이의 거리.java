import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int num, wei;
        Node(int num, int wei) {
            this.num = num;
            this.wei = wei;
        }
    }
    static int N, M;
    static List<List<Node>> adj;
    static boolean[] visited;

    static int bfs(int start, int dest) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        Arrays.fill(visited, false);
        visited[start] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node next : adj.get(cur.num)) {
                if (visited[next.num]) continue;
                visited[next.num] = true;
                if (next.num == dest)
                    return next.wei + cur.wei;
                q.offer(new Node(next.num, next.wei + cur.wei));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Node(v, d));
            adj.get(v).add(new Node(u, d));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(bfs(a, b)).append("\n");
        }
        System.out.print(sb);
    }
}