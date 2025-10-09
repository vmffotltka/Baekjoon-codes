import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
        	int d, m, y;
        	String s = br.readLine();
        	StringTokenizer st;
        	if (s.contains(".")) {
            	st = new StringTokenizer(s, ".");
            	d = Integer.parseInt(st.nextToken());
            	m = Integer.parseInt(st.nextToken());
        	}
        	else {
            	st = new StringTokenizer(s, "/");
            	m = Integer.parseInt(st.nextToken());
            	d = Integer.parseInt(st.nextToken());
        	}
        	y = Integer.parseInt(st.nextToken());
        	
        	System.out.print(String.format("%02d.%02d.%04d %02d/%02d/%04d\n", d, m, y, m, d, y));
        }
    }
}