package baitap3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.println(longestIncreasingSubstring(s));
    }

    // tìm substring liên tiếp tăng dần (theo ASCII)
    private static String longestIncreasingSubstring(String s) {
        if (s == null || s.isEmpty()) return "";

        int bestStart = 0, bestLen = 1;
        int start = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(i - 1)) {
                // vẫn tăng -> tiếp tục
            } else {
                // bị ngắt, chốt đoạn trước
                int len = i - start;
                if (len > bestLen) {
                    bestLen = len;
                    bestStart = start;
                }
                start = i;
            }
        }

        // chốt đoạn cuối
        int len = s.length() - start;
        if (len > bestLen) {
            bestLen = len;
            bestStart = start;
        }

        return s.substring(bestStart, bestStart + bestLen);
    }
}

