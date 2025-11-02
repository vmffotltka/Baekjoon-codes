import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int S = Integer.parseInt(st.nextToken());
        	int n = Integer.parseInt(st.nextToken());
        	int f = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	
        	if (n <= (S - m) && (S - m) <= n * f)
        		sb.append("YES\n");
        	else
        		sb.append("NO\n");
        }
        System.out.print(sb);
    }
}