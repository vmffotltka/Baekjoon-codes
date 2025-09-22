import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    
	static class Node {
		int node, cost;
		Node(int n, int c) {
			this.node = n;
			this.cost = c;
		}
	}
	
	static List<List<Node>> adj;
	static boolean[] vis;
	static int start, dest;
	
	static boolean dfs(int node, int limit) {
		if (node == dest) return true;
		
		vis[node] = true;
		for (Node next : adj.get(node)) {
			if (next.cost < limit || vis[next.node]) continue;
			if (dfs(next.node, limit)) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
        	adj.add(new ArrayList<>());
        }
        vis = new boolean[n + 1];
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	adj.get(a).add(new Node(b, c));
        	adj.get(b).add(new Node(a, c));
        }
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        int s = 0, e = 1000000000, ans = -1;
        while (s <= e) {
        	int mid = (s + e) / 2;
        	Arrays.fill(vis, false);
        	
        	if (dfs(start, mid)) {
        		ans = mid;
        		s = mid + 1;
        	}
        	else e = mid - 1;
        }
        
        System.out.print(ans);
	}
}