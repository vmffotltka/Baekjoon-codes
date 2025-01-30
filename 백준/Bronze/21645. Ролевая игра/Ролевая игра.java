import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a = 0, b = 0;
        for (int i = 1; i <= m; i++) {
        	a = Math.max(a, i / k);
        	b = Math.max(b, i % k);
        }
        bw.write(n * (a + b) + "");
        bw.flush();
        bw.close(); br.close();
	}
}