package model.services.tasklist;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.tasks.Task;
import model.entities.tasks.TaskList;
import model.entities.tasks.family.TaskOfFamily;

public class TaskListServiceImp implements TaskListService {
	
	private TaskList<TaskOfFamily> taskList = new TaskList<>();

	@Override
	public void addTask(Task task) {
		List<TaskOfFamily> taskList = this.taskList.getTaskList();
		taskList.add((TaskOfFamily) task);
		this.taskList.setTaskList(taskList);
	}

	@Override
	public void removeTaskById(int id) {
		List<TaskOfFamily> taskList = this.taskList.getTaskList();
		taskList = taskList.stream().filter(task -> task.getId() != id).collect(Collectors.toList());
		this.taskList.setTaskList(taskList);
	}

	@Override
	public boolean updateTaskById(Task task) {
		List<TaskOfFamily> taskList = this.taskList.getTaskList();
		Task oldTask = taskList.stream().filter(oldT -> oldT.getId() == task.getId()).findFirst().orElse(null);
		
		if(oldTask != null) {
			removeTaskById(task.getId());
			addTask(task);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<TaskOfFamily> getTaskList() {
		List<TaskOfFamily> taskList = this.taskList.getTaskList();
		return taskList;
	}

	@Override
	public List<TaskOfFamily> getTaskListOutDeadLine() {
		List<TaskOfFamily> taskList = this.taskList.getTaskList();
		taskList = taskList.stream().filter(task -> task.getDeadLine().isAfter(LocalDateTime.now())).collect(Collectors.toList());
		return taskList;
	}
	
	public List<TaskOfFamily> filterByMemberFamilyId(int id){
		List<TaskOfFamily> list = taskList.getTaskList();
		list = list.stream().filter(task -> task.getFamilyMember().getId() == id).collect(Collectors.toList());
		return list;
	}

}
