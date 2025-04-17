import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = { -30, 0, 0 };
        for (int i = 0; i < n; i++) {
        	String[] input = br.readLine().split(" ");
        	if (input[0].equals("temperature")) arr[0] += input[1].charAt(1) - '0';
        	else if (input[0].equals("oxygen")) arr[1] += input[1].charAt(1) - '0';
        	else arr[2] += input[1].charAt(1) - '0';
        }
        bw.write(arr[0] >= 8 && arr[1] >= 14 && arr[2] >= 9 ? "liveable" : "not liveable");
        bw.flush();
        bw.close(); br.close();
    }
}