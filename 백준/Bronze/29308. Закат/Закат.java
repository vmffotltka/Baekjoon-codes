import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int mx = -1;
        String ans = "";
        for (int i = 0; i < n; i++) {
        	String[] input = br.readLine().split(" ");
        	if (input[2].equals("Russia") && Integer.parseInt(input[0]) > mx) {
        		mx = Integer.parseInt(input[0]);
        		ans = input[1];
        	}
        }
        bw.write(ans);
        bw.flush();
    }
}