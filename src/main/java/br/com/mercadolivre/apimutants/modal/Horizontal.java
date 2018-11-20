package br.com.mercadolivre.apimutants.modal;

import br.com.mercadolivre.apimutants.exception.InputDnaException;

public class Horizontal extends ReadDnaDirection {
	
	public Horizontal(ReadDnaDirection otherDirection) {
		super(otherDirection);
	}
	
	public Horizontal() {
	}

	@Override
	public int calcSequence(DNASequence dnaSequence) throws InputDnaException {
		char[][] dna = dnaSequence.parseDnaSequence();
		char lastCharacter = 0;		
		char currentCharacter;
		int sequenceCount = 1;
		int totalSequences = 0; 
		
//		LOGGER.info("------ Horizontal read");		
		for (int row = 0; row < dna.length; row++) {
			for (int col = 0; col < dna.length; col++) {
				currentCharacter = dna[row][col];
				
				if(lastCharacter == currentCharacter) {
					sequenceCount ++;
					if(dnaSequence.validSequenceCount(sequenceCount)) {
						sequenceCount = 0;
						
						if(dnaSequence.sequenceContais(lastCharacter)) {
							totalSequences ++;
						}
							
					}
				} else {
					sequenceCount = 1;
				}
				lastCharacter = dna[row][col];
				
			}
			lastCharacter = 0;
			sequenceCount = 1;
			
		}
		return totalSequences;
	}

}
