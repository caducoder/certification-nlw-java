package com.rocketseat.certification.models;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificationStudent {

	private UUID id;
	private UUID studentID;
	private String technology;
	private int grade;
	List<AnswersCertifications> answersCertifications;
}
