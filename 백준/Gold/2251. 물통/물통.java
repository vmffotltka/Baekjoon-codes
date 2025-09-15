import java.io.*;
import java.util.*;

public class Main {
    static class Node {
    	int a, b, c;
    	Node (int a, int b, int c) {
    		this.a = a;
    		this.b = b;
    		this.c = c;
    	}
    }
	static Set<Integer> set = new TreeSet<>();
	static int A, B, C;
	static boolean[][][] vis = new boolean[601][601][601];
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, C));
		vis[0][0][C] = true;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.a == 0)
				set.add(cur.c);
			
			Node next;
			if (cur.a < A && cur.b > 0) { // b -> a
				if (cur.a + cur.b > A)
					next = new Node(A, (cur.a + cur.b) - A, cur.c);
				else
					next = new Node(cur.a + cur.b, 0, cur.c);
				
				if (!vis[next.a][next.b][next.c]) {
					q.add(next);
					vis[next.a][next.b][next.c] = true; 
				}
			}
			if (cur.a < A && cur.c > 0) { // c -> a
				if (cur.a + cur.c > A)
					next = new Node(A, cur.b, (cur.a + cur.c) - A);
				else
					next = new Node(cur.a + cur.c, cur.b, 0);
				
				if (!vis[next.a][next.b][next.c]) {
					q.add(next);
					vis[next.a][next.b][next.c] = true; 
				}
			}
			if (cur.b < B && cur.a > 0) { // a -> b
				if (cur.a + cur.b > B)
					next = new Node((cur.a + cur.b) - B, B, cur.c);
				else
					next = new Node(0, cur.a + cur.b, cur.c);
				
				if (!vis[next.a][next.b][next.c]) {
					q.add(next);
					vis[next.a][next.b][next.c] = true; 
				}
			}
			if (cur.b < B && cur.c > 0) { // c -> b
				if (cur.b + cur.c > B)
					next = new Node(cur.a, B, (cur.b + cur.c) - B);
				else
					next = new Node(cur.a, cur.b + cur.c, 0);
				
				if (!vis[next.a][next.b][next.c]) {
					q.add(next);
					vis[next.a][next.b][next.c] = true; 
				}
			}
			if (cur.c < C && cur.a > 0) { // a -> c
				if (cur.a + cur.c > C)
					next = new Node((cur.a + cur.c) - C, cur.b, C);
				else
					next = new Node(0, cur.b, cur.a + cur.c);
				
				if (!vis[next.a][next.b][next.c]) {
					q.add(next);
					vis[next.a][next.b][next.c] = true; 
				}
			}
			if (cur.c < C && cur.b > 0) { // b -> c
				if (cur.b + cur.c > C)
					next = new Node(cur.a, (cur.b + cur.c) - C, C);
				else
					next = new Node(cur.a, 0, cur.b + cur.c);
				
				if (!vis[next.a][next.b][next.c]) {
					q.add(next);
					vis[next.a][next.b][next.c] = true; 
				}
			}
		}
	}
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i : set) sb.append(i).append(' ');
        
        System.out.print(sb.toString());
    }
}