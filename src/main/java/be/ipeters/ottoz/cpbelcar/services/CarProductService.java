package main.java.be.ipeters.ottoz.cpbelcar.services;

import java.util.List;

import main.java.be.ipeters.ottoz.cpbelcar.domain.CarProduct;
import main.java.be.ipeters.ottoz.cpbelcar.mappers.CarProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarProductService implements CrudService<CarProduct, Integer>{
	@Autowired
	private CarProductMapper cpMapper;
	
	@Override
	public void save(CarProduct entity) {
//		cpMapper ;
		
	}

	@Override
	public CarProduct findById(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<CarProduct> findAllById(Integer key) {
		return cpMapper.getAllProductsWithCarId(key);
	}
	@Override
	public List<CarProduct> findAll() {
		// TODO Auto-generated method stub
		return cpMapper.findAll();
	}

	@Override
	public void deleteById(Integer key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CarProduct entity) {
		// TODO Auto-generated method stub
		
	}

}
