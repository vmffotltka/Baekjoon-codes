import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] A;
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	
	static class Coor {
		int y, x;
		Coor(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static Queue<Coor> move(Queue<Coor> q, int d, int s) {
		Queue<Coor> ret = new LinkedList<>();
		for (Coor c : q) {
			ret.add(new Coor((c.y + N * 50 + dy[d] * s) % N, (c.x + N * 50 + dx[d] * s) % N));
		}
		return ret;
	}
	
	static void rainDrop(Queue<Coor> q) {
		for (Coor c : q) {
			A[c.y][c.x]++;
		}
		for (Coor c : q) {
			for (int i = 1; i < 8; i += 2) {
				int ny = c.y + dy[i], nx = c.x + dx[i];
				if (0 <= ny && ny < N && 0 <= nx && nx < N && A[ny][nx] > 0)
					A[c.y][c.x]++;
			}
		}
	}
	
	static Queue<Coor> copyBug(Queue<Coor> q) {
		Queue<Coor> ret = new LinkedList<>();
		boolean[][] vis = new boolean[N][N];
		for (Coor c : q) {
			vis[c.y][c.x] = true; 
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!vis[i][j] && A[i][j] >= 2) {
					ret.add(new Coor(i, j));
					A[i][j] -= 2;
				}
			}
		}
		
		return ret;
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		A[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        Queue<Coor> clouds = new LinkedList<>();
        clouds.add(new Coor(N - 1, 0));
        clouds.add(new Coor(N - 1, 1));
        clouds.add(new Coor(N - 2, 0));
        clouds.add(new Coor(N - 2, 1));
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int d = Integer.parseInt(st.nextToken()) - 1;
        	int s = Integer.parseInt(st.nextToken());
        	
        	clouds = move(clouds, d, s);
        	rainDrop(clouds);
        	clouds = copyBug(clouds);
        }
        
        int sum = 0;
        for (int i = 0; i < N; i++)
        	for (int j = 0; j < N; j++)
        		sum += A[i][j];
        System.out.print(sum);
    }
}