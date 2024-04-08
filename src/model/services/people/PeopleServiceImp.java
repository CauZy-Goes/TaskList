package model.services.people;

import java.util.List;
import java.util.stream.Collectors;

import model.entities.people.People;
import model.entities.people.PeopleList;
import model.entities.people.family.FamilyMember;

public class PeopleServiceImp implements PeopleService{
	
	PeopleList<FamilyMember> peopleList = new PeopleList<>();

	@Override
	public void addPeople(People people) {
		List<FamilyMember> list = peopleList.getPeopleList();
		list.add((FamilyMember) people);
	}

	@Override
	public void removePeople(int id) {
		List<FamilyMember> list = peopleList.getPeopleList();
		list = list.stream().filter(person -> person.getId() != id).collect(Collectors.toList());
		peopleList.setPeopleList(list);
	}

	@Override
	public List<?> getPeopleList() {
		List<FamilyMember> list = peopleList.getPeopleList();
		return list;
	}

	@Override
	public FamilyMember filterById(int id) {
		List<FamilyMember> list = peopleList.getPeopleList();
		FamilyMember person = list.stream().filter(people -> people.getId() == id).findFirst().orElse(null);
		return person;
	}


	

}
