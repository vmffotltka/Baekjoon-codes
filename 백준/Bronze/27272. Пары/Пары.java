import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
        	arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        bw.write((arr[0] * arr[1] + arr[2] * arr[3]) + "");
        bw.flush();
    }
}