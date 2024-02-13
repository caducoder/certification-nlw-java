package com.rocketseat.certification.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.certification.dto.VerifyHasCertificationDTO;
import com.rocketseat.certification.repository.CertificationStudentRepository;

@Service
public class VerifyIfHasCertificationService {
	
	@Autowired
	private CertificationStudentRepository certificationStudentRepository;

	public boolean execute(VerifyHasCertificationDTO dto) {
		var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
		
		if(!result.isEmpty()) {
			return true;
		}
		
		return false;
	}
}
