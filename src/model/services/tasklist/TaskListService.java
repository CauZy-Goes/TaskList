package model.services.tasklist;

import java.util.List;

import model.entities.tasks.Task;
import model.entities.tasks.family.TaskOfFamily;

public interface TaskListService {

	void addTask(Task task);
	void removeTaskById(int id);
	boolean updateTaskById(Task task);
	List<?> getTaskList();
	List<?> getTaskListOutDeadLine();
	List<TaskOfFamily> filterByMemberFamilyId(int id);
}
