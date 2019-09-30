
/**
 * Created by Kazumi on 11:29 PM, 4/6/2019
 */
public class MergeSort {
    int[] mergeSort(int[] arr) {
        int size = arr.length;
        if (size == 0) return null;
        if (size == 1) return arr;

        int m = size / 2;
        int[] left = new int[m];
        int[] right = new int[size - m];
        System.arraycopy(arr, 0, left, 0, m);
        System.arraycopy(arr, m, right, 0, size - m);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        if (left == null) return right;
        if (right == null) return left;

        int sizeL = left.length;
        int sizeR = right.length;
        int ptrL = 0, ptrR = 0;
        int current = 0;

        int[] sorted = new int[sizeL + sizeR];
        // Add left and right side according to their orders
        while (ptrL < sizeL && ptrR < sizeR) {
            // Add items from left and right according to their position
            if (left[ptrL] <= right[ptrR]) {
                sorted[current] = left[ptrL];
                ptrL++;
                current++;
            } else {
                sorted[current] = right[ptrR];
                ptrR++;
                current++;
            }
        }

        // Finish the rest of the array
        while (ptrL < sizeL) {
            sorted[current] = left[ptrL];
            ptrL++;
            current++;
        }

        while (ptrR < sizeR) {
            sorted[current] = right[ptrR];
            ptrR++;
            current++;
        }

        return sorted;
    }

    static void printArray(int arr[])
    {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] a = new int[] {1,9,8,4,0,2,10};

        printArray(ms.mergeSort(a));
    }
}
