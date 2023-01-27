package com.example.taskmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> addTask(@RequestBody  Task task){
        Map<String, Object> response = new HashMap<>();
        if(task!=null) {
            taskService.saveTask(task);

            response.put("task", task);
            response.put("status", "200");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            response.put("content", "No content");
            response.put("status", "204");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAllTask(){
        List<Task> tasks = taskService.getAllTask();
        Map<String, Object> response = new HashMap<>();
        if(!tasks.isEmpty()) {
            response.put("events", tasks);
            response.put("status", "200");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            response.put("content", "No content");
            response.put("status", "204");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }
}
