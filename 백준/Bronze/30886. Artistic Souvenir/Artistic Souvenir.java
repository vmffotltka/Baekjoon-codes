import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        double r = Math.sqrt(n / Math.PI);
        r = r * 2 + 2;
        System.out.printf("%.10f", r * r);
    }
}