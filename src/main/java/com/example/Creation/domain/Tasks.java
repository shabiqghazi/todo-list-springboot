package com.example.Creation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String task_name;
    private boolean keterangan;

    public Tasks() {
    }

    public Tasks(Long id, String task_name, boolean keterangan) {
        this.id = id;
        this.task_name = task_name;
        this.keterangan = keterangan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public boolean getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(boolean keterangan) {
        this.keterangan = keterangan;
    }



}