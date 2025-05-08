import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int d = Integer.parseInt(input[2]);
        bw.write((w <= d * 2 || h <= d * 2 ? 0 : (w - d * 2) * (h - d * 2)) + "");
       
        bw.flush();
        bw.close(); br.close();
    }
}