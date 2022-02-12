package solutions.level1.pro1;

public class Level1_Pro1 {

	public static void main(String[] args) {

		if(solution("abccbaabccba")
			== 2) {
			System.out.println("Test 1 passed !");
		} else System.out.println("Test 1 failed !");
		if(solution("abcabcabcabc")
			== 4) {
			System.out.println("Test 2 passed !");
		} else System.out.println("Test 2 failed !");
	}

	public static int solution(String s) {

		int answer = -1;
		int length = s.length();

		for (int i = length; i > 0; i--) {

			int n = length / i;

			if (n * i == length) {

				boolean is_valid = true;
				String part = s.substring(0, n);

				for (int j = 1; j < i; j++) {

					if (!s.substring(j * n, j * n + n).equals(part)) {

						is_valid = false;
						break;
					}
				}

				if (is_valid) {

					answer = i;
					break;
				}
			}
		}
		return answer;
	}
}
