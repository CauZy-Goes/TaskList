package model.entities.people;

import java.util.ArrayList;
import java.util.List;

public class PeopleList<T extends People> {

	List<T> peopleList = new ArrayList<>();
	
	public List<T> getPeopleList(){
		return peopleList;
	}

	public void setPeopleList(List<T> peopleList) {
		this.peopleList = peopleList;
	}
	
	
}
