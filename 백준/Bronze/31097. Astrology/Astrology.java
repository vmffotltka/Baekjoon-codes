import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String dateString = br.readLine();
        String[] parts = dateString.split("-");

        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        String zodiacSign = "";
        switch (month) {
            case 1:
                if (day <= 19) {
                    zodiacSign = "Capricorn";
                } else {
                    zodiacSign = "Aquarius";
                }
                break;
            case 2:
                if (day <= 18) {
                    zodiacSign = "Aquarius";
                } else {
                    zodiacSign = "Pisces";
                }
                break;
            case 3:
                if (day <= 20) {
                    zodiacSign = "Pisces";
                } else {
                    zodiacSign = "Aries";
                }
                break;
            case 4:
                if (day <= 19) {
                    zodiacSign = "Aries";
                } else {
                    zodiacSign = "Taurus";
                }
                break;
            case 5:
                if (day <= 20) {
                    zodiacSign = "Taurus";
                } else {
                    zodiacSign = "Gemini";
                }
                break;
            case 6:
                if (day <= 20) {
                    zodiacSign = "Gemini";
                } else {
                    zodiacSign = "Cancer";
                }
                break;
            case 7:
                if (day <= 22) {
                    zodiacSign = "Cancer";
                } else {
                    zodiacSign = "Leo";
                }
                break;
            case 8:
                if (day <= 22) {
                    zodiacSign = "Leo";
                } else {
                    zodiacSign = "Virgo";
                }
                break;
            case 9:
                if (day <= 22) {
                    zodiacSign = "Virgo";
                } else {
                    zodiacSign = "Libra";
                }
                break;
            case 10:
                if (day <= 22) {
                    zodiacSign = "Libra";
                } else {
                    zodiacSign = "Scorpio";
                }
                break;
            case 11:
                if (day <= 22) {
                    zodiacSign = "Scorpio";
                } else {
                    zodiacSign = "Sagittarius";
                }
                break;
            case 12:
                if (day <= 21) {
                    zodiacSign = "Sagittarius";
                } else {
                    zodiacSign = "Capricorn";
                }
                break;
        }
        System.out.println(zodiacSign);
    }
}