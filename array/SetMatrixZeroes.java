package array;

/**
 * LeetCode: 73. Set Matrix Zeroes 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 */

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int c = matrix[0].length;
		int r = matrix.length;
		boolean col = false;
		for (int i = 0; i < r; i++) {
			if (matrix[i][0] == 0)
				col = true;
			for (int j = 1; j < c; j++)
				if (matrix[i][j] == 0)
					matrix[i][0] = matrix[0][j] = 0;
		}
		for (int i = r - 1; i >= 0; i--) {
			for (int j = c - 1; j >= 1; j--)
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			if (col)
				matrix[i][0] = 0;
		}
	}

}
