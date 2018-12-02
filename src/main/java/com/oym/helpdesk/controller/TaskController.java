package com.oym.helpdesk.controller;

import com.oym.helpdesk.domain.Task;
import com.oym.helpdesk.model.ResponseWrapper;
import com.oym.helpdesk.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

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
}