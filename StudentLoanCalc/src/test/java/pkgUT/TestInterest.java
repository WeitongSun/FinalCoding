package pkgUT;
import static org.junit.Assert.*;


import org.apache.poi.ss.formula.functions.*;
import org.junit.Test;


public class TestInterest {
	

	@Test
	public void test() {
		double loanAmount = 200000;
		double InterestRate = 0.07;
		double interest = loanAmount * (double)(InterestRate / 12);
		
		double interestExpected = 1166.67;
		
		assertEquals(interestExpected, interest, 0.01);
	}

}
