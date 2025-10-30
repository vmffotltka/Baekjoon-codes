import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cost = new int[n];
        int jinjuCost = 0;
        
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String d = st.nextToken();
        	int c = Integer.parseInt(st.nextToken());
        	
        	if (d.equals("jinju")) {
        		cost[i] = -1;
        		jinjuCost = c;
        	}
        	else cost[i] = c;
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
        	if (cost[i] > jinjuCost) cnt++;
        }
        System.out.printf("%d\n%d", jinjuCost, cnt);
    }
}