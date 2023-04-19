package io.charissachua.loanapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.charissachua.loanapp.model.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long>{

}
