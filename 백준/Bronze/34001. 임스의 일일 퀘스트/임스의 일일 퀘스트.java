import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arcaneRiver = {
                {200, 210, 220},
                {210, 220, 225},
                {220, 225, 230},
                {225, 230, 235},
                {230, 235, 245},
                {235, 245, 250}
        };
        int[][] grandis = {
                {260, 265, 270},
                {265, 270, 275},
                {270, 275, 280},
                {275, 280, 285},
                {280, 285, 290},
                {285, 290, 295},
                {290, 295, 300}
        };
        printRequirement(n, arcaneRiver);
        printRequirement(n, grandis);
    }
    static void printRequirement(int level, int[][] regions) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < regions.length; i++) {
            int questLv = regions[i][0];
            int red1 = regions[i][1];
            int red2 = regions[i][2];

            if (level < questLv)
                sb.append(0);
            else if (level >= red2)
                sb.append(100);
            else if (level >= red1)
                sb.append(300);
            else
                sb.append(500);

            if (i < regions.length - 1)
                sb.append(" ");
        }
        System.out.println(sb);
    }
}