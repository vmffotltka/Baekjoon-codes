import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        long weiA = 0, weiB = 0;
        while (a > 0) {
        	weiA += a % 10;
        	a /= 10;
        }
        while (b > 0) {
        	weiB += b % 10;
        	b /= 10;
        }
        weiA *= input[0].length();
        weiB *= input[1].length();
        bw.write(weiA > weiB ? "1" : (weiA < weiB ? "2" : "0"));
        bw.flush();
        bw.close(); br.close();
    }
}