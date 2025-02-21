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
        	int m = Integer.parseInt(st.nextToken());

        	st = new StringTokenizer(br.readLine());
        	
        	st = new StringTokenizer(br.readLine());
        	bw.write(n > m ? "No\n" : "Yes\n");
        }
        bw.flush();
        bw.close(); br.close();
	}
}
