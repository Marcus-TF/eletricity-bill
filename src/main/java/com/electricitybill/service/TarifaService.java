package com.electricitybill.service;

import com.electricitybill.entity.TarifaEntity;

import java.sql.SQLException;
import java.util.List;

public interface TarifaService {

    List<TarifaEntity> findAll();

    TarifaEntity findById(int id);

    TarifaEntity save(TarifaEntity entity);

    boolean update(int id, TarifaEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
