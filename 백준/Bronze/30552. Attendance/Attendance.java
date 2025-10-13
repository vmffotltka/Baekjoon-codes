import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String pre = "";
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
        	String name = br.readLine();
        	if (!pre.equals("Present!") && !name.equals("Present!")) {
        		sb.append(pre).append(pre.isEmpty() ? "" : '\n');
        	}
        	pre = name;
        }
        if (!pre.equals("Present!")) sb.append(pre);
        if (sb.isEmpty()) sb.append("No Absences");
        
        System.out.print(sb.toString());
	}
}