import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] edges = new ArrayList[101];
	static boolean[] visited = new boolean[101];
	
	static boolean dfs(int node, int target) {
		visited[node] = true;
		for (int next : edges[node]) {
			if (next == target) return true;
			if (visited[next]) continue;
			if (dfs(next, target))
				return true;
		}
		return false;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
        	edges[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(br.readLine());
        	edges[i + 1].add(p);
        }
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
        	Arrays.fill(visited, false);
        	if (dfs(i, i)) {
        		ans++;
        		sb.append(i + "\n");
        	}
        }
        bw.write(String.valueOf(ans) + "\n" + sb.toString());
        bw.flush();
    }
}