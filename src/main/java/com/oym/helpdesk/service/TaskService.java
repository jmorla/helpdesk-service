package com.oym.helpdesk.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.oym.helpdesk.domain.Task;
import com.oym.helpdesk.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @HystrixCommand(fallbackMethod = "findAllFallBack")
    public List<Task> findAll(int page, int size) {

        Page<Task> result = taskRepository.findAll(PageRequest.of(page, size));
        return result.getContent();
    }

    public List<Task> findAllFallBack(int page, int size) {

        Task task = new Task();
        task.setDescription("Error trying to retrieve data from datasource");
        return Collections.singletonList(task);
    }
}
