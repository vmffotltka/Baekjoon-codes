import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            boolean changed = false;
            for (int j = 1; j < 5; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    changed = true;
                    for (int k = 0; k < 5; k++) {
                        sb.append(arr[k]).append(" ");
                    }
                    sb.append("\n");
                }
            }
            if (!changed) break;
        }
        System.out.print(sb);
    }
}