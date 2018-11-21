package br.com.mercadolivre.apimutants.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.apimutants.exception.IsNotMutantException;
import br.com.mercadolivre.apimutants.modal.DNASequence;
import br.com.mercadolivre.apimutants.modal.Human;
import br.com.mercadolivre.apimutants.modal.ValidateMutant;
import br.com.mercadolivre.apimutants.repository.HumanRepository;

@Service
public class MutantService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MutantService.class);
	
	@Autowired
	private HumanRepository humanRepository;
	
	public void validIsMutant(DNASequence dna) throws Exception {
		
		ValidateMutant validateMutant = new ValidateMutant();
		
		boolean isMutant = validateMutant.isMutant(dna);
		saveHuman(dna, isMutant);
		
		if(!isMutant) {
			LOGGER.info("Is Human");
			throw new IsNotMutantException("Is not Mutant");
		}
		
		LOGGER.info("Is Mutant");
	}

	private void saveHuman(DNASequence dna, boolean isMutant) {
		Human human = new Human(String.join("", dna.getDna()), isMutant);
		humanRepository.save(human);
	}
	
	
}
