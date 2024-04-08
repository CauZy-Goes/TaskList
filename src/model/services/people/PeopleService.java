package model.services.people;

import java.util.List;

import model.entities.people.People;
import model.entities.people.family.FamilyMember;

public interface PeopleService {
	
	void addPeople(People people);
	void removePeople(int id);
	FamilyMember filterById(int id);
	List<?> getPeopleList();
}
