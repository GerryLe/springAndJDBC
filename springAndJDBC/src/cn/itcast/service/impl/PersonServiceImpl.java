package cn.itcast.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Person;
import cn.itcast.service.PersonService;

//@Transactional
public class PersonServiceImpl implements PersonService {

	private JdbcTemplate jdbcTemplate;
    public PersonServiceImpl(DataSource dataSource) {
     this.jdbcTemplate=new JdbcTemplate();
	 }
	
    
    
	public void setDataSource(DataSource dataSource) {
		 this.jdbcTemplate=new JdbcTemplate(dataSource);
	}




	//@Transactional(propagation=Propagation.MANDATORY,isolation=Isolation.DEFAULT )
	@Override
	public void delete(Integer personId) {
		// TODO Auto-generated method stub
    this.jdbcTemplate.update("delete from person where id=?",new Object[]{personId},new int[]{java.sql.Types.INTEGER});
	}

	@Override
	public Person getPerson(Integer personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub j
		this.jdbcTemplate.update("insert into person(name) values(?)", new Object[]{person.getName()}, new int[]{java.sql.Types.VARCHAR});
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update person set name=? where id=?", new Object[]{person.getName(),person.getId()}, new int[]{java.sql.Types.VARCHAR,java.sql.Types.INTEGER});

	}

}
