import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        
        for (int c = 1; c <= t; c++) {
        	String[] input = br.readLine().split(" ");
        	int m = Integer.parseInt(input[0]);
        	int n = Integer.parseInt(input[1]);
        	int p = Integer.parseInt(input[2]);
        	
        	String[][] arr = new String[m][n];
        	for (int i = 0; i < m; i++) {
        		String[] tmp = br.readLine().split(" ");
        		arr[i] = tmp;
        	}
        	int ans = 0;
        	for (int j = 0; j < n; j++) {
        		int mx = 0;
        		for (int i = 0; i < m; i++) {
        			mx = Math.max(mx, Integer.parseInt(arr[i][j]));
        		}
        		ans += mx - Integer.parseInt(arr[p - 1][j]);
        	}
        	bw.write("Case #" + c + ": " + ans + "\n");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}