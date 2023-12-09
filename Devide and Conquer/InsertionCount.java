public class InsertionCount {

    public static int merge(int[] arr, int si, int mid, int ei) {
        int[] tempArr = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k;
        int count = 0;
        for (k = 0; k < tempArr.length && i <= mid && j <= ei; k++) {
            if (arr[i] <= arr[j]) {
                tempArr[k] = arr[i];
                i++;
            } else {
                tempArr[k] = arr[j];
                j++;
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            tempArr[k] = arr[i];
            k++;
            i++;
        }
        while (j <= ei) {
            tempArr[k] = arr[j];
            j++;
            k++;
        }
        for (k = 0, i = si; k < tempArr.length; k++, i++) {
            arr[i] = tempArr[k];
        }
        return count;

    }

    public static int findInsertions(int arr[], int si, int ei) {
        if (si >= ei) {
            return 0;
        }
        int count = 0;
        int mid = si + (ei - si) / 2;
        count += findInsertions(arr, 0, mid);
        count += findInsertions(arr, mid + 1, ei);
        count += merge(arr, si, mid, ei);
        return count;
    }

    public static int findInsertions(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 2, 4, 1, 3, 5 };
        int answer = findInsertions(arr, 0, arr.length - 1);
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
        System.out.println("answer = " + answer);
    }

}
