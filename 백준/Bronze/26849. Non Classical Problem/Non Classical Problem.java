import java.io.*;
import java.util.*;

public class Main {
	static double INF = 1e10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double mn = INF, mx = -INF, sm = 0;
        for (int i = 0; i < n; i++) {
        	String[] input = br.readLine().split(" ");
        	double a = Double.parseDouble(input[0]);
        	double b = Double.parseDouble(input[1]);
        	mn = Math.min(mn, a / b);
        	mx = Math.max(mx, a / b);
        	sm += a / b;
        }
        bw.write(mn + " " + mx + " " + sm);
        bw.flush();
        bw.close(); br.close();
    }
}