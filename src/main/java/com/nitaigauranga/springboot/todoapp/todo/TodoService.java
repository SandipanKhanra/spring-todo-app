package com.nitaigauranga.springboot.todoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();

	private static int todoCount = 0;
	static {
		todos.add(new Todo(++todoCount, "Gauranga", "Chant Hari hari", LocalDate.now(), true));
		todos.add(new Todo(++todoCount, "Nitai", "Chant Gaurhari", LocalDate.now().plusYears(1), true));
		todos.add(new Todo(++todoCount, "Gaur", "Chant 108 rounds", LocalDate.now().plusWeeks(6), false));
		todos.add(new Todo(++todoCount, "Madhav", "Chant and be happy", LocalDate.now().plusMonths(3), true));
		todos.add(new Todo(++todoCount, "Krishna", "The Supreme Personality of Godhead", LocalDate.now().plusDays(108),
				true));
	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todoCount, username, description, targetDate, done);
		todos.add(todo);
	}

	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
