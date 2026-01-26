import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double d = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());
        double r = d / 2 + 5;
        System.out.printf("%.10f", r * r * Math.PI + 2 * Math.PI * r * h);
    }
}