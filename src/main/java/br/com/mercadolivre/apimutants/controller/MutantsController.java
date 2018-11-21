package br.com.mercadolivre.apimutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.apimutants.modal.DNASequence;
import br.com.mercadolivre.apimutants.service.MutantService;

@RestController("/mutant")
public class MutantsController {

	@Autowired
	private MutantService mutantService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void verifyIsMutant(@RequestBody DNASequence dna) throws Exception {
		mutantService.validIsMutant(dna);
	}
}
