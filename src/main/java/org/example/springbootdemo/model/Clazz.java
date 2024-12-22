package org.example.springbootdemo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Clazz {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "clazz",fetch = FetchType.LAZY)
    private List<Student> students;

    public Clazz() {
    }

    public Clazz(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
