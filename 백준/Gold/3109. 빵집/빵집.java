import java.io.*;
import java.util.*;

public class Main {
	
	static int dy[] = { -1, 0, 1 };
	static int N, M;
	static String[] arr = new String[10000];
	static boolean[][] vis = new boolean[10000][500];
	static boolean[][] cant = new boolean[10000][500];
	
	static boolean dfs(int y, int x) {
		if (x == M - 1) {
			vis[y][x] = true;
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i], nx = x + 1;
			if (0 <= ny && ny < N && nx < M && arr[ny].charAt(nx) != 'x' && !vis[ny][nx] && !cant[ny][nx]) {
				if (dfs(ny, nx)) {
					vis[y][x] = true;
					return true;
				}
				else cant[y][x] = true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        for (int i = 0; i < N; i++) {
        	arr[i] = br.readLine();
        }
        
        int ans = 0;
        for (int i = 0; i < N; i++) {
        	if (!dfs(i, 0)) continue;
        	ans++;
        }
        System.out.print(ans);
	}
}