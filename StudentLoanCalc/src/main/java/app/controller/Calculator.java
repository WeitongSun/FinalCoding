package app.controller;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Calculator {
	
	private double LoanAmount;
	
	private double AdditionalPayment;
	
	private int NumOfYears;
	
	private double InterestRate;
	
	public Calculator(double LoanAmount, double AdditionalPayment, int NOfYears, double IRate) {
		this.LoanAmount = LoanAmount;
		this.InterestRate = IRate;
		this.NumOfYears = NOfYears;
		this.AdditionalPayment = AdditionalPayment;
		
	}

	public double getAdditionalPayment() {
		return AdditionalPayment;
	}

	public void setAdditionalPayment(double additionalPayment) {
		AdditionalPayment = additionalPayment;
	}

	public double getNumOfYears() {
		return NumOfYears;
	}

	public void setNumOfYears(int d) {
		NumOfYears = d;
	}

	public double getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}

	public void setLoanAmount(double loanAmount) {
		LoanAmount = loanAmount;
	}
	
	public double CalculatePMT()  {
		double r = InterestRate / 12;
		double n = NumOfYears * 12;
		double p = LoanAmount;
		double f = 0;
		boolean t = false;
		
		double Payment = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		return Payment;
	}
		
	public double CalculateInterest(double loan) {
		double interest = loan * (double)(InterestRate / 12);
		return interest;
	}
	
	public double CalculateTotalPayment() {
		double ir = 0;
		double PPMT = 0;
		double pv = LoanAmount;
		
		do {
			double PMT = CalculatePMT();
			
			PPMT = PMT - CalculateInterest(pv);
			
			pv = pv - (PPMT + AdditionalPayment);
			
			ir = ir + (PMT-PPMT);
			
			System.out.println(PPMT + AdditionalPayment);
			
		}while(pv > PPMT + AdditionalPayment);
		
		double APInterest = CalculateInterest(pv);
		double TotalPayment = ir + APInterest + LoanAmount;
		
		return TotalPayment;
	}
	
	public double CalTotalInterest() {
		double TotalInterest = CalculateTotalPayment() - LoanAmount;
		return TotalInterest;
	}
}