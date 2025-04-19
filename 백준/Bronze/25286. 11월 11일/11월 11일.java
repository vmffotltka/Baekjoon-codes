import java.io.*;
import java.util.*;

public class Main {
	static boolean isYoon(int n) {
		return ((n % 100 != 0 && n % 4 == 0) || n % 400 == 0) ? true : false;
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	String[] input = br.readLine().split(" ");
        	int y = Integer.parseInt(input[0]);
        	int m = Integer.parseInt(input[1]);
        	if (m == 1) bw.write(y - 1 + " 12 31\n");
        	else if (m == 2) bw.write(y + " 1 31\n");
        	else if (m == 3) bw.write(y + (isYoon(y) ? " 2 29\n" : " 2 28\n"));
        	else if (m == 4) bw.write(y + " 3 31\n");
        	else if (m == 5) bw.write(y + " 4 30\n");
        	else if (m == 6) bw.write(y + " 5 31\n");
        	else if (m == 7) bw.write(y + " 6 30\n");
        	else if (m == 8) bw.write(y + " 7 31\n");
        	else if (m == 9) bw.write(y + " 8 31\n");
        	else if (m == 10) bw.write(y + " 9 30\n");
        	else if (m == 11) bw.write(y + " 10 31\n");
        	else bw.write(y + " 11 30\n");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}