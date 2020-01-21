public class MinDominoRotation {
    public int solution(int[] A, int[] B) {
        int[] countA = new int[7], countB = new int[7], countSame = new int[7];

        for (int i = 0; i < A.length; i++) {
            countA[A[i]]++;
            countB[B[i]]++;

            if (A[i] == B[i]) {
                countSame[A[i]]++;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            if (countA[i] + countB[i] - countSame[i] == A.length) {
                min = Math.min(A.length - Math.max(countA[i], countB[i]), min);
            }
        }

        if (min != Integer.MAX_VALUE) {
            return min;
        } else {
            return -1;
        }
    }
}
