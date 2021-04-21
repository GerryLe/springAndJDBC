package cn.itcast.service;

import java.util.List;

import cn.itcast.bean .Person;

public interface PersonService {
        
	//处理冲突
	public void delete(Integer personId);
	public Person getPerson(Integer personId);
	public List<Person> getPersons();
	public void save(Person person);
	public void update(Person person);
}
