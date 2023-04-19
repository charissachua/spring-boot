package io.charissachua.loanapp.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_request")
public class LoanRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "amount", nullable = false)
	private int amount;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@ManyToOne
	@JoinColumn(name = "loan_id", nullable = false)
	private Loan loan;
	
	@ManyToOne
	@JoinColumn(name = "applicant_id", insertable = true, updatable = false)
	private Applicant applicant;
	
	public LoanRequest() {
		
	}
	

	
	public LoanRequest(long id, int amount, Date startDate, Loan loan, Applicant applicant) {
		this.id = id;
		this.amount = amount;
		this.startDate = startDate;
		this.loan = loan;
		this.applicant = applicant;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public String toString() {
		return "LoanRequest [id=" + id + ", amount=" + amount + ", startDate=" + startDate + ", loan=" + loan
				+ ", applicant=" + applicant + "]";
	}



	public Loan getLoan() {
		return loan;
	}



	public void setLoan(Loan loan) {
		this.loan = loan;
	}



	public Applicant getApplicant() {
		return applicant;
	}



	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
}
