public class QuickSort {
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
        } else {
            int pivot = endingIndex;
            int i = startingIndex - 1;
            for (int j = startingIndex; j < endingIndex; j++) {
                if (arr[j] < arr[pivot]) {
                    i++;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            i++;

            int temp = arr[pivot];
            arr[pivot] = arr[i];
            arr[i] = temp;
            quickSort(arr, 0, i - 1);
            quickSort(arr, i + 1, endingIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 2, 4, 6, 8 };
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

}
