package io.charissachua.loanapp.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.charissachua.loanapp.exception.ResourceNotFoundException;
import io.charissachua.loanapp.model.LoanRequest;
import io.charissachua.loanapp.repository.LoanRequestRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class LoanRequestController {
	@Autowired
	private LoanRequestRepository loanRequestRepository;

	@GetMapping("/loanRequests")
	public List<LoanRequest> getAllLoanRequests() {
		return loanRequestRepository.findAll();
	}

	@GetMapping("/loanRequests/{id}")
	public ResponseEntity<LoanRequest> getLoanRequestById(@PathVariable(value = "id") Long loanRequestId)
			throws ResourceNotFoundException {
				LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId)
				.orElseThrow(() -> new ResourceNotFoundException("LoanRequest not found for this id :: " + loanRequestId));
		return ResponseEntity.ok().body(loanRequest);
	}

	@PostMapping("/loanRequests")
	public LoanRequest createLoanRequest(@Valid @RequestBody LoanRequest loanRequest) {
		System.out.println("loanRequest="+loanRequest);
		return loanRequestRepository.save(loanRequest);
	}

}
