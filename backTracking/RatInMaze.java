package backTracking;

/**Optimize code
 * CodingNinja: Rat In A Maze
 * */

import java.util.ArrayList;

public class RatInMaze {

	public static ArrayList<String> findPaths(int[][] arr, int n) {
		int[][] visited = new int[n][n];	
		ArrayList<String> paths = new ArrayList<>();
		StringBuilder path = new StringBuilder();
		int[] xarr = { 1, 0, 0, -1 };
		int[] yarr = { 0, -1, 1, 0 };
		findPath(arr, paths, path, visited, 0, 0, xarr, yarr);
		return paths;
	}

	static void findPath(int[][] arr, ArrayList<String> paths, StringBuilder path, int[][] visited, int x, int y,
			int[] xarr, int[] yarr) {
		char[] chararr = { 'D', 'L', 'R', 'U' };
		if (x >= arr.length || y >= arr.length || x < 0 || y < 0 || arr[x][y] == 0 || visited[x][y] == 1)
			return;
		if ((x == arr.length - 1) && (y == arr.length - 1)) {
			paths.add(path.toString());
			return;
		}
		visited[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			findPath(arr, paths, path.append(chararr[i]), visited, x + xarr[i], y + yarr[i], xarr, yarr);
			path.deleteCharAt(path.length() - 1);
		}

		visited[x][y] = 0;
	}

}
