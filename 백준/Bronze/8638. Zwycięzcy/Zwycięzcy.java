import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        ArrayList<Character> arr = new ArrayList<>();
        
        int mx = 0;
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(input[i]);
        	if (p > mx) {
        		mx = p;
        		arr.clear();
        		arr.add((char)('A' + i));
        	}
        	else if (p == mx) {
        		arr.add((char)('A' + i));
        	}
        }
        for (int i = 0; i < arr.size(); i++) {
        	bw.write(arr.get(i));
        }
        bw.flush();
	}
}