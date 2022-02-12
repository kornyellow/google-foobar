package solutions.level3.pro2;

import java.math.BigInteger;

public class Level3_Pro2 {

	public static void main(String[] args) {

		if(solution("4")
			== 2) {
			System.out.println("Test 1 passed !");
		} else System.out.println("Test 1 failed !");
		if(solution("15")
			== 5) {
			System.out.println("Test 2 passed !");
		} else System.out.println("Test 2 failed !");
	}

	public static int solution(String n) {

		BigInteger big_int = new BigInteger(n);

		int answer = 0;

		while (big_int.compareTo(BigInteger.ONE) != 0) {

			if (big_int.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0)
				big_int = big_int.divide(BigInteger.TWO);

			else {

				if (big_int.subtract(BigInteger.ONE).
					mod(BigInteger.valueOf(4)).
					equals(BigInteger.ZERO) || big_int.equals(BigInteger.valueOf(3)))
					big_int = big_int.subtract(BigInteger.ONE);
				else
					big_int = big_int.add(BigInteger.ONE);
			}
			answer++;
		}
		return answer;
	}
}