package br.com.mercadolivre.apimutants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.mercadolivre.apimutants.exception.IsNotMutantException;
import br.com.mercadolivre.apimutants.modal.DNASequence;
import br.com.mercadolivre.apimutants.modal.Human;
import br.com.mercadolivre.apimutants.modal.ValidateMutant;
import br.com.mercadolivre.apimutants.repository.HumanRepository;
import br.com.mercadolivre.apimutants.service.MutantService;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
public class MutantServiceTest {
	
	@InjectMocks
	private MutantService service;
	
	@Mock
	private HumanRepository humanRepository;
	
	@Test(expected = IsNotMutantException.class)
	public void DnaSequenceMustBeHuman() throws Exception {
		
		String[] dnaHuman =  new String[] { 
				  "GTGCGA", 
				  "CACTAC", 
				  "TCCTGG", 
				  "CGAAAG", 
				  "CCCGTA", 
				  "TCGCTG"};
		
		DNASequence dna = new DNASequence(dnaHuman);
		
		Human mutant = new Human(String.join("", dna.getDna()), true);
		Mockito.doNothing().when(humanRepository).save(Mockito.eq(mutant));

		service.validIsMutant(dna);
	}

	@Test
	public void DnaSequenceMustBeMutant() throws Exception {
		
		String[] dnaMutant =  new String[] { 
				  "GTGCGA", 
				  "CACTGC", 
				  "TCATGG", 
				  "CGATAG", 
				  "CCCTTA", 
				  "TCCCCG"};
		
		ValidateMutant validateMutant = new ValidateMutant();
		DNASequence dna = new DNASequence(dnaMutant);
		
		boolean isMutant = validateMutant.isMutant(dna);
				
		TestCase.assertTrue(isMutant);
	}
}
