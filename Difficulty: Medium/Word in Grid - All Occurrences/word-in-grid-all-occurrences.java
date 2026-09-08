class Solution {
	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	public boolean find(int i, int j, char[][] mat, String word) {
		
		 		if (i >= mat.length || j >= mat[0].length || i<0 || j<0)
		 			return false;
		// 		if (vis[i][j] != null)
		// 			return vis[i][j];
// 		boolean ans1 = false;
// 		boolean ans2 = false;
// 		boolean ans3 = false;
// 		boolean ans4 = false;
// 		boolean ans5 = false;
// 		boolean ans6 = false;
// 		boolean ans7 = false;
// 		boolean ans8 = false;
		//	vis[i][j]=true;
		int len = word.length();
		int n = mat.length;
		int m = mat[i].length;
		boolean ans1 = true;
		for (int k = 0; k < len; k++) {
			int next_row = i + k;
			if (next_row >= n || mat[next_row][j] != word.charAt(k)) {
				ans1 = false;
				break;
			}
		}
		
		boolean ans2 = true;
		for (int k = 0; k < len; k++) {
			int next_row = i - k;
			if (next_row < 0 || mat[next_row][j] != word.charAt(k)) {
				ans2 = false;
				break;
			}
		}
		
		boolean ans3 = true;
		for (int k = 0; k < len; k++) {
			int next_col = j + k;
			if (next_col >= m || mat[i][next_col] != word.charAt(k)) {
				ans3 = false;
				break;
			}
		}
		
		boolean ans4 = true;
		for (int k = 0; k < len; k++) {
			int next_col = j - k;
			if (next_col < 0 || mat[i][next_col] != word.charAt(k)) {
				ans4 = false;
				break;
			}
		}
		
		boolean ans5 = true;
		for (int k = 0; k < len; k++) {
			int next_row = i + k;
			int next_col = j + k;
			if (next_row >= n || next_col >= m || mat[next_row][next_col] != word.charAt(k)) {
				ans5 = false;
				break;
			}
		}
		
		boolean ans6 = true;
		for (int k = 0; k < len; k++) {
			int next_row = i - k;
			int next_col = j - k;
			if (next_row < 0 || next_col < 0 || mat[next_row][next_col] != word.charAt(k)) {
				ans6 = false;
				break;
			}
		}
		
		boolean ans7 = true;
		for (int k = 0; k < len; k++) {
			int next_row = i + k;
			int next_col = j - k;
			if (next_row >= n || next_col < 0 || mat[next_row][next_col] != word.charAt(k)) {
				ans7 = false;
				break;
			}
		}
		
		boolean ans8 = true;
		for (int k = 0; k < len; k++) {
			int next_row = i - k;
			int next_col = j + k;
			if (next_row < 0 || next_col >= m || mat[next_row][next_col] != word.charAt(k)) {
				ans8 = false;
				break;
			}
		}
		
		return (ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8);
		//	return true;

		
	}
	public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
		// code here
		//	Boolean[][] vis = new Boolean[mat.length][mat[0].length];
		for (int i = 0; i<mat.length; i++) {
			for (int j = 0; j<mat[i].length; j++) {
				if (find(i, j, mat, word)) {
					ArrayList<Integer> arr = new ArrayList<>();
					arr.add(i);
					arr.add(j);
					ans.add(new ArrayList(arr));
				}
			}
		}
		return ans;
	}
};
