import java.io.*;
import java.util.*;

public class Main {
	static final double INF = 987654321;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while (true) {
        	String[] input = br.readLine().split(" ");
        	int d = Integer.parseInt(input[0]), e = Integer.parseInt(input[1]);
        	if (d + e == 0) break;
        	double dist = INF;
        	for (int x = 0; x <= d; x++) {
        		int y = d - x;
        		dist = Math.min(dist, Math.abs(Math.sqrt(x * x + y * y) - e));
        	}
        	bw.write(dist + "\n");
        }
        
        bw.flush();
        bw.close(); br.close();
	}
}