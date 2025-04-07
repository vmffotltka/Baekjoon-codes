import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        long d = Long.parseLong(input[0]);
        long m = Long.parseLong(input[1]);
        long w = Long.parseLong(input[2]);
        input = br.readLine().split(" ");
        long i = Long.parseLong(input[0]);
        long j = Long.parseLong(input[1]);
        long k = Long.parseLong(input[2]);
        
        long days = (k - 1) * (d * m) + (j - 1) * d + i;
        bw.write((char)((days - 1) % w + 'a'));
        bw.flush();
        bw.close(); br.close();
    }
}