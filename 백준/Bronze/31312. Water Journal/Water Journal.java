import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int[] vis = new int[b + 1];
        for (int i = 0; i < n - 1; i++) {
        	int p = Integer.parseInt(br.readLine());
        	vis[p]++;
        }
        if (vis[a] == 0 && vis[b] == 0) {
        	System.out.print(-1);
        }
        else if (vis[a] == 0) {
        	System.out.print(a);
        }
        else if (vis[b] == 0) {
        	System.out.print(b);
        }
        else {
        	StringBuilder sb = new StringBuilder();
        	for (int i = a; i <= b; i++) {
        		sb.append(i).append('\n');
        	}
        	System.out.print(sb);
        }
    }
}