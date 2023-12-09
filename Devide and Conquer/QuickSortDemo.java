public class QuickSortDemo {
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void quickSort(int[] arr, int startingIndex, int endingIndex) {
        if (startingIndex >= endingIndex) {
            return;
        }
        int pivot = arr[endingIndex];
        int i = getDevidingPoint(arr, startingIndex, endingIndex);
        quickSort(arr, startingIndex, i - 1);
        quickSort(arr, i + 1, endingIndex);
    }

    public static int getDevidingPoint(int[] arr, int startingIndex, int endingIndex) {
        int pivot = arr[endingIndex];
        int i = startingIndex - 1;
        for (int j = startingIndex; j <= endingIndex; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[endingIndex] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 8, 6, 4, 2, 1, 3, 5, 7, 9, 19, -1, 23, 56, 34, 24, 345, -345 };
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);

    }
}
