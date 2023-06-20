package com.electricitybill.service;

import com.electricitybill.entity.TipoFaseEntity;

import java.sql.SQLException;
import java.util.List;

public interface TipoFaseService {

    List<TipoFaseEntity> findAll();

    TipoFaseEntity findById(int id);

    TipoFaseEntity save(TipoFaseEntity entity);

    boolean update(int id, TipoFaseEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
