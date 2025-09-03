import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
        	String[] input = br.readLine().split(" ");
        	int n = Integer.parseInt(input[0]);
        	int m = Integer.parseInt(input[1]);
        	
        	int[] A = new int[n];
        	int[] B = new int[m];
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < n; i++) {
        		A[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < m; i++) {
        		B[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	Arrays.sort(B);
        	
        	int ans = 0;
        	for (int i = 0; i < n; i++) {
        		int l = 0, r = m - 1, pos = -1;
        		while (l <= r) {
        			int mid = (l + r) / 2;
        			if (A[i] > B[mid]) {
        				pos = mid;
        				l = mid + 1;
        			}
        			else {
        				r = mid - 1;
        			}
        		}
        		ans += pos + 1;
        	}
        	sb.append(String.format("%d\n", ans));
        }
        System.out.print(sb.toString().strip());
    }
}