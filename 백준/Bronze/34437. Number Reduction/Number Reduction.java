import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()), cnt = 0;
        while (n != 1) {
            if (n % 2 == 1) n += n * 2 + 1;
            else n /= 2;
            cnt++;
        }
        System.out.print(cnt);
    }
}