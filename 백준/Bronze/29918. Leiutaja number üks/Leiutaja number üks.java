import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int cnt = Integer.parseInt(input[0]) + Integer.parseInt(input[1]) * 10;
        
        int mx = -1;
        for (int i = 0; i < 5; i++) {
        	input = br.readLine().split(" ");
        	mx = Math.max(mx, Integer.parseInt(input[0]) + Integer.parseInt(input[1]) * 10);
        }
        bw.write(String.valueOf(Math.max(0, mx - cnt + 1)));
        bw.flush();
    }
}