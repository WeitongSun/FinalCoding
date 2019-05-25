package pkgUT;

import static org.junit.Assert.*;


import org.apache.poi.ss.formula.functions.*;
import org.junit.Test;

public class TestPMT {

	@Test
	public void test() {
		double PMT;
		double r = 0.07 / 12;
		double n = 14 * 12;
		double p = 200000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		double PMTExpected = 1870.80;
		
		assertEquals(PMTExpected, PMT, 0.01);
		
		
		
	}

}

 

