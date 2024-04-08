package model.entities.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskList<T extends Task> {  

    List<T> taskList = new ArrayList<>();

    public List<T> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<T> taskList) {
        this.taskList = taskList;
    }
}
