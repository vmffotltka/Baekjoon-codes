import java.io.*;
import java.util.*;

public class Main {

    static String[] adj;
    static boolean[] visited;
    static int N;

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int dist = 0, friends = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int v = q.poll();
                for (int j = 0; j < N; j++) {
                    if (visited[j] || adj[v].charAt(j) == 'N') continue;
                    visited[j] = true;
                    q.offer(j);
                    friends++;
                }
            }
            dist++;
            if (dist == 2) break;
        }
        return friends;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new String[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adj[i] = br.readLine();
        }

        int mx = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            mx = Math.max(mx, bfs(i));
        }
        System.out.print(mx);
    }
}