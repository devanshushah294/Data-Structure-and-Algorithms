import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MajorityElement {
    public static int getCountInRange(int[] arr, int si, int ei, int number) {
        int count = 0;
        for (int i = si; i <= ei; i++) {
            if (arr[i] == number)
                count++;
        }
        return count;
    }

    public static int getMaxByDevideAndConquer(int[] arr, int si, int ei) {
        if (si == ei) {
            return arr[si];
        }
        int mid = si + (ei - si) / 2;
        int left = getMaxByDevideAndConquer(arr, si, mid);
        int right = getMaxByDevideAndConquer(arr, mid + 1, ei);

        if (left == right) {
            return left;
        }
        int leftCount = getCountInRange(arr, si, ei, left);
        int rightCount = getCountInRange(arr, si, ei, right);
        if (leftCount > rightCount) {
            return left;
        } else {
            return right;
        }

    }

    public static int getMaximum(int[] arr) {
        int minLength = arr.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                int count = 1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }
                set.add(arr[i]);
                if (count > minLength) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 2, 1, 1, 1, 2, 2, 2 };
        int max = getMaxByDevideAndConquer(arr, 0, arr.length - 1);
        System.out.println("Maximum  = " + max);
    }

}
