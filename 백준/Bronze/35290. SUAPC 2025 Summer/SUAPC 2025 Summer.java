import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 2 || n == 6 || n == 7 || n == 8)
            System.out.print("Think before submission");
        else
            System.out.print("Solve harder problems");
    }
}