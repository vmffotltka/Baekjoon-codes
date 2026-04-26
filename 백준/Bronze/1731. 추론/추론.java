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
        if (arr[1] - arr[0] == arr[2] - arr[1])
            System.out.print(arr[n - 1] + arr[1] - arr[0]);
        else
            System.out.print(arr[n - 1] * (arr[1] / arr[0]));
    }
}