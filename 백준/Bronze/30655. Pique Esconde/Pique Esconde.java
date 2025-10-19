import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	if (n == 0 && m == 0) break;
        	
        	boolean[] vis = new boolean[n + 1];
        	vis[m] = true;
        	for (int i = 0; i < n - 2; i++) {
        		vis[Integer.parseInt(br.readLine())] = true;
        	}
        	for (int i = 1; i <= n; i++) {
        		if (!vis[i]) {
        			sb.append(i).append('\n');
        			break;
        		}
        	}
        }
        System.out.print(sb);
    }
}