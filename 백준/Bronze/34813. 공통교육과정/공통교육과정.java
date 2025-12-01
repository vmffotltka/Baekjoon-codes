import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        if (s.charAt(0) == 'F') System.out.print("Foundation");
        else if (s.charAt(0) == 'C') System.out.print("Claves");
        else if (s.charAt(0) == 'V') System.out.print("Veritas");
        else System.out.print("Exploration");
    }
}