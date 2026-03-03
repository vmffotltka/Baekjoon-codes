import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sec = Integer.parseInt(br.readLine()) % 3600;
        System.out.print((3659 - sec) * 60 / 3600);
    }
}