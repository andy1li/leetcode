# https://leetcode.com/problems/prime-in-diagonal/

from math import ceil, sqrt
from typing import List

class Solution:
    def diagonalPrime(self, nums: List[List[int]]) -> int:

        def is_prime(x):
            if x == 1: return False
            if x == 2: return True
            if not x % 2: return False
            for i in range(3, ceil(sqrt(x))+1, 2):
                if not x % i: return False
            return True 

        def diagonal():
            l = len(nums)
            for i in range(l):
                yield nums[i][i]
                yield nums[i][l-i-1]

        for x in sorted(diagonal(), reverse=True):
            if is_prime(x):
                return x
        return 0


solution = Solution()
assert solution.diagonalPrime([[1,2,3],[5,6,7],[9,10,11]]) == 11
assert solution.diagonalPrime([[1,2,3],[5,17,7],[9,11,10]]) == 17
