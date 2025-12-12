import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int curTime = h * 60 * 60 + m * 60 + s;

        st = new StringTokenizer(br.readLine(), ":");
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int startTime = h * 60 * 60 + m * 60 + s + 60 * 60 * 24;
        int time = (startTime - curTime) % (24 * 60 * 60);

        int ansH = time / (60 * 60), ansM = (time % (60 * 60)) / 60, ansS = time % 60;
        System.out.printf("%02d:%02d:%02d", ansH, ansM, ansS);
    }
}