package io.charissachua.loanapp.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.charissachua.loanapp.exception.ResourceNotFoundException;
import io.charissachua.loanapp.model.Loan;
import io.charissachua.loanapp.repository.LoanRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class LoanController {
	@Autowired
	private LoanRepository loanRepository;

	@GetMapping("/loans")
	public List<Loan> getAllLoans() {
		return loanRepository.findAll();
	}

	@GetMapping("/loans/{id}")
	public ResponseEntity<Loan> getLoanById(@PathVariable(value = "id") Long loanId)
			throws ResourceNotFoundException {
				Loan loan = loanRepository.findById(loanId)
				.orElseThrow(() -> new ResourceNotFoundException("Loan not found for this id :: " + loanId));
		return ResponseEntity.ok().body(loan);
	}

	@PostMapping("/loans")
	public Loan createLoan(@Valid @RequestBody Loan loan) {
		return loanRepository.save(loan);
	}

}
