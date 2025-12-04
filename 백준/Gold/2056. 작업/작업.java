import java.io.*;
import java.util.*;

public class Main {

    static int[] inDegree, endedTime, duration;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inDegree = new int[n + 1];
        endedTime = new int[n + 1];
        duration = new int[n + 1];
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            endedTime[i] = time;
            duration[i] = time;
            int nextTask = Integer.parseInt(st.nextToken());
            if (nextTask == 0) q.add(i);
            inDegree[i] = nextTask;
            for (int j = 0; j < nextTask; j++) {
                int parent = Integer.parseInt(st.nextToken());
                adj.get(parent).add(i);
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans = Math.max(ans, endedTime[cur]);
            for (int next : adj.get(cur)) {
                endedTime[next] = Math.max(endedTime[next], endedTime[cur] + duration[next]);
                if (--inDegree[next] == 0)
                    q.add(next);
            }
        }
        System.out.print(ans);
    }
}