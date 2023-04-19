package io.charissachua.loanapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.charissachua.loanapp.model.LoanRequest;

@Repository
public interface LoanRequestRepository extends JpaRepository<LoanRequest, Long>{

}
