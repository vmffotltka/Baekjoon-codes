import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        if (arr[0].equals(arr[3]) || arr[1].equals(arr[2])) {
        	bw.write("JAH\n" + String.format("%s %s %s %s", arr[0], arr[1], arr[1], arr[0]));
        }
        else bw.write("EI");
        bw.flush();
    }
}