import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int first = 0, second = 0;
        String[] arr1 = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
        	int a = Integer.parseInt(arr1[i]);
        	for (int j = 0; j < n; j++) {
        		int b = Integer.parseInt(arr2[j]);
        		if (a > b) first++;
        		else if (a < b) second++;
        	}
        }
        System.out.print(first > second ? "first" : (first < second ? "second" : "tie"));
	}
}