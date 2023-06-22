package com.electricitybill.service;

import com.electricitybill.entity.CobrancaEntity;

import java.sql.SQLException;
import java.util.List;

public interface CobrancaService {

    List<CobrancaEntity> findAll();

    CobrancaEntity findById(int id);

    CobrancaEntity save(CobrancaEntity entity);

    boolean update(int id, CobrancaEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
