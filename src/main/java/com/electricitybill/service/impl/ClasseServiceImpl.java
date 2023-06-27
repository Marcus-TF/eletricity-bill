package com.electricitybill.service.impl;

import com.electricitybill.entity.ClasseEntity;
import com.electricitybill.repository.ClasseRepository;
import com.electricitybill.service.ClasseService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class ClasseServiceImpl implements ClasseService {

    private final ClasseRepository classeRepository;

    @Override
    public List<ClasseEntity> findAll() {
        if (classeRepository.findAll().isEmpty()) {
            throw new NoResultException("Search not found!");
        }
        return classeRepository.findAll();
    }

    @Override
    public ClasseEntity findById(int id) {
        if (Objects.isNull(classeRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return classeRepository.findById(id);
    }

    @Override
    public ClasseEntity save(ClasseEntity entity) {
        return classeRepository.save(entity);
    }

    @Override
    public boolean update(int id, ClasseEntity entity) throws SQLException {
        if (Objects.isNull(classeRepository.findById(id))) {
            throw new NoResultException("Class not found!");
        }
        return classeRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(classeRepository.findById(id))) {
            throw new NoResultException("Class not found!");
        }
        return classeRepository.delete(id);
    }
}
