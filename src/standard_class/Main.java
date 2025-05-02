package standard_class;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) {
		
		// wrapper class
		
		Integer i = 10; // 오토 박싱 언박싱을 이용한다. 명시적 박싱은 deprecated 되었다.
		
		// BigInteger
		
		BigInteger bi1 = new BigInteger("100000000000000000000000");
		BigInteger bi2 = new BigInteger("100000000000000000000000");
		
		BigInteger bi3 = bi1.add(bi2); // 더하기
		BigInteger bi4 = bi1.subtract(bi2); // 빼기
		BigInteger bi5 = bi1.multiply(bi2); // 곱하기
		BigInteger bi6 = bi1.divide(bi2); // 나눗셈의 몫
		BigInteger bi7 = bi1.remainder(bi2); // 나눗셈의 나머지
		
		System.out.println("bi3 = " + bi3); // 200000000000000000000000
		System.out.println("bi4 = " + bi4); // 0
		System.out.println("bi5 = " + bi5); // 10000000000000000000000000000000000000000000000
		System.out.println("bi6 = " + bi6); // 1
		System.out.println("bi7 = " + bi7); // 0
		
		// BigDecimal
		
		BigDecimal bd1 = new BigDecimal("1.6");
		BigDecimal bd2 = new BigDecimal("0.1");
		
		BigDecimal bd3 = bd1.add(bd2); // 더하기
		BigDecimal bd4 = bd1.subtract(bd2); // 빼기
		BigDecimal bd5 = bd1.multiply(bd2); // 곱하기
		BigDecimal bd6 = bd1.divide(bd2); // 나누기
		
		System.out.println("bd3 = " + bd3); // 1.7
		System.out.println("bd4 = " + bd4); // 1.5
		System.out.println("bd5 = " + bd5); // 0.16
		System.out.println("bd6 = " + bd6); // 16
		
		
	}
}
