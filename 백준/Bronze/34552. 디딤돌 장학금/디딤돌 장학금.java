import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] m = new int[11];
        for (int i = 0; i < 11; i++) {
        	m[i] = Integer.parseInt(st.nextToken());
        }
        
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        while (n-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	int b = Integer.parseInt(st.nextToken());
        	double l = Double.parseDouble(st.nextToken());
        	int s = Integer.parseInt(st.nextToken());
        	
        	if (l >= 2 && s >= 17) ans += m[b];
        }
        System.out.print(ans);
    }
}