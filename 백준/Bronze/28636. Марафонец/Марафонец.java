import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	String[] input = br.readLine().split(":");
        	int time = Integer.parseInt(input[0]) * 60
        			+ Integer.parseInt(input[1]);
        	ans += time;
        }
        bw.write(String.format("%02d:%02d:%02d", ans / 3600, ans % 3600 / 60, ans % 60));
        bw.flush();
    }
}