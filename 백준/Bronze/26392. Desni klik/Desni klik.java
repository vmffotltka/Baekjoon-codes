import java.io.*;
import java.util.*;

public class Main {
	private static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int s = Integer.parseInt(input[2]);
        
        String[] arr = new String[r];
        while (t-- > 0) {
        	for (int i = 0; i < r; i++) {
        		arr[i] = br.readLine();
        	}
        	int mn = INF, mx = -INF; 
        	for (int i = r - 1; i >= 0; i--) {
        		for (int j = 0; j < s; j++) {
        			if (arr[i].charAt(j) == '#') {
        				mn = Math.min(mn, r - i);
        				mx = Math.max(mx, r - i);
        			}
        		}
        	}
        	bw.write(mx - mn + "\n");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}