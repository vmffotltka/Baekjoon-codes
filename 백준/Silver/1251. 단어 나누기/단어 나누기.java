import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder mn = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        	mn.append('z');
        for (int i = 1; i < s.length(); i++) {
        	for (int j = i + 1; j < s.length(); j++) {
        		StringBuilder cur = new StringBuilder(s.substring(0, i)).reverse()
        				.append(new StringBuilder(s.substring(i, j)).reverse())
        				.append(new StringBuilder(s.substring(j, s.length())).reverse());

        		if (mn.compareTo(cur) > 0)
        			mn = cur;
        	}
        }
        System.out.print(mn);
    }
}