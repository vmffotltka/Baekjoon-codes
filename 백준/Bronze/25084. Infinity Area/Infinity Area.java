import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
        	String[] input = br.readLine().split(" ");
        	long r = Long.parseLong(input[0]);
        	long a = Long.parseLong(input[1]);
        	long b = Long.parseLong(input[2]);
        	double ans = 0;
        	int flag = 0;
        	while (r > 0) {
        		ans += r * r * Math.PI;
        		if (flag == 0) r *= a;
        		else r /= b;
        		flag ^= 1;
        	}
        	bw.write("Case #" + i + ": " + ans + "\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}