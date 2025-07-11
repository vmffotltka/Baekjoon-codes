import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int dist = Integer.parseInt(input[1]);
        int ans = 0;
        double mn = 987654321;
        for (int i = 1; i <= n; i++) {
        	input = br.readLine().split(" ");
        	double x = Double.parseDouble(input[0]);
        	double v = Double.parseDouble(input[1]);
        	double sec = (dist - x) / v;
        	if (mn > sec) {
        		mn = sec;
        		ans = i;
        	}
        }
        bw.write(ans + "");
        bw.flush();
    }
}