package io.charissachua.loanapp.model;

import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_type")
public class LoanType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "loanType", cascade = CascadeType.ALL)
	private Collection<Loan> loanList;

	public LoanType(long id, String name, Collection<Loan> loanList) {
		this.id = id;
		this.name = name;
		this.loanList = loanList;
	}

	public LoanType() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLoanList(Collection<Loan> loanList) {
		this.loanList = loanList;
	}

	@Override
	public String toString() {
		return "LoanType [id=" + id + ", name=" + name + ", loanList=" + loanList + "]";
	}

}
