import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int x1 = Integer.parseInt(input[0]);
        int x2 = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);
        
        bw.write((x1 - x2) % 2 == 0 && (x1 - x2) >= n * 2 ? "YES" : "NO");
        bw.flush();
    }
}