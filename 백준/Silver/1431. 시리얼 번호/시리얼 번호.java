import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
        	arr[i] = br.readLine();
        
        Arrays.sort(arr, new Comparator<String>() {
        	@Override
        	public int compare(String a, String b) {
        		if (a.length() != b.length()) return Integer.compare(a.length(), b.length());
        		else {
        			int sumA = sumOfDigits(a);
        			int sumB = sumOfDigits(b);
        			if (sumA != sumB) return Integer.compare(sumA, sumB);
        			else return a.compareTo(b);
        		}
        	}
        	private int sumOfDigits(String s) {
        		int sum = 0;
        		for (char c : s.toCharArray()) {
        			if (Character.isDigit(c)) sum += c - '0';
        		}
        		return sum;
        	}
        });
        for (String str : arr)
        	bw.write(str + "\n");
        bw.flush();
        bw.close(); br.close();
	}
}