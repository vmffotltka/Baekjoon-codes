import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()), p = 0;
        if (n < 100000) p = n / 20;
        else if (n < 500000) p = n / 10;
        else if (n < 1000000) p = n * 3 / 20;
        else p = n / 5;
        
        System.out.printf("%d %d", p, n - p);
    }
}