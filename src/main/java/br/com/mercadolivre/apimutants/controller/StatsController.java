package br.com.mercadolivre.apimutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.apimutants.modal.Stats;
import br.com.mercadolivre.apimutants.service.StatsService;

@RestController("stats")
public class StatsController {
	
	@Autowired
	private StatsService service;

	@GetMapping
	public Stats getStatics() {
		
		Stats stats = service.getStats();
		return stats;
		
	}
	
}
