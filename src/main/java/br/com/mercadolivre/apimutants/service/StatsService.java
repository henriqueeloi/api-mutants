package br.com.mercadolivre.apimutants.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.apimutants.modal.Stats;
import br.com.mercadolivre.apimutants.repository.HumanRepository;

@Service
public class StatsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MutantService.class);
	
	@Autowired
	private HumanRepository humanRepository;
	
	public Stats getStats(){
				
		int countMutants = humanRepository.count(true);
		int countHumans = humanRepository.count(true);
		double ratio = (countHumans != 0) ? countMutants / countHumans : 0;
		ratio = Math.round(ratio);
		
		return new Stats(countMutants, countHumans, ratio);
	}
	
}
