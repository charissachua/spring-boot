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
import io.charissachua.loanapp.model.Applicant;
import io.charissachua.loanapp.repository.ApplicantRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ApplicantController {
	@Autowired
	private ApplicantRepository applicantRepository;

	@GetMapping("/applicants")
	public List<Applicant> getAllApplicants() {
		return applicantRepository.findAll();
	}

	@GetMapping("/applicants/{id}")
	public ResponseEntity<Applicant> getApplicantById(@PathVariable(value = "id") Long applicantId)
			throws ResourceNotFoundException {
				Applicant applicant = applicantRepository.findById(applicantId)
				.orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));
		return ResponseEntity.ok().body(applicant);
	}

	@PostMapping("/applicants")
	public Applicant createApplicant(@Valid @RequestBody Applicant applicant) {
		return applicantRepository.save(applicant);
	}

}
