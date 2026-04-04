import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger b1 = new BigInteger(st.nextToken(), 2);
        BigInteger b2 = new BigInteger(st.nextToken(), 2);
        BigInteger sum = b1.add(b2);
        System.out.print(sum.toString(2));
    }
}