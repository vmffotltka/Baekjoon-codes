import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static int N;
    static ArrayList<int[]> arr = new ArrayList<>();
    
    static void dfs(int num, int idx, int target) {
    	if (num == 1) {
    		arr.add(new int[]{ idx + 1, target + 1 });
    		return;
    	}
    	int next = (idx + target == 1 ? 2 : (idx + target == 2 ? 1 : 0));
    	
    	dfs(num - 1, idx, next);
    	arr.add(new int[]{ idx + 1, target + 1 });
    	dfs(num - 1, next, target);
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if (N <= 20) {
            dfs(N, 0, 2);
            
            StringBuilder sb = new StringBuilder();
            sb.append(arr.size()).append('\n');
            for (int[] a : arr) {
            	sb.append(a[0]).append(' ').append(a[1]).append('\n');
            }
            System.out.print(sb.toString());
        }
        else {
        	BigInteger ans = BigInteger.ZERO;
        	for (int i = 0; i < N; i++) {
        		ans = ans.multiply(BigInteger.TWO).add(BigInteger.ONE);
        	}
        	System.out.print(ans);
        }
    }
}