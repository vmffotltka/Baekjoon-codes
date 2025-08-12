import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int h1 = Integer.parseInt(input[0]);
        int m1 = Integer.parseInt(input[1]);
        int s1 = Integer.parseInt(input[2]);
        
        input = br.readLine().split(" ");
        int h2 = Integer.parseInt(input[0]);
        int m2 = Integer.parseInt(input[1]);
        int s2 = Integer.parseInt(input[2]);
        
        input = br.readLine().split(" ");
        int hour = Integer.parseInt(input[0]);
        int minute = Integer.parseInt(input[1]);
        int second = Integer.parseInt(input[2]);
        
        int seconds = hour * m1 * s1 + minute * s1 + second;
        int daySeconds = h2 * m2 * s2;
        
        seconds %= daySeconds;
        bw.write(String.format("%d %d %d",
        		seconds / (m2 * s2),
        		(seconds % (m2 * s2)) / s2,
        		seconds % s2));
        
        bw.flush();
	}
}