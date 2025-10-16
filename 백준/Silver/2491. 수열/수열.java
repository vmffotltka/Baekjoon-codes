import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = -1, pre = arr[0], len = 1;
        for (int i = 1; i < n; i++) {
        	if (pre <= arr[i]) len++;
        	else {
        		ans = Math.max(ans, len);
        		len = 1;
        	}
        	pre = arr[i];
        }
        ans = Math.max(ans, len);
        pre = arr[0];
        len = 1;
        for (int i = 1; i < n; i++) {
        	if (pre >= arr[i]) len++;
        	else {
        		ans = Math.max(ans, len);
        		len = 1;
        	}
        	pre = arr[i];
        }
        ans = Math.max(ans, len);
        System.out.print(ans);
    }
}