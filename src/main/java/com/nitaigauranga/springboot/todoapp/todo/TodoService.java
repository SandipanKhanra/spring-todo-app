package com.nitaigauranga.springboot.todoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo(1, "Gauranga", "Chant Hari hari", LocalDate.now(), true));
		todos.add(new Todo(2, "Nitai", "Chant Gaurhari", LocalDate.now().plusYears(1), true));
		todos.add(new Todo(3, "Gaur", "Chant 108 rounds", LocalDate.now().plusWeeks(6), false));
		todos.add(new Todo(4, "Madhav", "Chant and be happy", LocalDate.now().plusMonths(3), true));
		todos.add(new Todo(5, "Krishna", "The Supreme Personality of Godhead", LocalDate.now().plusDays(108), true));
	}

	public List<Todo> findByUsername(String username){
		return todos;
	}
}
