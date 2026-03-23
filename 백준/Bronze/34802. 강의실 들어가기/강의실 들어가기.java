import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int start = h * 3600 + m * 60 + s;
        st = new StringTokenizer(br.readLine(), ":");
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int end = h * 3600 + m * 60 + s;
        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int ratio = Integer.parseInt(st.nextToken());

        System.out.print(end - start < (100 - ratio) * time / 100 ? 0 : 1);
    }
}