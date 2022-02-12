package solutions.level2.pro1;

import java.math.BigInteger;
import java.util.Objects;

public class Level2_Pro1 {

	public static void main(String[] args) {

		if(Objects.equals(solution(new int[]{2, 0, 2, 2, 0}),
			"8")) {
			System.out.println("Test 1 passed !");
		} else System.out.println("Test 1 failed !");
		if(Objects.equals(solution(new int[]{-2, -3, 4, -5}),
			"60")) {
			System.out.println("Test 2 passed !");
		} else System.out.println("Test 2 failed !");
	}

	public static String solution(int[] xs) {

		if (xs.length == 1) return String.valueOf(xs[0]);

		BigInteger maximum = BigInteger.valueOf(0);
		for (int i = 0; i < xs.length; i++) {

			if (xs[i] == 0) continue;

			BigInteger sum = BigInteger.valueOf(xs[i]);
			int least_negative = -1000;
			for (int j = 0; j < xs.length; j++) {

				if (xs[j] == 0 || j == i) continue;
				sum = sum.multiply(BigInteger.valueOf(xs[j]));
				if (xs[j] > least_negative && xs[j] < 0) least_negative = xs[j];
			}

			if (sum.compareTo(BigInteger.valueOf(0)) < 0) sum = sum.divide(BigInteger.valueOf(least_negative));
			if (sum.compareTo(maximum) > 0) maximum = sum;
		}
		return maximum.toString();
	}
}
