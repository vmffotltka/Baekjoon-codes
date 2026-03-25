import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int time = h * 60 + m;

        if ((390 <= time && time <= 540) ||
                (590 <= time && time <= 600) ||
                (650 <= time && time <= 660) ||
                (710 <= time && time <= 720) ||
                (770 <= time && time <= 830) ||
                (880 <= time && time <= 890) ||
                (940 <= time && time <= 950) ||
                (1000 <= time && time <= 1370)
        )
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}