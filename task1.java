// Реализовать алгоритм сортировки слиянием
public class task1 {
    public static void main(String[] args) {
        int [] array = new int[]{22, 4, 1, 9, 11, 7, 3, 8};
        int arrayLength = array.length;
        PrintArray(array);
        System.out.println();
        MergeSort(array, arrayLength);
        PrintArray(array);
        System.out.println();

    }
    public static void PrintArray(int [] arr) {
        for (var el : arr) {
            System.out.print(el+" ");
        }
    }
    public static void MergeSort(int [] arr, int size) {
        int halfSize = size / 2;
        int[] leftArr = new int[halfSize];
        int[] rightArr = new int[size - halfSize];
        if (size == 0 || size == 1) return;
        for (int i = 0; i < halfSize; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = halfSize; i < size; i++) {
            rightArr[i - halfSize] = arr[i];
        }
        MergeSort(leftArr, halfSize);
        MergeSort(rightArr, size - halfSize);
    
        MergeArray(arr, leftArr, rightArr, halfSize, size - halfSize);
    }
    public static void MergeArray(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            }
            else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < left) {
            arr[k++] = leftArr[i++];
        }
        while (j < right) {
            arr[k++] = rightArr[j++];
        }
    }
}
