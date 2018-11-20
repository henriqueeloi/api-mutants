package br.com.mercadolivre.apimutants;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mercadolivre.apimutants.modal.DNASequence;
import br.com.mercadolivre.apimutants.modal.ValidateMutant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VarifyMutantDNA {
	
	@Test
	public void mustBeMutant() throws Exception {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

		DNASequence dnaSequence = new DNASequence();
		dnaSequence.setDna(dna);
		
		ValidateMutant validateMutant = new ValidateMutant();
		boolean isMutant = validateMutant.isMutant(dnaSequence);
				
		assertThat("Is true", isMutant == true);
	}
	
	@Test
	public void mustBeHuman() throws Exception {
		String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};

		DNASequence dnaSequence = new DNASequence();
		dnaSequence.setDna(dna);
		
		ValidateMutant validateMutant = new ValidateMutant();
		boolean isMutant = validateMutant.isMutant(dnaSequence);
		
		assertThat("Is not true", isMutant == false);
	}
	
	@Test
	public void mustBeMutnatVerticalSequence() throws Exception {
		String[] dna = { 
				"ATGCGA",
				"AAGTGC",
				"ATGTTT",
				"AGGCGG",
				"ACGTCA",
				"TCACTG"};

		DNASequence dnaSequence = new DNASequence();
		dnaSequence.setDna(dna);
		
		ValidateMutant validateMutant = new ValidateMutant();
		boolean isMutant = validateMutant.isMutant(dnaSequence);
		
		assertThat("Is true", isMutant == true);
	}
	
}
