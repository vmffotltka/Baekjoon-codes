import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	if (i < x) sum += arr[i];
        }
        
        int mx = -1, cnt = 0;
        for (int i = x; i < n; i++) {
        	if (mx < sum) {
        		mx = sum;
        		cnt = 1;
        	}
        	else if (mx == sum)
        		cnt++;
        	sum += arr[i] - arr[i - x];
        }
        if (mx < sum) {
        	mx = sum;
        	cnt = 1;
        }
        else if (mx == sum)
        	cnt++;
        
        System.out.print(mx == 0 ? "SAD" : mx + "\n" + cnt);
    }
}