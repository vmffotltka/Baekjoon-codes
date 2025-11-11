import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int mn = Integer.parseInt(st.nextToken()), pre = mn, ans = 0;
        for (int i = 1; i < n; i++) {
        	int cur = Integer.parseInt(st.nextToken());
        	if (pre >= cur) {
        		ans = Math.max(ans, pre - mn);
        		mn = cur;
        	}
        	pre = cur;
        }
        ans = Math.max(ans, pre - mn);
        System.out.print(ans);
    }
}