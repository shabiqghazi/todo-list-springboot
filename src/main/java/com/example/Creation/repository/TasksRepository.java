package com.example.Creation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Creation.domain.Tasks;


@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

}