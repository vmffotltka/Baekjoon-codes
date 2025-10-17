import java.io.*;
import java.util.*;

public class Main {

	static int MAX = 10000;
	static boolean[] isPrime = new boolean[MAX];
	static List<List<Integer>> adj = new ArrayList<>();
	
	static int bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		int dist = 0;
		boolean[] vis = new boolean[MAX];
		vis[start] = true;
		
		while (!q.isEmpty()) {
			int len = q.size();
			dist++;
			for (int t = 0; t < len; t++) { 
				int cur = q.poll();
				for (int next : adj.get(cur)) {
					if (next == end) return dist;
					if (vis[next]) continue;
					vis[next] = true;
					q.add(next);
				}
			}
		}
		return -1;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(isPrime, true);
        for (int i = 2; i < MAX; i++) {
        	if (!isPrime[i]) continue;
        	for (int j = i * 2; j < MAX; j += i)
        		isPrime[j] = false;
        }
        
        for (int i = 0; i < MAX; i++) {
        	adj.add(new ArrayList<>());
        }
        
        for (int i = 1000; i < MAX; i++) {
        	if (!isPrime[i]) continue;
        	
        	int pw = 10, next = i;
        	for (int j = 0; j < 4; j++) {
        		int cur = (i % pw) / (pw / 10);
        		
        		next -= cur * (pw / 10);
        		for (int k = 0; k < 10; k++) {
        			if (k == cur) continue;
        			int nextNum = next + k * (pw / 10);
        			if (!isPrime[nextNum] || nextNum < 1000 || nextNum > 10000) continue;
        			
        			adj.get(i).add(nextNum);
        		}
        		next += cur * (pw / 10);
        		pw *= 10;
        	}
        }
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	if (start == end) sb.append("0\n");
        	else {
        		int dist = bfs(start, end);
        		sb.append(dist == -1 ? "Impossible" : dist).append('\n');
        	}
        }
        System.out.print(sb.toString());
    }
}