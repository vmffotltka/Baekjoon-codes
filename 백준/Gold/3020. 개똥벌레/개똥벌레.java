import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        Integer[] a = new Integer[n / 2], b = new Integer[n / 2];
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(br.readLine());
        	if (i % 2 == 0) a[i / 2] = p;
        	else b[i / 2] = p;
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        int mn = Integer.MAX_VALUE, cnt = 0;
        for (int i = 1; i <= h; i++) {
        	int s = 0, e = n / 2 - 1, idx = -1, count = 0;
        	while (s <= e) {
        		int mid = (s + e) / 2;
        		if (a[mid] < i) {
        			idx = mid;
        			s = mid + 1;
        		}
        		else e = mid - 1;
        	}
        	count += n / 2 - idx - 1;
        	
        	s = 0; e = n / 2 - 1; idx = -1;
        	while (s <= e) {
        		int mid = (s + e) / 2;
        		if (b[mid] < h - i + 1) {
        			idx = mid;
        			s = mid + 1;
        		}
        		else e = mid - 1;
        	}
        	count += n / 2 - idx - 1;
        	
        	if (count < mn) {
        		mn = count;
        		cnt = 1;
        	}
        	else if (count == mn) {
        		cnt++;
        	}
        }
        
        System.out.print(mn + " " + cnt);
	}
}