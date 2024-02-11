package com.rocketseat.certification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification.dto.VerifyHasCertificationDTO;
import com.rocketseat.certification.services.VerifyIfHasCertificationService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private VerifyIfHasCertificationService verifyIfHasCertificationService;

	@PostMapping("/verify-if-has-certification")
	public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
		System.out.println(verifyHasCertificationDTO);
		var result = this.verifyIfHasCertificationService.execute(verifyHasCertificationDTO);
		if(result) {
			return "Usuário já fez a prove";
		}
		return "Usuário pode fazer a prova";
	}
}
