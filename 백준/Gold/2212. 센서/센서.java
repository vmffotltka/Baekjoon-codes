import java.io.*;
import java.util.*;

public class Main {
	private final static int INF = 987654321;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        int[] arr = new int[n];
        int mx = -INF, mn = INF;
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(input[i]);
        	mx = Math.max(mx, arr[i]);
        	mn = Math.min(mn, arr[i]);
        }
        Arrays.sort(arr);
        
        Integer[] gaps = new Integer[n - 1];
        for (int i = 1; i < n; i++) {
        	gaps[i - 1] = arr[i] - arr[i - 1];
        }
        Arrays.sort(gaps, Collections.reverseOrder());
        int ans = mx - mn;
        for (int i = 0; i < Math.min(k - 1, gaps.length); i++) {
        	ans -= gaps[i];
        }
        bw.write(String.valueOf(ans));
        bw.flush();
	}
}