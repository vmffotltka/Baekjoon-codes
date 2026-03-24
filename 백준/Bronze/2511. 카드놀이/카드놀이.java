import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = 0, b = 0, lastWin = 0;
        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (arr[i] > x) {
                a += 3;
                lastWin = 1;
            }
            else if (arr[i] < x) {
                b += 3;
                lastWin = 2;
            }
            else {
                a++; b++;
            }
        }
        System.out.println(a + " " + b);
        System.out.print(a > b ? "A" : (a < b ? "B" : (lastWin == 1 ? "A" : (lastWin == 2 ? "B" : "D"))));
    }
}