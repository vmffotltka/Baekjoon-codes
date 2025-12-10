import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int problems = 0;
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (cmd == 1) problems += x;
            else {
                problems -= x;
                if (problems < 0) {
                    System.out.print("Adios");
                    return;
                }
            }
        }
        System.out.print("See you next month");
    }
}