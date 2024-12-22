package org.example.springbootdemo.repository;

import org.example.springbootdemo.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClazzRepository extends JpaRepository<Clazz, Integer> {
}
