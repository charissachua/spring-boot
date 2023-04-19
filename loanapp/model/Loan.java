package io.charissachua.loanapp.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "interest_rate", nullable = false)
	private float interestRate;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "end_date", nullable = false)
	private Date endDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "loan_type_id", nullable = false,
        referencedColumnName = "id")
	private LoanType loanType;


	public Loan(long id, float interestRate, Date startDate, Date endDate, LoanType loanType) {
		this.id = id;
		this.interestRate = interestRate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.loanType = loanType;
	}

	public Loan() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", interestRate=" + interestRate + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", loanType=" + loanType + "]";
	}


}
