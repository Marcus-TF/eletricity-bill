package com.electricitybill.service;

import com.electricitybill.entity.ClasseEntity;

import java.sql.SQLException;
import java.util.List;

public interface ClasseService {

    List<ClasseEntity> findAll();

    ClasseEntity findById(int id);

    ClasseEntity save(ClasseEntity entity);

    boolean update(int id, ClasseEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
