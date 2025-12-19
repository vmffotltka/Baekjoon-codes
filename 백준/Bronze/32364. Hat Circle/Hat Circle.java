import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n / 2];
        for (int i = 0; i < n / 2; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n / 2; i++) {
            int p = Integer.parseInt(br.readLine());
            if (arr[i] == p) cnt += 2;
        }
        System.out.print(cnt);
    }
}