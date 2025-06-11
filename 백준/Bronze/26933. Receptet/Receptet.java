import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()), ans = 0;
        while (t-- > 0) {
        	String[] input = br.readLine().split(" ");
        	int h = Integer.parseInt(input[0]);
        	int b = Integer.parseInt(input[1]);
        	int k = Integer.parseInt(input[2]);
        	
        	ans += Math.max(0, b - h) * k;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}