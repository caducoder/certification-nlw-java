package com.rocketseat.certification.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification.dto.AlternativesResultDTO;
import com.rocketseat.certification.dto.QuestionResultDTO;
import com.rocketseat.certification.models.Alternatives;
import com.rocketseat.certification.models.Question;
import com.rocketseat.certification.repository.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;

	@GetMapping("/technology/{technology}")
	public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){
		List<Question> result = this.questionRepository.findByTechnology(technology);
		List<QuestionResultDTO> toMap = result.stream()
				.map(question -> mapToDTO(question))
				.collect(Collectors.toList());
		return toMap;
	}
	
	static QuestionResultDTO mapToDTO(Question question) {
		var questionResultDTO = QuestionResultDTO.builder()
				.id(question.getId())
				.technology(question.getTechnology())
				.description(question.getDescription())
				.build();
		
		List<AlternativesResultDTO> alternativesResultDTOs = question.getAlternatives()
				.stream().map(alternative -> mapAlternativeDTO(alternative))
				.collect(Collectors.toList());
		
		questionResultDTO.setAlternatives(alternativesResultDTOs);
		
		return questionResultDTO;
	}
	
	static AlternativesResultDTO mapAlternativeDTO(Alternatives alternatives) {
		return AlternativesResultDTO.builder()
				.id(alternatives.getId())
				.description(alternatives.getDescription()).build();
	}
}
