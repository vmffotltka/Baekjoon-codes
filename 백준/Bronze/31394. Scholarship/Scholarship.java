import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] marks = new int[6];
        int sum = 0;
        for (int i = 0; i < n; i++) {
        	int mark = Integer.parseInt(br.readLine());
        	marks[mark]++;
        	sum += mark;
        }
        if (marks[3] > 0) System.out.print("None");
        else if (marks[5] == n) System.out.print("Named");
        else if (n * 9 <= sum * 2) System.out.print("High");
        else System.out.print("Common");
    }
}