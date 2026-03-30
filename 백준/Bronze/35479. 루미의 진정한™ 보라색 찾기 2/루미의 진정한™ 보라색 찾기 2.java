import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double r = Double.parseDouble(st.nextToken()) / 255;
        double g = Double.parseDouble(st.nextToken()) / 255;
        double b = Double.parseDouble(st.nextToken()) / 255;

        double k = 1 - Math.max(Math.max(r, g), b);
        double c, m, y;
        if (k == 1)
            c = m = y = 0;
        else {
            c = (1 - r - k) / (1 - k);
            m = (1 - g - k) / (1 - k);
            y = (1 - b - k) / (1 - k);
        }
        System.out.printf("%f %f %f %f", c, m, y, k);
    }
}