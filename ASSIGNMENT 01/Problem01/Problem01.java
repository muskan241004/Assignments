import java.util.*;

public class Problem01 {

    public static int maxCyclicSubstringSum(String s) {

        int n = s.length();
        String doubled = s + s;

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < 2 * n; right++) {

            char ch = doubled.charAt(right);

            while (set.contains(ch) || (right - left + 1) > n) {

                char remove = doubled.charAt(left);
                currentSum -= (remove - 'a' + 1);
                set.remove(remove);
                left++;
            }

            set.add(ch);
            currentSum += (ch - 'a' + 1);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(maxCyclicSubstringSum(s));

        sc.close();
    }
}