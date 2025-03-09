import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int tri = 0, a = 0, b = 0;
        while (n > 0) {
        	if (tri == 1) a += n / 2 + n % 2;
        	else b += n / 2 + n % 2;
        	n /= 2;
        	tri ^= 1;
        }
        bw.write(a + " " + b);
        
        bw.flush();
        bw.close(); br.close();
    }
}