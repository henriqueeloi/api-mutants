package br.com.mercadolivre.apimutants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.mercadolivre.apimutants.repository.HumanRepository;
import br.com.mercadolivre.apimutants.service.StatsService;
import junit.framework.TestCase;

import br.com.mercadolivre.apimutants.modal.Stats;

@RunWith(SpringJUnit4ClassRunner.class)
public class StatsServiceTest {

	@InjectMocks
	private StatsService service;

	@Mock
	private HumanRepository humanRepository;

	@Test
	public void testStatsShouldReturnNotNull() {
		
		boolean isMutant = true;
		boolean isHuman = false;
		
		Mockito.when(humanRepository.count(isMutant)).thenReturn(1);
		Mockito.when(humanRepository.count(isHuman)).thenReturn(12);

		Stats stats = service.getStats();

		TestCase.assertNotNull(stats);
	}
	
	@Test
	public void rateShouldReturnAValidValue() {
		
		boolean isMutant = true;
		boolean isHuman = false;
		
		Mockito.when(humanRepository.count(isMutant)).thenReturn(12);
		Mockito.when(humanRepository.count(isHuman)).thenReturn(4);

		Stats stats = service.getStats();

		TestCase.assertNotNull(stats);
		
		TestCase.assertEquals(3.0d, stats.getRatio());
	}

}
