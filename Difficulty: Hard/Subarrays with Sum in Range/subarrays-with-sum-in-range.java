class Solution {
	public int countSubarray(int[] arr, int l, int r) {
		int i = 0, sum = 0, c1 = 0;
		for (int j = 0; j < arr.length; j++) {
			sum += arr[j];
			while (sum > r) {
				sum -= arr[i++];
			}
			c1 += j - i + 1;
		}
		i = 0;
		sum = 0;
		int c2 = 0;
		for (int j = 0; j < arr.length; j++) {
			sum += arr[j];
			while (sum > l - 1) {
				sum -= arr[i++];
			}
			
			c2 += j - i + 1;
		}
		
		return c1 - c2;
	}
}
