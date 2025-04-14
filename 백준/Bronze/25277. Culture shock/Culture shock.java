import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), ans = 0;
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
        	if (input[i].equals("he") || input[i].equals("she") || input[i].equals("him") || input[i].equals("her"))
        		ans++;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}