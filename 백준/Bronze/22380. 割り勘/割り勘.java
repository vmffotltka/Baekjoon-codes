import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
        	String[] input = br.readLine().split(" ");
        	int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), ans = 0;
        	if (n == 0 && m == 0) break;
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < n; i++) {
        		int p = Integer.parseInt(st.nextToken());
        		ans += Math.min(m / n, p);
        	}
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close(); br.close();
	}
}