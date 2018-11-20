package br.com.mercadolivre.apimutants.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import br.com.mercadolivre.apimutants.modal.Mutant;

@Repository
public class MutantRepository implements BaseRepository<Mutant, String>{

	@Autowired
	private DynamoDBMapper mapper;
	
	@Override
	public void save(Mutant entity) {
		mapper.save(entity);
	}

	@Override
	public int count() {
		return mapper.count(Mutant.class, new DynamoDBScanExpression());
	}
			
	@Override
	public Mutant findOne(String id) {
		return mapper.load(Mutant.class, id);
	}	
	
}
