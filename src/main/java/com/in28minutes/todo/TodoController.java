package com.in28minutes.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value = "/list-todos", method= RequestMethod.GET)
	public String listTodos(ModelMap model) {
		model.addAttribute("todos",service.retrieveTodos("carla"));
		return "list-todos"; //returns list-todos view
	}
	
	@RequestMapping(value = "/add-todo", method= RequestMethod.GET)
	public String showTodoPage() {
		return "todo"; // wil lbe translated to todo.jsp
	}
	
	@RequestMapping(value = "/add-todo", method= RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String desc) {
		model.clear();
		service.addTodo("carla",desc,new Date(), false );
		return "redirect:list-todos"; 
	}
	
	@RequestMapping(value = "/delete-todo", method= RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		model.clear();
		service.deleteTodo(id);
		return "redirect:list-todos"; 
	}
}
