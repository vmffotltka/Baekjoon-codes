import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());
        
        System.out.print(Math.min((100 - n) * (m + 1) * s / 100, m * s));
    }
}