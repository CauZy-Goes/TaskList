package model.entities.tasks.family;

import java.time.LocalDateTime;

import model.entities.people.family.FamilyMember;
import model.entities.tasks.Task;

public class TaskOfFamily extends Task{

	private FamilyMember familyMember;

	public TaskOfFamily(String task, LocalDateTime deadLine, FamilyMember familyMember) {
		super(task, deadLine);
		this.familyMember = familyMember;
		this.id = idCounter++;
	}
	
	public TaskOfFamily(String task, LocalDateTime deadLine,FamilyMember familyMember, int id) {
		super(task, deadLine, id);
		this.familyMember = familyMember;
	}

	public FamilyMember getFamilyMember() {
		return familyMember;
	}

	public void setFamilyMember(FamilyMember familyMember) {
		this.familyMember = familyMember;
	}
	
	@Override
	public String toString() {
		return familyMember.getName() + " is " + familyMember.getAge() + " years, need to " + id +"-" + task + " until " + deadLine;
	}
}
