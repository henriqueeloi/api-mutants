package br.com.mercadolivre.apimutants.modal;

import br.com.mercadolivre.apimutants.exception.InputDnaException;

public class ValidateMutant {
		
	int totalSequences = 0;
	
	private void calcDnaSequences(DNASequence dnaSequence, ReadDnaDirection readDnaDirection) throws InputDnaException {
		totalSequences += readDnaDirection.calcSequence(dnaSequence);
	}
	
	public boolean isMutant(DNASequence dnaSequence) throws InputDnaException {
		
		ReadDnaDirection vertical = new Vertical();
		ReadDnaDirection horizontal = new Horizontal();
		ReadDnaDirection oblique = new Oblique();
		
		this.calcDnaSequences(dnaSequence, vertical);
		this.calcDnaSequences(dnaSequence, horizontal);
		this.calcDnaSequences(dnaSequence, oblique);
				
		return this.totalSequences >= 2;		
	}
		
}
