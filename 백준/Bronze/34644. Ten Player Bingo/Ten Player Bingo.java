import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int digit = s.charAt(s.length() - 1) - '0';
        System.out.print(digit == 0 ? 10 : digit);
    }
}