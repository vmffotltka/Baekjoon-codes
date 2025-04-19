import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
        	int n = Integer.parseInt(br.readLine()), ans = 0;
        	if (n == 0) break;
        	String[] input = br.readLine().split(" ");
        	for (int i = 1; i < n - 1; i++) {
        		int a = Integer.parseInt(input[i - 1]);
        		int b = Integer.parseInt(input[i]);
        		int c = Integer.parseInt(input[i + 1]);
        		if (a < b && b > c) ans++;
        	}
        	bw.write(ans + "\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}