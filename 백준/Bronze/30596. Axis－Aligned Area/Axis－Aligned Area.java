import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.print(arr[0] * arr[2]);
	}
}