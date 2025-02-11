import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String s = st.nextToken();
        	if (s.equals("#")) break;
        	int y = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	boolean heisei = (y == 31 && m >= 5) || y > 31;
        	bw.write((heisei ? "?" : s) + " " + (heisei ? y - 30 : y) + " " + m + " " + d + "\n");
        }
        bw.flush();
        bw.close(); br.close();
	}
}