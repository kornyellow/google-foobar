package solutions.level3.pro3;

import classes.FIFOQueue;

import java.util.Arrays;

public class Level3_Pro3 {

	public static void main(String[] args) {

		if(solution(new int[][] {
			{0, 1, 1, 0},
			{0, 0, 0, 1},
			{1, 1, 0, 0},
			{1, 1, 1, 0}
			}) == 7) {
			System.out.println("Test 1 passed !");
		} else System.out.println("Test 1 failed !");
		if(solution(new int[][] {
			{0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1},
			{0, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 0, 0}
			}) == 11) {
			System.out.println("Test 2 passed !");
		} else System.out.println("Test 2 failed !");
	}

	public static int solution(int[][] map) {

		int distance = findShortestDistance(map);
		if(isShortest(map, distance)) return distance;

		int shortest = Integer.MAX_VALUE;
		for(int row = 0; row < map.length; row++) {
			for(int col = 0; col < map[row].length; col++) {

				if(map[row][col] == 1) {

					int[][] new_map = new int[map.length][map[0].length];
					for(int i = 0; i < map.length; i++)
						System.arraycopy(map[i], 0, new_map[i], 0, map[i].length);

					new_map[row][col] = 0;
					distance = findShortestDistance(new_map);
					if(isShortest(map, distance)) return distance;
					if(distance < shortest && distance != -1) shortest = distance;
				}
			}
		}
		return shortest;
	}

	public static int findShortestDistance(int[][] map) {

		if(map[0][0] == 1) return -1;

		boolean[][] is_visited = new boolean[map.length][map[0].length];
		for (boolean[] booleans : is_visited) Arrays.fill(booleans, false);

		FIFOQueue queue = new FIFOQueue();
		queue.enqueue("");
		String path = "";

		while(!isEnd(map, path)) {

			do {
				path = queue.dequeue();
				if(path == null) return -1;
			}
			while(!isVisited(is_visited, path));

			for(char d : new char[]{'U', 'D', 'L', 'R'}) {

				String path_to_add = path + d;
				if(isValid(map, path_to_add))
					queue.enqueue(path_to_add);
			}
		}

		return path.length() + 1;
	}

	public static boolean isShortest(int[][] map, int distance) {

		return map.length + map[0].length - 1 == distance;
	}

	public static boolean isVisited(boolean[][] is_visited, String moves) {

		int pos_x = 0;
		int pos_y = 0;
		for(char move : moves.toCharArray()) {

			switch (move) {
				case 'U' -> pos_y--;
				case 'D' -> pos_y++;
				case 'L' -> pos_x--;
				case 'R' -> pos_x++;
			}
		}

		if(is_visited[pos_y][pos_x]) return false;
		is_visited[pos_y][pos_x] = true;

		return true;
	}

	public static boolean isEnd(int[][] map, String moves) {

		int pos_x = 0;
		int pos_y = 0;
		for(char move : moves.toCharArray()) {

			switch (move) {
				case 'U' -> pos_y--;
				case 'D' -> pos_y++;
				case 'L' -> pos_x--;
				case 'R' -> pos_x++;
			}
		}

		if(pos_y < 0 || pos_x < 0 || pos_y > map.length - 1 || pos_x > map[0].length - 1) return false;
		return pos_y == map.length - 1 && pos_x == map[0].length - 1;
	}

	public static boolean isValid(int[][] map, String moves) {

		int pos_x = 0;
		int pos_y = 0;
		for(char move : moves.toCharArray()) {

			switch (move) {
				case 'U' -> pos_y--;
				case 'D' -> pos_y++;
				case 'L' -> pos_x--;
				case 'R' -> pos_x++;
			}
		}

		if(pos_y < 0 || pos_x < 0 || pos_y > map.length - 1 || pos_x > map[0].length - 1) return false;

		return map[pos_y][pos_x] != 1;
	}
}