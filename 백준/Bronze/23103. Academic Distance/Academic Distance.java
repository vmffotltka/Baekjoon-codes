import java.io.*;
import java.util.*;

public class Main {
	static final double INF = 987654321;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine()), ans = 0;
        int preX= -1, preY = -1;
        for (int i = 0; i < t; i++) {
        	String[] input = br.readLine().split(" ");
        	int x = Integer.parseInt(input[0]), y = Integer.parseInt(input[1]);
        	if (i == 0) {
        		preX = x; preY = y;
        		continue;
        	}
        	ans += Math.abs(preX - x) + Math.abs(preY - y);
        	preX = x; preY = y;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
	}
}