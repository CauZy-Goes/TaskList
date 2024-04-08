package model.entities.tasks;

import java.time.LocalDateTime;

public abstract class Task {
	
	protected static Integer idCounter = 0;
 
	protected String task;
	protected LocalDateTime deadLine;
	protected int id;

	public Task(String task) {
		this.task = task;
	}
	
	public Task(String task, LocalDateTime deadLine) {
		this.task = task;
		this.deadLine = deadLine;
	}
	
	public Task(String task, LocalDateTime deadLine, int id) {
		super();
		this.task = task;
		this.deadLine = deadLine;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalDateTime getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(LocalDateTime deadLine) {
		this.deadLine = deadLine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deadLine == null) ? 0 : deadLine.hashCode());
		result = prime * result + ((task == null) ? 0 : task.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (deadLine == null) {
			if (other.deadLine != null)
				return false;
		} else if (!deadLine.equals(other.deadLine))
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		return true;
	}
	
	
	
	
}
