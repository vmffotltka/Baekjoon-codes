import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
        	String s = br.readLine();
        	for (int j = 0; j < m; j++) {
        		if (s.charAt(j) == 'O') arr[i][j]++;
        	}
        }
        for (int j = 0; j < m; j++) {
        	int cnt = 0;
        	for (int i = 0; i < n; i++) {
        		if (arr[i][j] == 1) cnt++;
        	}
        	if (cnt == 0) {
        		System.out.print(j + 1);
        		return;
        	}
        }
        System.out.print("ESCAPE FAILED");
    }
}