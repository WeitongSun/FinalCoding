package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField LoanTerm;
	
	@FXML
	private TextField AdditionalPayment;
	
	@FXML
	private TextField NbrOfYears;

	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private Label lblTotalInterest;

	
	@FXML
	private DatePicker PaymentStartDate;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		Calculator cal = new Calculator(Double.parseDouble(LoanAmount.getText()), 
		Double.parseDouble(AdditionalPayment.getText()), Integer.parseInt(NbrOfYears.getText()), 
		Double.parseDouble(InterestRate.getText()));
				
		double TotalPayment = cal.CalculateTotalPayment();
		TotalPayment = Math.round(TotalPayment * 100.00)/100.00;
		
		double TotalInterest = cal.CalculateTotalInterest();
		TotalInterest = Math.round(TotalInterest*100.00)/100.00;
				
		lblTotalPayemnts.setText(String.valueOf(TotalPayment));
		lblTotalInterest.setText(String.valueOf(TotalInterest));
			
		LocalDate localDate = PaymentStartDate.getValue();
		System.out.println(localDate);

		
	}
	
}
