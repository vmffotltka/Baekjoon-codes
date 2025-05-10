import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        String[] arr = br.readLine().split(" ");
        int idx = 0, cur = x;
        while (true) {
        	if (Integer.parseInt(arr[idx]) < cur) {
        		bw.write((idx + 1) + "");
        		break;
        	}
        	idx = (idx + 1) % n;
        	cur++;
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}