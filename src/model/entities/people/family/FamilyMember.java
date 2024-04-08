package model.entities.people.family;

import model.entities.people.People;

public class FamilyMember extends People {

	private String FamilyPosition;

	public FamilyMember(String name, Integer age, String familyPosition) {
		super(name, age);
		FamilyPosition = familyPosition;
		id = idCounter++;
	}

	public String getFamilyPosition() {
		return FamilyPosition;
	}

	public void setFamilyPosition(String familyPosition) {
		FamilyPosition = familyPosition;
	}
	
	@Override
	public String toString() {
		return id + " " + name; 
	}
	
}
