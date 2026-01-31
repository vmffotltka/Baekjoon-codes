import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> edge;
    static List<List<Integer>> rev;
    static boolean[] visited;

    static int dfs(int node, List<List<Integer>> graph) {
        int ret = 1;
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                ret += dfs(neighbor, graph);
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        edge = new ArrayList<>();
        rev = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edge.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge.get(a).add(b);
            rev.get(b).add(a);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int cnt = -1;
            cnt += dfs(i, edge);
            cnt += dfs(i, rev);
            sb.append(n - cnt).append('\n');
        }
        System.out.print(sb);
    }
}