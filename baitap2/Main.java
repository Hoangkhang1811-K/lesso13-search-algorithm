package baitap2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int binarySearch(int[] array, int left, int right, int value) {
        if (left > right) return -1; // không tìm thấy

        int middle = (left + right) / 2;

        if (array[middle] == value) return middle;

        if (value > array[middle]) {
            return binarySearch(array, middle + 1, right, value);
        } else {
            return binarySearch(array, left, middle - 1, value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu n: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = Integer.parseInt(sc.nextLine().trim());
        }

        Arrays.sort(arr); // Bước 2: sắp xếp tăng dần
        System.out.println("Mang sau khi sap xep: " + Arrays.toString(arr));

        System.out.print("Nhap gia tri can tim: ");
        int value = Integer.parseInt(sc.nextLine().trim());

        int index = binarySearch(arr, 0, arr.length - 1, value);

        if (index == -1) {
            System.out.println("Khong tim thay " + value);
        } else {
            System.out.println("Tim thay " + value + " tai vi tri index = " + index);
        }
    }
}
