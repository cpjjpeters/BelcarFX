package main.java.be.ipeters.ottoz.cpbelcar.services;

import java.util.List;

import main.java.be.ipeters.ottoz.cpbelcar.domain.Production;
import main.java.be.ipeters.ottoz.cpbelcar.mappers.ProductionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductionService implements CrudService<Production, Integer>{

//	private Integer productionId = 0;
	@Autowired
	private ProductionMapper productionMapper;
	
	@Override
	public void save(Production entity) {
		productionMapper.insert(entity);
	}

	@Override
	public Production findById(Integer key) {
		// TODO Auto-generated method stub
		return productionMapper.findById(key);
	}

	@Override
	public List<Production> findAll() {
		// TODO Auto-generated method stub
		return productionMapper.findAll();
	}

	@Override
	public void deleteById(Integer key) {
		productionMapper.deleteById(key);
		
	}

	@Override
	public void update(Production entity) {
		productionMapper.update(entity);
	}

}
