import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	st.nextToken();
        	
        	int y = Integer.parseInt(st.nextToken());
        	mx = Math.max(mx, y);
        	mn = Math.min(mn, y);
        }
        System.out.print(mx - mn);
    }
}