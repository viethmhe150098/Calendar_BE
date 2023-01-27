package com.example.taskmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public Task saveTask(Task task){
        taskRepository.save(task);
        return task;
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }
}
