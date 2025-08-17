import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("-");
        int y = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int d = Integer.parseInt(input[2]);
        int days = (y - 1) * 360 + (m - 1) * 30 + d - 1;
        
        int day = Integer.parseInt(br.readLine());
        
        int next = days + day;
        bw.write(String.format("%d-%02d-%02d", next / 360 + 1, (next % 360) / 30 + 1, next % 30 + 1));
        
        bw.flush();
    }
}