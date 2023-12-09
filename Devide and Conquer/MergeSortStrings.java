public class MergeSortStrings {
    public static boolean checkStrings(String str1, String str2) {
        if (str2.compareTo(str1) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void merge(String[] arr, int startingIndex, int mid, int endingIndex) {
        String[] temp = new String[endingIndex - startingIndex + 1];
        int i = startingIndex;
        int j = mid + 1;
        int k = 0;
        for (k = 0; k < temp.length && i <= mid && j <= endingIndex; k++) {
            if (checkStrings(arr[i], arr[j])) {
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
        for (k = 0, i = startingIndex; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void mergeSort(String[] arr, int startingIndex, int endingIndex) {
        if (startingIndex >= endingIndex) {
            return;
        }
        int mid = startingIndex + (endingIndex - startingIndex) / 2;
        mergeSort(arr, startingIndex, mid);
        mergeSort(arr, mid + 1, endingIndex);
        merge(arr, startingIndex, mid, endingIndex);
    }

    public static void printArray(String[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        String[] arr = { "sun", "earth", "mars", "mercury" };
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

}
