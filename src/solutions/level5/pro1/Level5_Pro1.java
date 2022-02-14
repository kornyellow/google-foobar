package solutions.level5.pro1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class Level5_Pro1 {

	public static void main(String[] args) {

		if(Objects.equals(solution("5"),
			"19")) {
			System.out.println("Test 1 passed !");
		} else System.out.println("Test 1 failed !");
		if(Objects.equals(solution("77"),
			"4208")) {
			System.out.println("Test 2 passed !");
		} else System.out.println("Test 2 failed !");
	}

	public static String solution(String s) {

		BigInteger answer = calculation(new BigInteger(s));
		return answer.toString();
	}

	public static BigInteger calculation(BigInteger integer) {

		if(integer.equals(BigInteger.ZERO)) return BigInteger.ZERO;

		BigInteger integer_sqrt = SQRT2.subtract(BigDecimal.ONE).multiply(new BigDecimal(integer)).toBigInteger();

		return integer.multiply(integer_sqrt).
			add(integer.multiply(integer.add(BigInteger.ONE)).shiftRight(1)).
			subtract(integer_sqrt.multiply(integer_sqrt.add(BigInteger.ONE)).shiftRight(1)).
			subtract(calculation(integer_sqrt));
	}

	private static final BigDecimal SQRT2 = new BigDecimal("1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605714701095599716059702745345968620147285174186408891986095523292304843087143214508397626036279952514079896872533965463318088296406206152583523950547");
}
