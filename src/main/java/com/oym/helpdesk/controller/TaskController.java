package com.oym.helpdesk.controller;

import com.oym.helpdesk.domain.Task;
import com.oym.helpdesk.model.ResponseWrapper;
import com.oym.helpdesk.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    private Task task;

    private void init(){
        task = new Task();
    }

    public void initNew(){
        init();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            params = {"page", "size"})
    public ResponseEntity<ResponseWrapper> findAll(int page, int size) {
        List<Task> tasks = taskService.findAll(page, size);

        HttpStatus status = HttpStatus.OK;
        ResponseWrapper wrapper = ResponseWrapper.of(tasks);

        if(tasks.isEmpty()) {
            status = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(status).body(wrapper);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> save(@RequestBody Task task){

        taskService.saveTask(task);

        return new  ResponseEntity<>(task,HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> update(@RequestBody Task task){

        taskService.updateTask(task);

        return new ResponseEntity<>(task,HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> delete(@RequestBody Task task){

        taskService.deleteTask(task);

        return new  ResponseEntity<>(task, HttpStatus.OK);
    }
}