import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int preL = 0, preR = 0, ans = 0;
        while (n-- > 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int l = Integer.parseInt(st.nextToken());
        	int r = Integer.parseInt(st.nextToken());
        	
        	if (preL != 0 && preL == l) ans++;
        	if (preR != 0 && preR == r) ans++;
        	if (l != 0 && l == r) ans++;
        	
        	preL = l;
        	preR = r;
        }
        System.out.print(ans);
	}
}