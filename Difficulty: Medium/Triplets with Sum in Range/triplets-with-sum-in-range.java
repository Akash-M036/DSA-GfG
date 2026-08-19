//  class Solution {
//      public int countTriplets(int[] arr, int l, int r) {
//          Arrays.sort(arr);
//          int left =0;
//          int sum =0;
//          for(int right =0; right< arr.length;right++){
//              while(right-left>3 || sum>r){
//                  sum-=arr[i];
//                  left++;
//              }
//          }
//      }
//  }
// 	int[][][] dp;
// 	public int countTriplets(int[] arr, int l, int r) {
// 		int n = arr.length;
// 		int maxsum = 0;
// 		for (int a : arr) {
// 			maxsum += a;
// 		}
// 		int limit = Math.max(maxsum, r);
// 		dp = new int[n][4][limit + 1];
// 		for (int[][] mat : dp) {
// 			for (int[] row : mat) {
// 				Arrays.fill(row, -1);
// 			}
// 		}

// 		return solve(0, arr, 0, l, r, 0);

// 	}
// 	public int solve(int i, int[] arr, int ec, int l, int r, int sum) {
// 		if (sum > r) {
// 			return 0;
// 		}
// 		if (ec == 3) {
// 			return (sum >= l) ? 1 : 0;
// 		}
// 		if (i >= arr.length) {
// 			return 0;
// 		}
// 		if (dp[i][ec][sum] != -1) {
// 			return dp[i][ec][sum];
// 		}
// 		int pick = solve(i + 1, arr, ec + 1, l, r, sum + arr[i]);
// 		int skip = solve(i + 1, arr, ec, l, r, sum);

// 		dp[i][ec][sum] = pick + skip;
// 		return dp[i][ec][sum];

// 	}

// //}
class Solution {
    public int countTriplets(int[] arr, int l, int r)
    {int n = arr.length; int ans = 0; 
    Arrays.sort(arr); 
    for (int i = 0; i<n - 2; i++)
    {ans += countPairs(arr, i + 1, n - 1, r - arr[i]) - countPairs(arr, i + 1, n - 1, l - arr[i]-1); } 
    return ans; }
    private int countPairs(int[] arr, int left, int right, int target) {
	int cnt = 0;
	while (left<right) {
		if (arr[left]+arr[right] <= target) {
			cnt += (right - left);
			left++;
		} else {
			right--;
		}
	}
	return cnt;
}}
// class Solution {
//     int ans =0;
//     public int range(int i, int[] arr, int cnt, int l, int r,int sum,int[][][] dp){
//         if(cnt>3)
//             return 0;
//         if(sum>r){
//             return 0;
//         }
//         if(cnt==3){
//             if(sum>=l)
//              ans++;
//             return 0;
//         }
//         if(i>=arr.length)
//             return 0;

//         int take = arr[i]+range(i+1,arr,cnt+1,l,r,sum+arr[i],dp);
//       int dont = range(i+1,arr,cnt,l,r,sum,dp);
//       if(take<=r )
//         return dp[i][cnt][sum]= take;
//     return dp[i][cnt][sum]=dont;

//     }
//     public int countTriplets(int[] arr, int l, int r) {
//         int maxsum= 0;
//         for(int a : arr){
//             maxsum +=a;
//         }
//         int[][][] dp = new int[arr.length][4][maxsum+1];
//         for(int[][] x : dp){
//             for(int[] a : x){
//             Arrays.fill(a,-1);
//             }
//         }
//         range(0,arr,0,l,r,0,dp);
//         return ans;
//     }
// }

// class Solution {
//     int ans =0;
//     public int range(int i, int[] arr, int cnt, int l, int r){
//         if(i>=arr.length)
//             return 0;
//         if(cnt>3)
//             return 0;
//         if(cnt==3){
//             ans++;
//             return 0;
//         }
//         int take = arr[i]+range(i+1,arr,cnt+1,l,r);
//         int dont = range(i+1,arr,cnt,l,r);
//         if(take<=r && take>=l)
//             return take;
//         return dont;
//     }
//     public int countTriplets(int[] arr, int l, int r) {
//         range(0,arr,0,l,r);
//         return ans;
//     }
// }
