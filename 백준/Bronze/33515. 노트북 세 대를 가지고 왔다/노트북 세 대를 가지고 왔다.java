import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
        bw.write(Math.min(a, b) + "");
        bw.flush();
        bw.close(); br.close();
	}
}