import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static String[] arr;
    static boolean[][] vis;
    static int sero, garo;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };
    
    static class Node {
    	int y, x;
    	Node(int y, int x) {
    		this.y = y;
    		this.x = x;
    	}
    }
    
    static int bfs(int y, int x, char c) {
    	Queue<Node> q = new LinkedList<>();
    	q.add(new Node(y, x));
    	vis[y][x] = true;
    	
    	int ret = 1;
    	while (!q.isEmpty()) {
    		Node cur = q.poll();
    		for (int i = 0; i < 4; i++) {
    			int ny = cur.y + dy[i], nx = cur.x + dx[i];
    			if (0 <= ny && ny < sero && 0 <= nx && nx < garo && !vis[ny][nx] && arr[ny].charAt(nx) == c) {
    				vis[ny][nx] = true;
    				ret++;
    				q.add(new Node(ny, nx));
    			}
    		}
    	}
    	return ret * ret;
    }
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        garo = Integer.parseInt(st.nextToken());
        sero = Integer.parseInt(st.nextToken());
        
        arr = new String[sero];
        vis = new boolean[sero][garo];
        for (int i = 0; i < sero; i++) {
        	arr[i] = br.readLine();
        }
        
        int white = 0, blue = 0;
        for (int i = 0; i < sero; i++) {
        	for (int j = 0; j < garo; j++) {
        		if (vis[i][j]) continue;
        		if (arr[i].charAt(j) == 'W') white += bfs(i, j, 'W');
        		else blue += bfs(i, j, 'B');
        	}
        }
        System.out.print(white + " " + blue);
	}
}