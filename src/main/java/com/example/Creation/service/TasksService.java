package com.example.Creation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Creation.domain.Tasks;
import com.example.Creation.repository.TasksRepository;

@Service
public class TasksService {
	
    @Autowired
    private TasksRepository repo;
	
    public List<Tasks> listAll() {
        System.out.println("List All");
        return repo.findAll();
    }
     
    public void save(Tasks std) {
        System.out.println("Save");
        repo.save(std);
    }
     
    public Tasks get(long id) {
        System.out.println("Get");
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        System.out.println("Delete");
        repo.deleteById(id);
    }

}