package com.electricitybill.service;

import com.electricitybill.entity.TimeRotaEntity;

import java.sql.SQLException;
import java.util.List;

public interface TimeRotaService {

    List<TimeRotaEntity> findAll();

    TimeRotaEntity findById(int id);

    TimeRotaEntity save(TimeRotaEntity entity);

    boolean update(int id, TimeRotaEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
