import java.util.Arrays;

class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;

        // 1. Sort the array to group negative and positive values together
        Arrays.sort(arr);

        int product = 1;
        int left = 0;
        int right = n - 1;

        // 2. Handle cases where k is odd
        if ((k & 1) != 0) {
            // Case A: If all elements are non-positive (<= 0), an odd k subsequence 
            // will inevitably yield a negative or zero product. Take the largest numbers closest to 0.
            if (arr[n - 1] <= 0) {
                for (int i = n - 1; i >= n - k; i--) {
                    product *= arr[i];
                }
                return product;
            }

            // Case B: If there's a positive number, greedily multiply the largest one first
            product *= arr[right];
            right--;
            k--;
        }

        // 3. Since k is now even, greedily choose pairs from left or right ends
        while (k > 0) {
            int leftProduct = arr[left] * arr[left + 1];
            int rightProduct = arr[right] * arr[right - 1];

            if (leftProduct > rightProduct) {
                product *= leftProduct;
                left += 2;
            } else {
                product *= rightProduct;
                right -= 2;
            }
            k -= 2;
        }

        return product;
    }
}
