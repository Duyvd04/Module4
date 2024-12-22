package org.example.springbootdemo.repository;

import org.example.springbootdemo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    // Spring data JPA projection
    // Class DTO / Interface DTO
//    bealdung, viblo, gpcoder
    @Query(value="select s from Student s join fetch s.clazz")
    Page<Student> findAll(Pageable pageable);
}
