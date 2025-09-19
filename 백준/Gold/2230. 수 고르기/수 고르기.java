import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        int s = 0, e = 0, mn = Integer.MAX_VALUE;
        while (e < n) {
        	if (arr[e] - arr[s] < m) e++;
        	else {
        		mn = Math.min(mn, arr[e] - arr[s]);
        		s++;
        		e = Math.max(e, s);
        	}
        }
        System.out.print(mn);
	}
}