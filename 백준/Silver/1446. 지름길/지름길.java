import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static class Road {
		int target, length;
		Road(int target, int length) {
			this.target = target;
			this.length = length;
		}
	}
	
	static int MAX = 10001;
	static int[] dp = new int[MAX * 2];
	static List<List<Road>> edges = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < MAX; i++) {
        	edges.add(new ArrayList<>());
        	dp[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	int len = Integer.parseInt(st.nextToken());
        	
        	edges.get(s).add(new Road(e, len));
        }
        
        for (int i = 0; i < MAX; i++) {
        	if (i > 0) dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
        	
        	for (Road next : edges.get(i)) {
        		dp[next.target] = Math.min(dp[next.target], dp[i] + next.length);
        	}
        }
        
        System.out.print(dp[d]);
	}
}