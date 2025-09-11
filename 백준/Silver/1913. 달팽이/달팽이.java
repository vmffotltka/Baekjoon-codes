import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][n];
        int len = 1, dir = 0, cur = 1;
        
        int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };
        
        int y = n / 2, x = n / 2, ansY = 0, ansX = 0, cnt = 0;
        while (true) {
        	if (y < 0 || x < 0 || y >= n || x >= n) break;
        	arr[y][x] = cur;
        	if (cur++ == num) {
        		ansY = y + 1;
        		ansX = x + 1;
        	}
        	
        	y = y + dy[dir];
        	x = x + dx[dir];
        	
        	if (++cnt == len) {
        		cnt = 0;

            	dir = (dir + 1) % 4;
            	if (dir % 2 == 0) len++;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		sb.append(arr[i][j]).append(' ');
        	}
        	sb.append('\n');
        }
        sb.append(ansY).append(' ').append(ansX);
        
        System.out.print(sb.toString());
    }
}