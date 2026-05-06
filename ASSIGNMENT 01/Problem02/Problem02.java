import java.util.*;

public class Problem02 {

    public static long minimumOperations(int[] arr, int k) {

        int n = arr.length;

        if (k == 0) {

            for (int i = 1; i < n; i++) {
                if (arr[i] != arr[0]) {
                    return -1;
                }
            }

            return 0;
        }

        long minOperations = Long.MAX_VALUE;

        for (int target : arr) {

            long operations = 0;
            boolean possible = true;

            for (int num : arr) {

                int diff = Math.abs(num - target);

                if (diff % k != 0) {
                    possible = false;
                    break;
                }

                operations += diff / k;
            }

            if (possible) {
                minOperations = Math.min(minOperations, operations);
            }
        }

        return minOperations == Long.MAX_VALUE ? -1 : minOperations;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(minimumOperations(arr, k));

        sc.close();
    }
}