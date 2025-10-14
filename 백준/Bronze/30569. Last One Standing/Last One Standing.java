import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int t1 = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int h2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());
        
        int one = (int)Math.ceil((double)(h2 - d1) / d1) * t1;
        int two = (int)Math.ceil((double)(h1 - d2) / d2) * t2;
        
        System.out.print(one == two ? "draw" : "player " + (one < two ? "one" : "two"));
	}
}