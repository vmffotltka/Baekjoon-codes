import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        if (a + b <= d && c <= d)
            System.out.print("~.~");
        else if (a + b > d && c > d)
            System.out.print("T.T");
        else if (a + b <= d)
            System.out.print("Shuttle");
        else
            System.out.print("Walk");
    }
}