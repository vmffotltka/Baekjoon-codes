import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int[] limit = { 1000, 1600, 1500, 30 };
        while (n-- > 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int flag = 0;
        	for (int i = 0; i < 4; i++) {
        		int p = Integer.parseInt(st.nextToken());
        		if ((i != 3 && p >= limit[i]) || (i == 3 && p != -1 && p <= limit[i])) 
        			flag++;
        	}
        	if (flag > 0) ans++;
        }
        System.out.print(ans);
    }
}