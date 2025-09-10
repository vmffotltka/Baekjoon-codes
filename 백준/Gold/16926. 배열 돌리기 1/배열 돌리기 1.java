import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m], ans = new int[n][m];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < m; j++)
        		arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < Math.min(n, m) / 2; i++) {
        	List<Integer> arrays = new ArrayList<>();
        	int sero = i, garo = i;
        	while (true) {
        		if (!arrays.isEmpty() && sero == i && garo == i) break;
        		
    			arrays.add(arr[sero][garo]);
        		if (sero == i && garo != m - i - 1) garo++;
        		else if (sero != n - i - 1 && garo == m - i - 1) sero++;
        		else if (sero == n - i - 1 && garo != i) garo--;
        		else sero--;
        	}
        	
        	int len = arrays.size();
        	int[] tmp = new int[len];
        	
        	for (int j = 0; j < len; j++)
        		tmp[j] = arrays.get((j + r) % len);
        	
        	sero = i; garo = i;
        	for (int j = 0; j < len; j++) {
        		ans[sero][garo] = tmp[j];
        		if (sero == i && garo != m - i - 1) garo++;
        		else if (sero != n - i - 1 && garo == m - i - 1) sero++;
        		else if (sero == n - i - 1 && garo != i) garo--;
        		else sero--;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		sb.append(ans[i][j]).append(' ');
        	}
        	sb.append('\n');
        }
        System.out.print(sb.toString().strip());
    }
}