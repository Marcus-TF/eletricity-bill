package com.electricitybill.service;

import com.electricitybill.entity.MedidorEntity;

import java.sql.SQLException;
import java.util.List;

public interface MedidorService {

    List<MedidorEntity> findAll();

    MedidorEntity findById(int id);

    MedidorEntity save(MedidorEntity entity);

    boolean update(int id, MedidorEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
