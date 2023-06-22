package com.electricitybill.service.impl;

import com.electricitybill.entity.ClasseEntity;
import com.electricitybill.repository.ClasseRepository;
import com.electricitybill.service.ClasseService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class ClasseServiceImpl implements ClasseService {

    private final ClasseRepository classeRepository;

    @Override
    public List<ClasseEntity> findAll() {
        return classeRepository.findAll();
    }

    @Override
    public ClasseEntity findById(int id) {
        return classeRepository.findById(id);
    }

    @Override
    public ClasseEntity save(ClasseEntity entity) {
        return classeRepository.save(entity);
    }

    @Override
    public boolean update(int id, ClasseEntity entity) throws SQLException {
        return classeRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return classeRepository.delete(id);
    }
}
