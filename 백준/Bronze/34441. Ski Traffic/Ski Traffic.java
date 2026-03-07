import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) + h * 60;

        String days = br.readLine();
        if (days.equals("sat") || days.equals("sun"))
            m *= 2;

        int flag = Integer.parseInt(br.readLine());
        if (flag == 1)
            m *= 2;

        flag = Integer.parseInt(br.readLine());
        if (flag == 1)
            m *= 3;

        flag = Integer.parseInt(br.readLine());
        if (flag == 1)
            m *= 3;

        System.out.printf("%d:%02d", m / 60, m % 60);
    }
}