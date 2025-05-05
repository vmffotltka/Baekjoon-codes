import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        int digit = Integer.parseInt(input[2]);
        int ans = 0;
        for (int i = start; i <= end; i++) {
        	int tmp = i;
        	while (tmp > 0) {
        		if (tmp % 10 == digit) ans++;
        		tmp /= 10;
        	}
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}