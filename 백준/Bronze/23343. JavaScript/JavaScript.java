import java.io.*;
import java.util.*;

public class Main {
	static final double INF = 987654321;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        boolean ans = true;
        for (int i = 0; i < 2; i++) {
            for (char c : input[i].toCharArray()) {
            	if (!Character.isDigit(c)) { ans = false; break; }
            }
        }
        bw.write(ans ? Integer.parseInt(input[0]) - Integer.parseInt(input[1]) + "" : "NaN");
        bw.flush();
        bw.close(); br.close();
	}
}