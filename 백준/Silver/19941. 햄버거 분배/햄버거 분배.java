import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        boolean[] selected = new boolean[n];
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	if (s.charAt(i) == 'P') {
        		for (int j = Math.max(0, i - k); j < Math.min(n, i + k + 1); j++) {
        			if (s.charAt(j) == 'H' && !selected[j]) {
        				selected[j] = true;
        				ans++;
        				break;
        			}
        		}
        	}
        }
        System.out.print(ans);
	}
}