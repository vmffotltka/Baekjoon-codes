import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[][] table = new long[50][];
        
        table[0] = new long[]{0, 0, 0};
        table[1] = new long[]{0, 0, 1};
        table[2] = new long[]{0, 1, 1};
        table[3] = new long[]{1, 1, 1};
        table[6] = new long[]{-1, -1, 2};
        table[7] = new long[]{0, -1, 2};
        table[8] = new long[]{0, 0, 2};
        table[9] = new long[]{0, 1, 2};
        table[10] = new long[]{1, 1, 2};
        table[11] = new long[]{-2, -2, 3};
        table[12] = new long[]{7, 10, -11};
        table[15] = new long[]{-1, 2, 2};
        table[16] = new long[]{-511, -1609, 1626};
        table[17] = new long[]{1, 2, 2};
        table[18] = new long[]{-1, -2, 3};
        table[19] = new long[]{0, -2, 3};
        table[20] = new long[]{1, -2, 3};
        table[21] = new long[]{-11, -14, 16};
        table[24] = new long[]{-2901096694L, -15550555555L, 15584139827L};
        table[25] = new long[]{-1, -1, 3};
        table[26] = new long[]{0, -1, 3};
        table[27] = new long[]{0, 0, 3};
        table[28] = new long[]{0, 1, 3};
        table[29] = new long[]{1, 1, 3};
        table[30] = new long[]{-283059965L, -2218888517L, 2220422932L};
        table[33] = new long[]{8866128975287528L, -8778405442862239L, -2736111468807040L};
        table[34] = new long[]{-1, 2, 3};
        table[35] = new long[]{0, 2, 3};
        table[36] = new long[]{1, 2, 3};
        table[37] = new long[]{0, -3, 4};
        table[38] = new long[]{1, -3, 4};
        table[39] = new long[]{117367, 134476, -159380};
        table[42] = new long[]{-80538738812075974L, 80435758145817515L, 12602123297335631L};
        table[43] = new long[]{2, 2, 3};
        table[44] = new long[]{-5, -7, 8};
        table[45] = new long[]{2, -3, 4};
        table[46] = new long[]{-2, 3, 3};
        table[47] = new long[]{6, 7, -8};
        table[48] = new long[]{-23, -26, 31};
        
        int n = Integer.parseInt(br.readLine());
        if (table[n] == null) bw.write("0");
        else {
        	bw.write(table[n][0] + " " + table[n][1] + " " + table[n][2]);
        }
        
        bw.flush(); 
    }
}   