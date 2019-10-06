package main.java.be.ipeters.ottoz.cpbelcar.services;

import java.util.List;

import main.java.be.ipeters.ottoz.cpbelcar.domain.Person;
import main.java.be.ipeters.ottoz.cpbelcar.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements CrudService<Person, Integer>{

	@Autowired
	private PersonMapper personMapper;
	
	@Override
	public void save(Person entity) {
		personMapper.insert(entity);
		
	}

	@Override
	public Person findById(Integer key) {
		// TODO Auto-generated method stub
		return personMapper.findById(key);
	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return personMapper.findAll();
	}

	@Override
	public void deleteById(Integer key) {
		personMapper.deleteById(key);
		
	}

	@Override
	public void update(Person entity) {
		personMapper.update(entity);
		
	}

}
