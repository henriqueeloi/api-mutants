package br.com.mercadolivre.apimutants.modal;

import java.util.regex.Pattern;

import br.com.mercadolivre.apimutants.exception.InputDnaException;

public class DNASequence {
		
	private static final char[] MUTANT_DNA_SEQUENCES = {'A', 'C', 'G', 'T'};

	public DNASequence() {}
	
	public DNASequence(String[] dna) {
		super();
		this.dna = dna;
	}

	private String[] dna;
	
	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}			

	public boolean sequenceContais(char lastCharacter) {
		for (char mutantDnaSequence : MUTANT_DNA_SEQUENCES) {
			if(mutantDnaSequence == lastCharacter)
				return true;
		}
		return false;
	}

	public boolean validSequenceCount(int sequenceCount) {
		if(sequenceCount == 4)
			return true;
		
		return false;
	}
	
	public char[][] parseDnaSequence() throws InputDnaException{
		
		char[][] dnaSecuence;
		
		int dnaSecuenceRange = dna.length;
		Pattern pattern = Pattern.compile("[atcg]+", Pattern.CASE_INSENSITIVE);
		
		dnaSecuence = new char[dnaSecuenceRange][dnaSecuenceRange];
		
		for (int range = 0; range < dnaSecuenceRange ; range++) {
			
				if(dna[range].length() != dnaSecuenceRange) {
					throw new InputDnaException("The length of every DNA secuences has to be equal to the number of secuences");
				} else if(!pattern.matcher(dna[range]).matches()){
					throw new InputDnaException("The characters provided in the secuence are invalid. The only valid characters are A, T, G and C.");
				} else {
					dnaSecuence[range] = dna[range].toUpperCase().toCharArray();
				}
		}
			
		return dnaSecuence;
	}


}
