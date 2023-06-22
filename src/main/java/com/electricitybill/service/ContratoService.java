package com.electricitybill.service;

import com.electricitybill.entity.ContratoEntity;

import java.sql.SQLException;
import java.util.List;

public interface ContratoService {

    List<ContratoEntity> findAll();

    ContratoEntity findById(int id);

    ContratoEntity save(ContratoEntity entity);

    boolean update(int id, ContratoEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
