import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	long n = Long.parseLong(br.readLine());
        	long cur = Math.max(2, n);
        	while (true) {
        		boolean tri = true;
        		for (long i = 2; i * i <= cur; i++) {
        			if (cur % i == 0) { tri = false; break; }
        		}
        		if (tri) { bw.write(cur + "\n"); break; }
        		cur++;
        	}
        }
        bw.flush();
        bw.close(); br.close();
	}
}