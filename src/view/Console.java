package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.people.People;
import model.entities.people.family.FamilyMember;
import model.entities.tasks.family.TaskOfFamily;
import model.services.people.PeopleService;
import model.services.people.PeopleServiceImp;
import model.services.tasklist.TaskListService;
import model.services.tasklist.TaskListServiceImp;

public class Console {

	PeopleService peopleService = new PeopleServiceImp();
	TaskListService taskListService = new TaskListServiceImp();
	Scanner scan = new Scanner(System.in);

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	public void console() {

		int menuNumber = 3;

		do {
			try {
				System.out.println();
				System.out.println("1 - Adicinar membro à familia");
				System.out.println("2 - Remover membro da familia");
				System.out.println("3 - Mostrar a familia");
				System.out.println("4 - mostrar lista de tarefas");
				System.out.println("5 - Adicinar nova tarefa");
				System.out.println("6 - remover tarefa");
				System.out.println("7 - modificar tarefa");
				System.out.println("8 - filtrar pelo id do membro da familia");
				System.out.println("9 - mostrar tarefas fora do prazo");
				System.out.println("10 - Sair");

				menuNumber = scan.nextInt();
				System.out.println();

				scan.nextLine();

				switch (menuNumber) {
				case 1:
					addFamilyMember();
					break;
				case 2:
					removeFamilyMember();
					break;
				case 3:
					showFamily();
					break;
				case 4:
					showTaskList();
					break;
				case 5:
					addTask();
					break;
				case 6:
					removeTask();
					break;
				case 7:
					updatedTask();
					break;
				case 8:
					filterByMemberFamily();
					break;
				case 9:
					showOutDeadLineTasks();
					break;
				default:
					System.out.println("Fim");
				}
			} catch (InputMismatchException e) {
				System.out.println("Erro de digitação");
			}
		} while (menuNumber != 10);
	}

	void showOutDeadLineTasks() {
		try {
			taskListService.getTaskListOutDeadLine().forEach(System.out::println);
		} catch (InputMismatchException e) {
			System.out.println("Erro de digitação");
		}
	}

	void filterByMemberFamily() {
		try {
			showFamily();
			System.out.print("which family member Id you want to filter ? ");
			int id = scan.nextInt();
			scan.nextLine();
			taskListService.filterByMemberFamilyId(id).forEach(System.out::println);
		} catch (InputMismatchException e) {
			System.out.println("Erro de digitação");
		}
	}

	void updatedTask() {
		try {
			showTaskList();
			System.out.println("which task will be upadate ? ");
			int idTask = scan.nextInt();
			scan.nextLine();
			System.out.print("New task name : ");
			String task = scan.nextLine();
			System.out.print("When will be the deadline (dd/MM/yyyy HH:mm) : ");
			LocalDateTime deadLine = LocalDateTime.parse(scan.nextLine(), fmt);
			System.out.print("Which family member ID will be responsable to do the task : ");
			int id = scan.nextInt();
			scan.nextLine();
			FamilyMember person = peopleService.filterById(id);
			if (person != null) {
				TaskOfFamily taskList = new TaskOfFamily(task, deadLine, person, idTask);
				boolean check = taskListService.updateTaskById(taskList);
				if (check) {
					System.out.println("Task updated !");
				} else {
					System.out.println("the task ID not found ");
				}
			} else {
				System.out.println("Member family Id not found !");
			}
		} catch (InputMismatchException e) {
			System.out.println("Erro de digitação");
		}

	}

	void removeTask() {
		try {
			showTaskList();
			System.out.print("Id task to be removed: ");
			int id = scan.nextInt();
			scan.nextLine();
			taskListService.removeTaskById(id);
			System.out.println("Task was removed");
		} catch (InputMismatchException e) {
			System.out.println("Erro de digitação");
		}

	}

	void addTask() {
		try {
			System.out.print("What is the new task :");
			String task = scan.nextLine();
			System.out.print("When will be the deadline (dd/MM/yyyy HH:mm) : ");
			LocalDateTime deadLine = LocalDateTime.parse(scan.nextLine(), fmt);
			showFamily();
			System.out.print("Which family member ID will be responsable to do the task : ");
			int id = scan.nextInt();
			scan.nextLine();
			FamilyMember person = peopleService.filterById(id);
			if (person != null) {
				TaskOfFamily taskList = new TaskOfFamily(task, deadLine, person);
				taskListService.addTask(taskList);
				System.out.println("Task add !");
			} else {
				System.out.println("Id not found !");
			}
		} catch (InputMismatchException e) {
			System.out.println("Erro de digitação");
		}
	}

	void showTaskList() {
		try {
			taskListService.getTaskList().forEach(System.out::println);
		} catch (InputMismatchException e) {
			System.out.println("Erro de digitação");
		}
	}

	void showFamily() {
		try {
			peopleService.getPeopleList().forEach(System.out::println);
		} catch (InputMismatchException e) {
			System.out.println("Erro de digitação");
		}
	}

	void addFamilyMember() {
		try {
			System.out.print("Name of new family member : ");
			String name = scan.nextLine();
			System.out.print("Age of new family member : ");
			int age = scan.nextInt();
			scan.nextLine();
			System.out.print("Family position of family member : ");
			String familyPosition = scan.nextLine();
			People familyMember = new FamilyMember(name, age, familyPosition);
			peopleService.addPeople(familyMember);
			System.out.println("New family member add ! ");
		} catch (InputMismatchException e) {
			System.out.println("Erro de digitação");
		}
	}

	void removeFamilyMember() {
		try {
			showFamily();
			System.out.print("Enter with the Id you want remove : ");
			int id = scan.nextInt();
			scan.nextLine();
			peopleService.removePeople(id);
			System.out.println("People Removed");
		} catch (InputMismatchException e) {
			System.out.println("Erro de digitação");
		}
	}
}
