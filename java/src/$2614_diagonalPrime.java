// https://leetcode.com/problems/prime-in-diagonal/

import static org.junit.jupiter.api.Assertions.assertEquals;

public class $2614_diagonalPrime {

    public int diagonalPrime(int[][] nums) {

        int result = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (isPrime(nums[i][i])) {
                result = Math.max(result, nums[i][i]);
            }
            if (isPrime(nums[i][l-i-1])) {
                result = Math.max(result, nums[i][l-i-1]);
            }
        }
        return result;
    }


    boolean isPrime(int x) {

        if (x == 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;

        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {

        var solution = new $2614_diagonalPrime();
        assertEquals(11, solution.diagonalPrime(new int[][]{{1, 2, 3}, {5, 6, 7}, {9, 10, 11}}));
        assertEquals(17, solution.diagonalPrime(new int[][]{{1, 2, 3}, {5, 17, 7}, {9, 11, 10}}));
    }

}