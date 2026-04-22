import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int mx = arr[0], cnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
                cnt++;
            }
        }
        System.out.println(cnt);

        mx = arr[n - 1]; cnt = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > mx) {
                mx = arr[i];
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}