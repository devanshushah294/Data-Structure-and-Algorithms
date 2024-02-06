public class SearchInRotatedArray {
    public static int search(int[] arr, int target, int startingIndex, int endingIndex) {
        if (startingIndex > endingIndex) {
            return -1;
        }
        int mid = startingIndex + (endingIndex - startingIndex) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[startingIndex] <= arr[mid]) {
            // case 1 if mid lies on above line
            if (target >= arr[startingIndex] && target <= arr[mid]) {
                return search(arr, target, startingIndex, mid - 1);
            } else {
                return search(arr, target, mid + 1, endingIndex);
            }

        } else {
            if (target >= arr[mid] && target <= arr[endingIndex]) {
                return search(arr, target, mid + 1, endingIndex);
            } else {
                return search(arr, target, startingIndex, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int target = 5;
        int targetIndex = search(arr, target, 0, arr.length - 1);
        if (targetIndex != -1) {
            System.out.println("targetIndex = " + targetIndex);
        } else {
            System.out.println("Not in array");
        }
    }
}
