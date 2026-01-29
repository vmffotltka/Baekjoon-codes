import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        double t = Double.parseDouble(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double f = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double sec = l / f + l / b;
            if (sec < t) {
                System.out.print("HOPE");
                return;
            }
        }
        System.out.print("DOOMED");
    }
}