import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> vis = new HashMap<>();
        vis.put(a, 0);
        int idx = 1;
        while (true) {
        	int next = 0;
        	while (a > 0) {
        		int cur = a % 10;
        		int tmp = 1;
        		for (int i = 0; i < p; i++) {
        			tmp *= cur;
        		}
        		next += tmp;
        		a /= 10;
        	}
        	if (vis.containsKey(next)) {
        		System.out.print(vis.get(next));
        		break;
        	}
        	vis.put(next, idx++);
        	a = next;
        }
    }
}