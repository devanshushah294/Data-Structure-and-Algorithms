public class MergeSort {
    public static void merge(int[] arr, int startingIndex, int mid, int endingIndex) {
        int[] temp = new int[endingIndex - startingIndex + 1];
        int i = startingIndex;// iterator for left part
        int j = mid + 1;// iterator for rigth part
        int k = 0;// iterator for temp arr
        for (k = 0; k < temp.length && i <= mid && j <= endingIndex; k++) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= endingIndex) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        // copy temp to array
        for (k = 0, i = startingIndex; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void printArray(int[] arr) {
        System.out.println("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void mergeSort(int[] arr, int startingIndex, int endingIndex) {
        if (startingIndex >= endingIndex) {
            return;
        }
        int mid = (startingIndex) + (endingIndex - startingIndex) / 2;
        mergeSort(arr, startingIndex, mid);
        mergeSort(arr, mid + 1, endingIndex);
        merge(arr, startingIndex, mid, endingIndex);

    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 10, 5, 85, 96, 74, 852, 25, 14, 236 };
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}