import java.io.*;
import java.util.*;

public class Main {
	static int height, sero, garo;
	
	static class Node {
		public int i, j, k;
		public Node(int i, int j, int k) {
			this.i = i;
			this.j = j;
			this.k = k;
		}
	}
	
	static int bfs(String[][] arr, boolean[][][] visited, int i, int j, int k) {
		int ret = 1;
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(i, j, k));
		visited[i][j][k] = true;
		
		int[] dz = { 0, 0, 0, 0, 1, -1 };
		int[] dy = { 0, 0, 1, -1, 0, 0 };
		int[] dx = { 1, -1, 0, 0, 0, 0 };
		
		while (!q.isEmpty()) {
			int len = q.size();
			for (int t = 0; t < len; t++) {
				Node cur = q.poll();
				int z = cur.i, y = cur.j, x = cur.k;
				for (int idx = 0; idx < 6; idx++) {
					int nz = z + dz[idx], ny = y + dy[idx], nx = x + dx[idx];
					if (0 <= nz && nz < height && 0 <= ny && ny < sero && 0 <= nx && nx < garo) {
						if (arr[nz][ny].charAt(nx) == '#' || visited[nz][ny][nx]) continue;
						if (arr[nz][ny].charAt(nx) == 'E') return ret;
						visited[nz][ny][nx] = true;
						q.add(new Node(nz, ny, nx));
					}
				}
			}
			ret++;
		}
		return -1;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while (true) {
        	String[] input = br.readLine().split(" ");
        	height = Integer.parseInt(input[0]);
        	sero = Integer.parseInt(input[1]);
        	garo = Integer.parseInt(input[2]);
        	
        	if (height == 0 && sero == 0 && garo == 0) break;
        	
        	String[][] arr = new String[height][sero];
        	int startH = 0, startS = 0, startG = 0;
        	for (int i = 0; i < height; i++) {
        		for (int j = 0; j < sero; j++) {
        			arr[i][j] = br.readLine();
        			for (int k = 0; k < garo; k++) {
        				if (arr[i][j].charAt(k) == 'S') {
        					startH = i;
        					startS = j;
        					startG = k;
        				}
        			}
        		}
        		br.readLine();
        	}
        	
        	boolean[][][] visited = new boolean[height][sero][garo];
        	
        	int dist = bfs(arr, visited, startH, startS, startG);
        	if (dist == -1) bw.write("Trapped!\n");
        	else bw.write(String.format("Escaped in %d minute(s).\n", dist));
        }
        
        bw.flush();
    }
}