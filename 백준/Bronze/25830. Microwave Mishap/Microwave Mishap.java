import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(":");
        int m = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        
        int ans = m * 60 * 60 + s * 60 - m * 60 - s;
        bw.write(String.format("%02d:%02d:%02d", ans / 3600, ans % 3600 / 60, ans % 60));
        bw.flush();
        bw.close(); br.close();
    }
}