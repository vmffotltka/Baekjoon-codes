import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static ArrayList<Long> tree = new ArrayList<>();
	static int tree_size;
	
	static void update(int idx, int val) {
		while (idx <= tree_size) {
			tree.set(idx, tree.get(idx) + val);
			idx += (idx & -idx);
		}
	}
	
	static long query(int idx) {
		long sum = 0;
		while (idx > 0) {
			sum += tree.get(idx);
			idx -= (idx & -idx);
		}
		return sum;
	}
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[n];
        Set<Integer> s = new TreeSet<>();
        for (int i = 0; i < n; i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        	s.add(A[i]);
        }
        List<Integer> coords = new ArrayList<>(s);
        
        tree_size = coords.size();
        tree = new ArrayList<>(Collections.nCopies(tree_size + 1, 0L));

        long ans = 0;
        for (int i = 0; i < n; i++) {
        	int start = 0, e = coords.size() - 1, compressed_idx = -1;
        	while (start <= e) {
        		int mid = (start + e) / 2;
        		if (coords.get(mid) <= A[i]) {
        			compressed_idx = mid + 1;
        			start = mid + 1;
        		}
        		else e = mid - 1;
        	}
        	
        	long smaller_or_equal_count = query(compressed_idx);
        	ans += (long)i - smaller_or_equal_count;
        	
        	update(compressed_idx, 1);
        }
        
        System.out.print(ans);
    }
}