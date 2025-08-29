import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] likes = new int[n * n + 1][4];
        int[] dy = { 0, 0, 1, -1 };
        int[] dx = { 1, -1, 0, 0 };
        
        for (int t = 0; t < n * n; t++) {
        	String[] input = br.readLine().split(" ");
        	int cur = Integer.parseInt(input[0]);
        	for (int k = 1; k < 5; k++) {
        		likes[cur][k - 1] = Integer.parseInt(input[k]);
        	}
        	
        	int like = -1, empty = -1, sero = 0, garo = 0;
        	for (int y = 0; y < n; y++) {
        		for (int x = 0; x < n; x++) {
        			if (arr[y][x] != 0) continue;
        			
        			int l = 0, e = 0;
        			for (int i = 0; i < 4; i++) {
        				int ny = y + dy[i], nx = x + dx[i];
        				if (0 <= ny && ny < n && 0 <= nx && nx < n) {
        					if (arr[ny][nx] == 0) e++;
        					else {
        						for (int j = 1; j < 5; j++) {
        							int num = Integer.parseInt(input[j]);
        							if (num == arr[ny][nx]) l++;
        						}
        					}
        				}
        			}
        			
        			if (like < l) {
        				like = l;
        				empty = e;
        				sero = y;
        				garo = x;
        			}
        			else if (like == l && empty < e) {
        				empty = e;
        				sero = y;
        				garo = x;
        			}
        		}
        	}
        	arr[sero][garo] = cur;
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		int cnt = 0;
        		for (int k = 0; k < 4; k++) {
            		int ny = i + dy[k], nx = j + dx[k];
            		if (0 <= ny && ny < n && 0 <= nx && nx < n) {
            			for (int l = 0; l < 4; l++) {
            				if (likes[arr[i][j]][l] == arr[ny][nx]) cnt++;
            			}
            		}
        		}
        		if (cnt == 1) ans++;
        		else if (cnt == 2) ans += 10;
        		else if (cnt == 3) ans += 100;
        		else if (cnt == 4) ans += 1000;
        	}
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}