package solutions.level3.pro1;

public class Level3_Pro1 {

	public static void main(String[] args) {

		if(solution(0, 3)
			== 2) {
			System.out.println("Test 1 passed !");
		} else System.out.println("Test 1 failed !");
		if(solution(17, 4)
			== 14) {
			System.out.println("Test 2 passed !");
		} else System.out.println("Test 2 failed !");
	}

	public static int solution(int start, int length) {

		int checksum = -1;
		int current = start;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {

				if (checksum == -1) checksum = current;
				else checksum ^= current;

				if (j == length - i - 1) break;
				current++;
			}
			current += i + 1;
		}

		return checksum;
	}
}
