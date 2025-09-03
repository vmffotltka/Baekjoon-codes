import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[21];
        for (int i = 1; i <= 20; i++) arr[i] = i;
        
        for (int i = 0; i < 10; i++) {
        	String[] input = br.readLine().split(" ");
        	int a = Integer.parseInt(input[0]);
        	int b = Integer.parseInt(input[1]);
        	
        	while (a <= b) {
        		int tmp = arr[a];
        		arr[a] = arr[b];
        		arr[b] = tmp;
        		
        		a++;
        		b--;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 20; i++) {
        	sb.append(String.format("%d ", arr[i]));
        }
        System.out.print(sb.toString().strip());
    }
}