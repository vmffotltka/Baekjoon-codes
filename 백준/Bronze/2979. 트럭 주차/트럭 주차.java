import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] time = new int[101];
        for (int i = 0; i < 3; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	for (int j = start; j < end; j++)
        		time[j]++;
        }
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
        	if (time[i] == 1) ans += a;
        	else if (time[i] == 2) ans += b * 2;
        	else if (time[i] == 3) ans += c * 3;
        }
        System.out.print(ans);
	}
}