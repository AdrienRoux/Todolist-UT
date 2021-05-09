package com.todolist.service;

import com.todolist.model.Item;
import com.todolist.model.TodoList;
import com.todolist.repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService{

    TodoListRepository toDoListRepository;

    @Override
    public List<TodoList> getTodoLists() {
        List<TodoList> toDoLists = new ArrayList<>();
        toDoListRepository.findAll().forEach(toDoLists::add);
        return toDoLists;

    }

    @Override
    public TodoList getTodoListById(long id) {
        return toDoListRepository.findById(id).get();
    }

    @Override
    public TodoList addItem(long id, Item item) {
        TodoList todoList = toDoListRepository.findById(id).get();
        todoList.addItem(item);
        toDoListRepository.save(todoList);
        return todoList;
    }

    @Override
    public void deleteTodoList(long id) {
        toDoListRepository.deleteById(id);
    }
}
