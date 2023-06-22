package com.electricitybill.service;

import com.electricitybill.entity.RotaEntity;

import java.sql.SQLException;
import java.util.List;

public interface RotaService {

    List<RotaEntity> findAll();

    RotaEntity findById(int id);

    RotaEntity save(RotaEntity entity);

    boolean update(int id, RotaEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
