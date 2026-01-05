import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            char pre = '|';
            for (int j = 0; j < m; j++) {
                if (arr[i].charAt(j) != pre && arr[i].charAt(j) == '-')
                    count++;
                pre = arr[i].charAt(j);
            }
        }
        for (int j = 0; j < m; j++) {
            char pre = '-';
            for (int i = 0; i < n; i++) {
                if (arr[i].charAt(j) != pre && arr[i].charAt(j) == '|')
                    count++;
                pre = arr[i].charAt(j);
            }
        }
        System.out.print(count);
    }
}