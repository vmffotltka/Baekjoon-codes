import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
        	int n = Integer.parseInt(br.readLine());
        	if (n == 0) break;
        	
        	int[] vis = new int[50];
        	int cnt = 0;
        	for (int i = 0; i < n; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		
        		for (int j = 0; j < 6; j++) {
        			if (vis[Integer.parseInt(st.nextToken())]++ == 0)
        				cnt++;
        		}
        	}
        	sb.append(cnt == 49 ? "Yes\n" : "No\n");
        }
        System.out.print(sb.toString());
    }
}