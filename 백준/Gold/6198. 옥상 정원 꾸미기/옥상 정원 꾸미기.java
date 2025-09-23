import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static class Node {
		int n, cnt;
		Node(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        Stack<Node> st = new Stack<>();
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
        	int cur = Integer.parseInt(br.readLine());
        	
        	int popCount = 0;
        	while (!st.isEmpty() && st.peek().n <= cur) {
        		popCount = st.peek().cnt + 1;
        		ans += st.peek().cnt;
        		st.pop();
        		
        		if (!st.isEmpty()) st.peek().cnt += popCount;
        	}
        	
        	st.push(new Node(cur, 0));
        }
        
        int popCount = 0;
        while (!st.isEmpty()) {
        	popCount = st.peek().cnt + 1;
        	ans += st.peek().cnt;
        	st.pop();

    		if (!st.isEmpty()) st.peek().cnt += popCount;
        }
        System.out.print(ans);
	}
}