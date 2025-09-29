import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static int N, M, K, ans = Integer.MAX_VALUE;
	static int[] R, C, S;
	static boolean[] vis;
	
	static int[][] spin(int r, int c, int s, int[][] A) {
		for (int sero = r - s, garo = c - s; sero < r && garo < c; sero++, garo++, s--) {
			int se = sero, ga = garo;
			List<Integer> li = new ArrayList<Integer>();
			
			while (true) {
				li.add(A[se][ga]);
				if (se == sero && ga != garo + 2 * s) ga++;
				else if (se != sero + 2 * s && ga == garo + 2 * s) se++;
				else if (se == sero + 2 * s && ga != garo) ga--;
				else se--;
				
				if (se == sero && ga == garo) break;
			}
			
			for (int i = 0; i < li.size(); i++) {
				A[se][ga] = li.get((i + li.size() - 1) % li.size());
				if (se == sero && ga != garo + 2 * s) ga++;
				else if (se != sero + 2 * s && ga == garo + 2 * s) se++;
				else if (se == sero + 2 * s && ga != garo) ga--;
				else se--;
			}
		}
		return A;
	}
	
	static void dfs(int depth, int[][] arr) {
		if (depth == K) {
			int mn = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += arr[i][j];
				}
				mn = Math.min(mn, sum);
			}
			ans = Math.min(ans, mn);
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (vis[i]) continue;
			vis[i] = true;

			int[][] clone = new int[N][M];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					clone[j][k] = arr[j][k];
				}
			}
			
			dfs(depth + 1, spin(R[i], C[i], S[i], clone));
			vis[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        vis = new boolean[K];
        R = new int[K];
        C = new int[K];
        S = new int[K];
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		A[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        for (int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	R[i] = Integer.parseInt(st.nextToken()) - 1;
        	C[i] = Integer.parseInt(st.nextToken()) - 1;
        	S[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, A);
        System.out.print(ans);
	}
}