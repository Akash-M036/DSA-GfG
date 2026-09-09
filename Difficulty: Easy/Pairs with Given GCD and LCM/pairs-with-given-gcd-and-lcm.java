class Solution {
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int pairCount(int x, int y) {
        if (y % x != 0) return 0;

        int totalPairs = 0;
        long n = y / x; 

        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                long counterpart = n / i;

                if (gcd(i, counterpart) == 1) {
                    if (i == counterpart) {
                        totalPairs += 1;
                    } else {
                        totalPairs += 2;
                    }
                }
            }
        }

        return totalPairs;
    }
}
