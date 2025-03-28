import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
        	String[] input = br.readLine().split(" ");
        	int a = Integer.parseInt(input[0]);
        	int b = Integer.parseInt(input[1]);
        	int c = Integer.parseInt(input[2]);
        	bw.write((a + b == c || a - b == c || b - a == c || a * b == c || b * c == a || a * c == b) ? "Possible\n" : "Impossible\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}