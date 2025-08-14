import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(":");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        
        input = br.readLine().split(":");
        int c = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        
        bw.write(c <= a && d <= b ? "YES" : "NO");
        bw.flush();
    }
}