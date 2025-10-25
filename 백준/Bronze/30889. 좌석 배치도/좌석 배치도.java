import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] seat = new int[10][20];
        for (int i = 0; i < n; i++) {
        	String s = br.readLine();
        	int sero = s.charAt(0) - 'A';
        	int garo = Integer.parseInt(s.substring(1)) - 1;
        	seat[sero][garo]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
        	for (int j = 0; j < 20; j++) {
        		sb.append(seat[i][j] == 0 ? '.' : 'o');
        	}
        	sb.append('\n');
        }
        System.out.print(sb);
    }
}