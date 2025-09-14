import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int cur = 0, time = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(st.nextToken());
        	
        	cur += p;
        	if (cur > m) {
        		cur = p;
        		time++;
        	}
        	sb.append(time).append('\n');
        }
        System.out.print(sb.toString());
    }
}