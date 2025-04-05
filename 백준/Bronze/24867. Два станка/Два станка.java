import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long k = Long.parseLong(br.readLine());
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]), x = Long.parseLong(input[1]);
        input = br.readLine().split(" ");
        long b = Long.parseLong(input[0]), y = Long.parseLong(input[1]);
        
        bw.write(Math.max(Math.max(0, (k - a)) * x + Math.max(0, (k - a - b)) * y, Math.max(0, (k - b)) * y + Math.max(0, (k - a - b)) * x) + "");
        bw.flush();
        bw.close(); br.close();
    }
}