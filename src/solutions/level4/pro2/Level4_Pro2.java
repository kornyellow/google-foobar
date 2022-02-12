package solutions.level4.pro2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

public class Level4_Pro2 {

	public static void main(String[] args) {

		if(Arrays.deepEquals(solution(2, 1), new int[][]{
			{0},
			{0}
		})) {
			System.out.println("Test 1 passed !");
		} else System.out.println("Test 1 failed !");
		if(Arrays.deepEquals(solution(5, 3), new int[][]{
			{0, 1, 2, 3, 4, 5},
			{0, 1, 2, 6, 7, 8},
			{0, 3, 4, 6, 7, 9},
			{1, 3, 5, 6, 8, 9},
			{2, 4, 5, 7, 8, 9}
		})) {
			System.out.println("Test 2 passed !");
		} else System.out.println("Test 2 failed !");
		if(Arrays.deepEquals(solution(4, 4), new int[][]{
			{0},
			{1},
			{2},
			{3}
		})) {
			System.out.println("Test 3 passed !");
		} else System.out.println("Test 3 failed !");
	}

	public static int keys = 0;
	public static Set<Integer> permutation = new HashSet<>();
	public static Map<Integer, Set<Integer>> key_remove = new HashMap<>();

	public static int[][] solution(int num_buns, int num_required) {

		permutation = new HashSet<>();
		key_remove = new HashMap<>();
		keys = 0;

		for (int i = 0; i < num_buns; i++)
			key_remove.put(i, new HashSet<>());

		getPermutation(0, num_buns, num_required - 1);
		int total_keys = keys;

		int[][] keys_bunnies = new int[num_buns][];

		for (int bunny = 0; bunny < num_buns; bunny++) {

			Set<Integer> keys_to_remove = key_remove.get(bunny);
			keys_bunnies[bunny] = new int[total_keys - keys_to_remove.size()];

			int keys = 0;
			for (int key = 0; key < total_keys; key++) {

				int index = total_keys - key - 1;
				if (!keys_to_remove.contains(index)) {

					keys_bunnies[bunny][keys] = key;
					keys++;
				}
			}
		}

		return keys_bunnies;
	}

	private static void getPermutation(int start, int num, int required) {

		if (required == 0) {

			for (int permute : permutation)
				key_remove.get(permute).add(keys);

			keys++;

			return;
		}

		for (int i = start; i < num; i++) {
			permutation.add(i);
			getPermutation(i + 1, num, required - 1);
			permutation.remove(i);
		}
	}
}
