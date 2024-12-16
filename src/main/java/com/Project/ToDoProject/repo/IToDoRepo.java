package com.Project.ToDoProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.ToDoProject.model.ToDo;


@Repository
public interface IToDoRepo extends JpaRepository<ToDo,Long>{
	

}
