import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long bit = 1;
        while (bit < 64 && (1L << bit) <= n)
            bit <<= 1;
        System.out.print(bit + (bit == 1 ? " bit" : " bits"));
    }
}