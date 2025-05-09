import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] arr = new int['z' - 'a' + 1];
        for (char c : s.toCharArray()) {
        	arr[c - 'a']++;
        }
        boolean isEven = true, isOdd = true;
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
        	if (arr[i] == 0) continue;
        	if (arr[i] % 2 != 0) isEven = false;
        	else isOdd = false;
        }
        bw.write(isEven ? "0" : (isOdd ? "1" : "2"));
        bw.flush();
        bw.close(); br.close();
    }
}