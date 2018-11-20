package br.com.mercadolivre.apimutants.modal;

import br.com.mercadolivre.apimutants.exception.InputDnaException;

public abstract class ReadDnaDirection {
	
	protected ReadDnaDirection otherDirection;
	
	public ReadDnaDirection() {}
	
	public ReadDnaDirection(ReadDnaDirection otherDirection) {
		this.otherDirection = otherDirection;
	}
	
	public abstract int calcSequence(DNASequence dnaSequence) throws InputDnaException;
		
	protected int calcSequenceOtherDirection(DNASequence dnaSequence) throws InputDnaException {
		if(otherDirection == null) return 0;
		return otherDirection.calcSequence(dnaSequence);
	}
}
