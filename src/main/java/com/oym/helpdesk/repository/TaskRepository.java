package com.oym.helpdesk.repository;

import com.oym.helpdesk.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String>{

    List<Task> findByOwner_Id(String id);

    List<Task> findByAssigned_Id(String id);
}
