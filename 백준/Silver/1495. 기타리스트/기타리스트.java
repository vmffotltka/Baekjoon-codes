import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        
        q.add(s);
        int mx = -1;
        for (int i = 0; i < n; i++) {
        	int len = q.size();
        	int dif = Integer.parseInt(st.nextToken());
        	boolean[] vis = new boolean[1001];
        	
        	for (int j = 0; j < len; j++) {
        		int cur = q.poll();
        	
        		if (cur + dif <= m && !vis[cur + dif]) {
        			vis[cur + dif] = true;
        			if (i == n - 1) mx = Math.max(mx, cur + dif);
        			else q.add(cur + dif);
        		}
        		if (cur - dif >= 0 && !vis[cur - dif]) {
        			vis[cur - dif] = true;
        			if (i == n - 1) mx = Math.max(mx, cur - dif);
        			else q.add(cur - dif);
        		}
        	}
        }
        System.out.print(mx);
    }
}