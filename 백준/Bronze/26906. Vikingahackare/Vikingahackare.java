import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        HashMap<String, Character> map = new HashMap<>();
        while (t-- > 0) {
        	String[] input = br.readLine().split(" ");
        	map.put(input[1], input[0].charAt(0));
        }
        String s = br.readLine();
        for (int i = 0; i < s.length(); i += 4) {
        	String subStr = s.substring(i, i + 4);
        	if (map.getOrDefault(subStr, ' ') == ' ') bw.write("?");
        	else bw.write(map.get(subStr));
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}