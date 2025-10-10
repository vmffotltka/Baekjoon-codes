import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        int[] obs = new int[n];
        for (int i = 0; i < y; i++) {
        	obs[Integer.parseInt(br.readLine())]++;
        }
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
        	if (obs[i] == 0)
        		sb.append(i).append('\n');
        	else
        		cnt++;
        }
        sb.append("Mario got ").append(cnt).append(" of the dangerous obstacles.");
        System.out.print(sb.toString());
	}
}