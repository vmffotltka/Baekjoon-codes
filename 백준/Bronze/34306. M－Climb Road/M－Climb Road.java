import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int w = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        System.out.print(w * 5280 / n);
    }
}