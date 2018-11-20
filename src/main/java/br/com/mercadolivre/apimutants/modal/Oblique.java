package br.com.mercadolivre.apimutants.modal;

import br.com.mercadolivre.apimutants.exception.InputDnaException;

public class Oblique extends ReadDnaDirection{

	public Oblique(ReadDnaDirection otherDirection) {
		super(otherDirection);
	}
	
	public Oblique() {}
	
	@Override
	public int calcSequence(DNASequence dnaSequence) throws InputDnaException {
		char[][] dna = dnaSequence.parseDnaSequence();
		
		char lastCharacter = 0;		
		char currentCharacter;
		int sequenceCount = 1;
		int totalSequences = 0;
		
//		LOGGER.info("------ Horizontal read");				
		for (int cel = 0; cel < dna.length; cel++) {
																
			currentCharacter = dna[cel][cel];
			
			if(lastCharacter == currentCharacter) {
				sequenceCount ++;
				if(dnaSequence.validSequenceCount(sequenceCount)) {
					sequenceCount = 0;
					
					if(dnaSequence.sequenceContais(lastCharacter))
						totalSequences++;
					
				}
			} else {
				sequenceCount = 1;
			}
			lastCharacter = dna[cel][cel];			
		}
							
		return totalSequences;
	}

}
