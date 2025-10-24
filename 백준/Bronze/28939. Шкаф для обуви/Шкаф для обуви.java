import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int h = Integer.parseInt(st.nextToken());
        	int shoes = Integer.parseInt(st.nextToken());
        	for (int j = 0; j < shoes; j++) {
        		int size = Integer.parseInt(st.nextToken());
        		if ((h * k) < (size * m2) || (size * m1) < h)
        			ans++;
        	}
        }
        System.out.print(ans);
    }
}