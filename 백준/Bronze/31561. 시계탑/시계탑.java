import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double m = Double.parseDouble(br.readLine()); 
        System.out.printf("%.1f", (m < 30 ? m / 2 : m * 3 / 2 - 30));
    }
}