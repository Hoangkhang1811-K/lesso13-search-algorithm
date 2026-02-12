package baitap1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.println(longestIncreasingSubstring(s));
    }

    private static String longestIncreasingSubstring(String s) {
        if (s == null || s.isEmpty()) return "";

        int bestStart = 0, bestLen = 1;
        int start = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(i - 1)) {
                // vẫn tăng dần -> tiếp tục
            } else {
                // bị ngắt chuỗi tăng dần, chốt đoạn [start..i-1]
                int len = i - start;
                if (len > bestLen) {
                    bestLen = len;
                    bestStart = start;
                }
                start = i; // bắt đầu đoạn mới từ i
            }
        }

        // chốt đoạn cuối cùng
        int len = s.length() - start;
        if (len > bestLen) {
            bestLen = len;
            bestStart = start;
        }

        return s.substring(bestStart, bestStart + bestLen);
    }
}