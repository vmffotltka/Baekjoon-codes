import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int s = Integer.parseInt(input[2]);
        int ans = h * 60 * 60 + m * 60 + s + 1;
        bw.write(String.format("%02d:%02d:%02d", ans / 3600 % 24, ans % 3600 / 60, ans % 60));
        
        bw.flush();
        bw.close(); br.close();
    }
}