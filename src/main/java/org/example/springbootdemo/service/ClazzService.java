package org.example.springbootdemo.service;

import org.example.springbootdemo.model.Clazz;
import org.example.springbootdemo.repository.IClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzService implements IClazzService{
    @Autowired
    private IClazzRepository clazzRepository;
    @Override
    public List<Clazz> findAll() {
        return clazzRepository.findAll();
    }

}
