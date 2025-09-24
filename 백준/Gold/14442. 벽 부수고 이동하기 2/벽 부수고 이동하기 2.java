import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static int N, M, K;
	static String[] arr;
	static int[][][] Dist;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	
	static class Coor {
		int y, x, k;
		Coor(int y, int x, int k) {
			this.y = y;
			this.x = x;
			this.k = k;
		}
	}
	
	static int bfs() {
		Queue<Coor> q = new LinkedList<>();
		q.add(new Coor(0, 0, 0));
		Dist[0][0][0] = 1;
		
		int dist = 2;
		while (!q.isEmpty()) {
			int len = q.size();
			while (len-- > 0) {
				Coor c = q.poll();
				for (int i = 0; i < 4; i++) {
					int ny = c.y + dy[i], nx = c.x + dx[i];
					if (0 <= ny && ny < N && 0 <= nx && nx < M) {
						if (arr[ny].charAt(nx) == '0' && Dist[ny][nx][c.k] == 0) {
							Dist[ny][nx][c.k] = dist; 
							q.add(new Coor(ny, nx, c.k));
						}
						else if (arr[ny].charAt(nx) == '1' && c.k < K && Dist[ny][nx][c.k + 1] == 0) {
							Dist[ny][nx][c.k + 1] = dist;
							q.add(new Coor(ny, nx, c.k + 1));
						}
					}
				}
			}
			dist++;
		}

		int ret = Integer.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			if (Dist[N - 1][M - 1][i] != 0)
				ret = Math.min(ret, Dist[N - 1][M - 1][i]);
		}
		
		return ret == Integer.MAX_VALUE ? -1 : ret;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new String[N];
        Dist = new int[N][M][K + 1];
        
        for (int i = 0; i < N; i++)
        	arr[i] = br.readLine();
        
        System.out.print(bfs());
	}
}