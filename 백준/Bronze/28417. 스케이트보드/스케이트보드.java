import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	String[] input = br.readLine().split(" ");
        	int mx1 = 0, mx2 = 0;
        	for (int j = 2; j < 7; j++) {
        		int p = Integer.parseInt(input[j]);
        		if (p >= mx1) {
        			mx2 = mx1;
        			mx1 = p;
        		}
        		else if (p >= mx2) {
        			mx2 = p;
        		}
        	}
        	
        	ans = Math.max(ans, Math.max(
        			Integer.parseInt(input[0]),
        			Integer.parseInt(input[1])) + mx1 + mx2);
        }
        bw.write(ans + "");
        bw.flush();
    }
}