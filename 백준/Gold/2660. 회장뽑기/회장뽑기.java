import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) arr.add(new ArrayList<>());
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (u == -1) break;
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        int mn = Integer.MAX_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[n + 1];
            q.add(i);
            vis[i] = true;
            int depth = -1;
            while (!q.isEmpty()) {
                int len = q.size();
                while (len-- > 0) {
                    int u = q.poll();
                    for (int v : arr.get(u)) {
                        if (vis[v]) continue;
                        vis[v] = true;
                        q.add(v);
                    }
                }
                depth++;
            }
            if (mn > depth) {
                mn = depth;
                ans.clear();
                ans.add(i);
            }
            else if (mn == depth)
                ans.add(i);
        }
        StringBuilder sb = new StringBuilder().append(mn).append(' ').append(ans.size()).append('\n');
        for (int item : ans)
            sb.append(item).append(' ');
        System.out.print(sb);
    }
}