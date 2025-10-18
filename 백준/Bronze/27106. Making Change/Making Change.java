import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int remainder = 100 - n;
        int[] denom = { 25, 10, 5, 1 };
        for (int i = 0; i < 4; i++) {
            sb.append(remainder / denom[i]).append(' ');
            remainder -= (remainder / denom[i]) * denom[i];
        }
        System.out.print(sb);
    }
}