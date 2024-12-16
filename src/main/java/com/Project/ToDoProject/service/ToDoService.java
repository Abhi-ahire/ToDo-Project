package com.Project.ToDoProject.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.ToDoProject.model.ToDo;
import com.Project.ToDoProject.repo.IToDoRepo;

@Service
public class ToDoService {
	
	
	@Autowired
    IToDoRepo repo;
	public List <ToDo> getAllToDoItems(){
		ArrayList<ToDo>todoList=new ArrayList<>();
		repo.findAll().forEach(todo -> todoList.add(todo));
		return todoList;
	}
	public ToDo getToDoItemById(Long id){
		return repo.findById(id).get();
	}
	
    public boolean updateStstus(Long id){
		ToDo todo=getToDoItemById(id);
		todo.setStatus("completed");
		
		return saveOrUpdateToDoItem(todo);
		
		}
	
   public boolean saveOrUpdateToDoItem(ToDo todo){
		ToDo updatedobj=repo.save(todo);
		
		if(getToDoItemById(updatedobj.getId())!=null) {
			return true;
		}
		return false;
	
	}
	
   public  boolean deleteToDoItem(Long id) {
	   repo.deleteById(id);

		if( repo.findById(id)==null) {
			return true;
		}
		return false;
	
		
		
	
	
	}
    
}


