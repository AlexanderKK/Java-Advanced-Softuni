package _00Olimpiada;

import java.math.BigInteger;
import java.util.*;

public class _02ChisloN2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int k = Integer.parseInt(input[0]);
        BigInteger n = new BigInteger(input[1]);

        if(n.toString().length() < 1 || n.toString().length() > 30 || k <= 0 || k > 30) {
            return;
        }

        String num = n.toString();
        String result = "";

        for (int digit = 0; digit <= 9; digit++) {
            if(!num.contains(digit + "") && result.length() <= k) {
                result += digit;
            }
        }

        if(result.length() > 0 && !result.equals("0")) {
            StringBuilder resultSB = new StringBuilder(result);

            for (int i = 0; i < resultSB.length(); i++) {
                if(resultSB.charAt(0) == '0') {
                    resultSB.deleteCharAt(0);
                }
            }

            while(resultSB.length() < k) {
                String digitToAdd = "";

                for (int digit = 0; digit <= 9; digit++) {
                    if(!num.contains(digit + "")) {
                        digitToAdd = digit + "";
                        break;
                    }
                }

                resultSB.insert(1, digitToAdd);
            }

            if(isResultValid(num, resultSB.toString())) {
                System.out.println(resultSB);
            } else {
                System.out.println(0);
            }
        } else {
            System.out.println(0);
        }
    }

    private static boolean isResultValid(String N, String result) {
        Set<String> digits = new HashSet<>();

        for (int i = 0; i <= 9; i++) {
            if(!N.contains(i + "")) {
                digits.add(i + "");
            }
        }

        for (String digit : digits) {
            if (!result.contains(digit)) {
                return false;
            }
        }

        return true;
    }
}
