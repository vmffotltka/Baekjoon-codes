import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int[] denom = { 1, 5, 10, 20, 50, 100 };
        int mx = 0, ans = 0;
        for (int i = 5; i >= 0; i--) {
        	if (mx < denom[i] * Integer.parseInt(input[i])) {
        		mx = denom[i] * Integer.parseInt(input[i]);
        		ans = denom[i];
        	}
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}