import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());
        while (true) {
            int yobi = Integer.parseInt(br.readLine());
            if (d <= yobi) break;
            d += yobi;
        }
        System.out.print(d);
    }
}