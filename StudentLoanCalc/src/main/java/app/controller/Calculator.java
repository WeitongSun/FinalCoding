package app.controller;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.apache.poi.ss.formula.functions.Finance;

public class Calculator {
	
	private double LoanAmount;
	
	private double AdditionalPayment;
	
	private int NumOfYears;
	
	private double InterestRate;
	
	public Calculator(double LoanAmount, double AdditionalPayment, int NbrOfYears, double InterestRate) {
		this.LoanAmount = LoanAmount;
		this.InterestRate = InterestRate;
		this.NumOfYears = NbrOfYears;
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
	
		
	public double CalculateInterest(double loan) {
		double monthRate = InterestRate / 12;
		double interest = loan * monthRate;
		return interest;
	}
	public double CalculatePMT()  {
		double r = InterestRate / 12;
		double n = NumOfYears * 12;
		double p = LoanAmount;
		double f = 0;
		boolean t = false;
		
		//double Payment = (p + CalculateTotalInterest()) / n;
		
		double Payment = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		return Payment;
	}
	
	public double CalculateTotalPayment() {
		double interest = 0;
		double PPMT = 0;
		double pv = LoanAmount;
		
		while(PPMT + AdditionalPayment < pv) {
			double PMT = CalculatePMT();
			PPMT = PMT - CalculateInterest(pv);
			pv -= PPMT + AdditionalPayment;
			interest += PMT-PPMT;
			System.out.println(PPMT+AdditionalPayment);
		}
		Double FinalInterest = CalculateInterest(pv);
		return interest + LoanAmount + FinalInterest;
	}
	
	public double CalculateTotalInterest() {
		double TotalInterest = CalculateTotalPayment() - LoanAmount;
		return TotalInterest;
	}
}