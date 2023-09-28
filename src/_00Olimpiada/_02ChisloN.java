package _00Olimpiada;

import java.math.BigInteger;
import java.util.Scanner;

public class _02ChisloN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int k = Integer.parseInt(input[0]);
        BigInteger n = new BigInteger(input[1]);

        if(n.toString().length() < 1 || n.toString().length() > 30 || k <= 0 || k > 30) {
            return;
        }

        String zeroes = "";
        String biggest = "";

        for (int i = 1; i < k; i++) {
            zeroes += "0";
            biggest += "9";
        }

        BigInteger start = new BigInteger("1" + zeroes);
        BigInteger end = new BigInteger("9" + biggest);

        BigInteger i = start;

        BigInteger result = BigInteger.valueOf(0);

        while (i.compareTo(end) <= 0) {
            String nStr = n.toString();
            String currentNum = i.toString();

            boolean hasDifferentDigits = true;
            for (int j = 0; j < nStr.length(); j++) {
                if(currentNum.contains(nStr.charAt(j) + "")) {
                    hasDifferentDigits = false;
                }
            }

            if(hasDifferentDigits && hasUniqueDigits(currentNum)) {
                result = i;
                break;
            }

            i = i.add(BigInteger.ONE);
        }

        System.out.println(result);
    }

    private static boolean hasUniqueDigits(String number) {
        for (int i = 0; i < number.length(); i++) {
            for (int j = i + 1; j < number.length(); j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
