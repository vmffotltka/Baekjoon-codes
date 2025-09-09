import java.io.*;
import java.util.*;

public class Main {
	
	static String S;
	static int N;
	
	static long dfs(int idx, long cal) {
		if (idx > N - 1) return cal;
		
		long ret = Long.MIN_VALUE;
		long way1 = cal;
		char op = (idx == 0 ? '+' : S.charAt(idx - 1));
		if (op == '+') way1 += S.charAt(idx) - '0';
		else if (op == '-') way1 -= S.charAt(idx) - '0';
		else if (op == '*') way1 *= S.charAt(idx) - '0';

		ret = Math.max(ret, dfs(idx + 2, way1));
		
		int gwaro = 0;
		if (idx <= N - 3) {
			int a = S.charAt(idx) - '0';
			int b = S.charAt(idx + 2) - '0';
			
			if (S.charAt(idx + 1) == '+') gwaro = a + b;
			else if (S.charAt(idx + 1) == '-') gwaro = a - b;
			else if (S.charAt(idx + 1) == '*') gwaro = a * b;
			
			long way2 = cal;
			if (op == '+') way2 += gwaro;
			else if (op == '-') way2 -= gwaro;
			else if (op == '*') way2 *= gwaro;
			
			ret = Math.max(ret, dfs(idx + 4, way2));
		}
		
		return ret;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = br.readLine();

        System.out.print(dfs(0, 0));
    }
}