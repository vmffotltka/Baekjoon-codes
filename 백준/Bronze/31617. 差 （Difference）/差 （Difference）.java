import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
        	int p = Integer.parseInt(st.nextToken());
        	for (int j = 0; j < n; j++) {
        		if (arr[j] + k == p) ans++;
        	}
        }
        System.out.print(ans);
	}
}