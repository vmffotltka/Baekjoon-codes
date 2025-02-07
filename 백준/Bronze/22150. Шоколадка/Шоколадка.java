import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
            boolean eaten = false;
        	for (int i = 0; i < n; i++) {
        		int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        		if (l + r != n) eaten = true;
        	}
            bw.write(eaten ? "yes\n" : "no\n");
        }
        bw.flush();
        bw.close(); br.close();
	}
}