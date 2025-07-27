import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
        	if (input[i].equals("1")) cnt++;
        }
        bw.write(Math.max(0, (n + 1) / 2 - cnt) + "");
        bw.flush();
    }
}