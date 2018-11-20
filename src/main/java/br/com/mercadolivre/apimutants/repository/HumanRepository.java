package br.com.mercadolivre.apimutants.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

import br.com.mercadolivre.apimutants.modal.Human;

@Repository
public class HumanRepository implements BaseRepository<Human, String>{

	@Autowired
	private DynamoDBMapper mapper;
	
	@Override
	public void save(Human entity) {
		mapper.save(entity);
	}

	@Override
	public int count() {		
		return mapper.count(Human.class, new DynamoDBScanExpression());
	}
	
	public int count(boolean isMutant) {
		 
		DynamoDBScanExpression expression = new DynamoDBScanExpression()
	            .withFilterConditionEntry("isMutant",
	                    new Condition().withComparisonOperator(ComparisonOperator.EQ).withAttributeValueList(new AttributeValue().withBOOL(isMutant)));
	    List<Human> humans = mapper.scan(Human.class, expression);
	 
	    return humans.size();
	}
		
	
	@Override
	public Human findOne(String id) {
		return mapper.load(Human.class, id);
	}	
		
	public DynamoDBSaveExpression buildDynamoDBSaveExpression(Human human) {
		DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expected = new HashMap<>();
		expected.put("humanId", new ExpectedAttributeValue(new AttributeValue(human.getId()))
				.withComparisonOperator(ComparisonOperator.EQ));
		saveExpression.setExpected(expected);
		return saveExpression;
	}
	
}
